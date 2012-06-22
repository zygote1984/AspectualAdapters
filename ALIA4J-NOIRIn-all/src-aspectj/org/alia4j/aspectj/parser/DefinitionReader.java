package org.alia4j.aspectj.parser;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.alia4j.aspectj.parser.ast.AJPointcutParser;
import org.alia4j.aspectj.parser.ast.ParseException;
import org.alia4j.aspectj.parser.ast.SimpleNode;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Refer to chapter 5 of AspectJ programmer's guide.
 * 
 * @author Christoph Bockisch
 */
class DefinitionReader {
    
    /*
     * aspectsIncludes and -Excludes specify lists ClassNamePatternExpressions. If both lists are empty, any defined aspect
     * is deployed. Otherwise only aspects are deployed whose names are matched by at least one of the includes patterns and
     * not by any of the excludes patterns. Only aspects declared within an aop.xml (through <aspect> or <concrete-aspect>)
     * are considered. Include and exclude patterns can not be used to search for aspects. Root node:
     * ASTClassnamePatternExpression: OrClassnamePatternExpression, AndClassnamePatternExpression,
     * UnaryClassnamePatternExpression, NegatedClassnamePatternExpression, BasicClassnamePatternExpression
     */
    private final List<SimpleNode> aspectsIncludes = new ArrayList<SimpleNode>();
    
    private final List<SimpleNode> aspectsExcludes = new ArrayList<SimpleNode>();
    
    /*
     * Fully qualified names of Java classes that are compiled from aspect and contain the pointcut definitions.
     */
    private final List<String> aspectsAspectNames = new ArrayList<String>();
    
    /*
     * The merged command line options specified in all aop.xml files. The options from the distinct files are separated by a
     * space. For options that are multiply defined and have a value the value of the most recent definition is used. I.e.,
     * the value of the aop.xml that was latest in the class path search order.
     */
    private String weaverOptions = "";
    
    /*
     * weaverIncludes and -Excludes specify lists ClassNamePatternExpressions. If both lists are empty, any class is woven.
     * Otherwise only classes are woven whose names are matched by at least one of the includes patterns and not by any of
     * the excludes patterns.
     */
    private final List<SimpleNode> weaverIncludes = new ArrayList<SimpleNode>();
    
    private final List<SimpleNode> weaverExcludes = new ArrayList<SimpleNode>();
    
    /*
     * Specifies a list of ClassNamePatternExpressions. Classes that match any of these patterns are written out to "./_dump"
     * folder after (re-)weaving.
     */
    private final List<SimpleNode> weaverDumps = new ArrayList<SimpleNode>();
    
    /**
     * Read in all META-INF/aop-ajc.xml files found in the system class path. Merge them as defined in chapter 5 of AspectJ
     * documentation.
     * 
     * @param applicationClassLoader
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws ParseException
     */
    protected DefinitionReader(final ClassLoader applicationClassLoader) throws SAXException, IOException,
                    ParserConfigurationException, ParseException {
        final DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        
        final Enumeration<URL> aspectDefinitionFiles = applicationClassLoader.getResources("META-INF/aop-ajc.xml");
        while (aspectDefinitionFiles.hasMoreElements()) {
            final URL currentURL = aspectDefinitionFiles.nextElement();
            try {
                final Document doc = docBuilder.parse(currentURL.openStream());
                // Normalize text representation
                doc.getDocumentElement().normalize();
                
                this.readAspectDefinitionFile(doc, currentURL);
            } catch (final IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    private void readAspectDefinitionFile(final Document doc, final URL docURL) throws ParseException {
        final Node aspectJNode = this.getNode(doc, docURL, "aspectj");
        final Node aspectsNode = this.getOptionalNode(aspectJNode, docURL, "aspects");
        if (aspectsNode != null)
            this.readAspectsElement(aspectsNode, docURL);
        
        final Node weaverNode = this.getOptionalNode(aspectJNode, docURL, "weaver");
        if (weaverNode != null)
            this.readWeaverElement(weaverNode, docURL);
    }
    
    private void readAspectsElement(final Node aspectsNode, final URL docURL) throws ParseException {
        final List<Node> includeNodes = this.getOptionalNodeList(aspectsNode, docURL, "include");
        Iterator<Node> it = includeNodes.iterator();
        while (it.hasNext()) {
            final Node includeWithinNode = this.getAttribute(it.next(), docURL, "within");
            final String includeWithin = includeWithinNode.getNodeValue();
            final AJPointcutParser parser = new AJPointcutParser(new StringReader(includeWithin));
            parser.ClassnamePatternExpressionAlternativeOperators();
            this.aspectsIncludes.add(parser.getTreeRoot());
        }
        
        final List<Node> excludeNodes = this.getOptionalNodeList(aspectsNode, docURL, "exclude");
        it = excludeNodes.iterator();
        while (it.hasNext()) {
            final Node excludeWithinNode = this.getAttribute(it.next(), docURL, "within");
            final String excludeWithin = excludeWithinNode.getNodeValue();
            final AJPointcutParser parser = new AJPointcutParser(new StringReader(excludeWithin));
            parser.ClassnamePatternExpressionAlternativeOperators();
            this.aspectsExcludes.add(parser.getTreeRoot());
        }
        
        final List<Node> aspectNodes = this.getOptionalNodeList(aspectsNode, docURL, "aspect");
        it = aspectNodes.iterator();
        while (it.hasNext()) {
            final Node aspectNameNode = this.getAttribute(it.next(), docURL, "name");
            final String aspectName = aspectNameNode.getNodeValue();
            this.aspectsAspectNames.add(aspectName);
        }
        
        final List<Node> concreteAspectNodes = this.getOptionalNodeList(aspectsNode, docURL, "concrete-aspect");
        if (!concreteAspectNodes.isEmpty())
            throw new IllegalArgumentException("Element <concrete-aspect> not supported (" + docURL + ").");
    }
    
    private void readWeaverElement(final Node weaverNode, final URL docURL) throws ParseException {
        final Node optionsNode = this.getOptionalNode(weaverNode, docURL, "options");
        if (optionsNode != null) {
            this.weaverOptions += " " + optionsNode.getNodeValue();
        }
        
        final List<Node> includeNodes = this.getOptionalNodeList(weaverNode, docURL, "include");
        Iterator<Node> it = includeNodes.iterator();
        while (it.hasNext()) {
            final Node includeWithinNode = this.getAttribute(it.next(), docURL, "within");
            final String includeWithin = includeWithinNode.getNodeValue();
            final AJPointcutParser parser = new AJPointcutParser(new StringReader(includeWithin));
            parser.ClassnamePatternExpressionAlternativeOperators();
            this.aspectsIncludes.add(parser.getTreeRoot());
        }
        
        final List<Node> excludeNodes = this.getOptionalNodeList(weaverNode, docURL, "exclude");
        it = excludeNodes.iterator();
        while (it.hasNext()) {
            final Node excludeWithinNode = this.getAttribute(it.next(), docURL, "within");
            final String excludeWithin = excludeWithinNode.getNodeValue();
            final AJPointcutParser parser = new AJPointcutParser(new StringReader(excludeWithin));
            parser.ClassnamePatternExpressionAlternativeOperators();
            this.aspectsExcludes.add(parser.getTreeRoot());
        }
        
        final List<Node> dumpNodes = this.getOptionalNodeList(weaverNode, docURL, "dump");
        it = dumpNodes.iterator();
        while (it.hasNext()) {
            final Node dumpWithinNode = this.getAttribute(it.next(), docURL, "within");
            final String excludeWithin = dumpWithinNode.getNodeValue();
            final AJPointcutParser parser = new AJPointcutParser(new StringReader(excludeWithin));
            parser.ClassnamePatternExpressionAlternativeOperators();
            this.weaverDumps.add(parser.getTreeRoot());
        }
    }
    
    private Node getAttribute(final Node node, final URL docURL, final String attributeName) {
        final Node result = node.getAttributes().getNamedItem(attributeName);
        if (result == null) {
            throw new IllegalArgumentException("Required node missing (" + attributeName + ", " + docURL + ").");
        }
        // if one node was found, return it,
        // if no node was found, an exception has been thrown
        return result;
    }
    
    private Node getNode(final Node node, final URL docURL, final String nodeName) {
        final NodeList children = node.getChildNodes();
        Node result = null;
        for (int i = 0; i < children.getLength(); i++) {
            final Node currentNode = children.item(i);
            if (currentNode.getNodeName().equals(nodeName)) {
                if (result != null) {
                    throw new IllegalArgumentException("Multiple nodes, where only 1 is allowed (" + nodeName + ", "
                                    + docURL + ").");
                } else {
                    result = currentNode;
                }
            }
        }
        if (result == null) {
            throw new IllegalArgumentException("Required node missing (" + nodeName + ", " + docURL + ").");
        }
        // if one node was found, return it,
        // if no node was found, an exception has been thrown
        // if multiple nodes were found, an exception has been thrown
        return result;
    }
    
    private Node getOptionalNode(final Node node, final URL docURL, final String nodeName) {
        final NodeList children = node.getChildNodes();
        Node result = null;
        for (int i = 0; i < children.getLength(); i++) {
            final Node currentNode = children.item(i);
            if (currentNode.getNodeName().equals(nodeName)) {
                if (result != null) {
                    throw new IllegalArgumentException("Multiple nodes, where only 0 or 1 is allowed (" + nodeName + ", "
                                    + docURL + ").");
                } else {
                    result = currentNode;
                }
            }
        }
        // if one node was found, return it,
        // if no node was found, return null
        // if multiple nodes were found, an exception has been thrown
        return result;
    }
    
    private List<Node> getOptionalNodeList(final Node node, final URL docURL, final String nodeName) {
        final NodeList children = node.getChildNodes();
        final List<Node> result = new ArrayList<Node>();
        for (int i = 0; i < children.getLength(); i++) {
            final Node currentNode = children.item(i);
            if (currentNode.getNodeName().equals(nodeName)) {
                result.add(currentNode);
            }
        }
        return result;
    }
    
    public List<SimpleNode> getAspectsIncludes() {
        return this.aspectsIncludes;
    }
    
    public List<SimpleNode> getAspectsExcludes() {
        return this.aspectsExcludes;
    }
    
    public List<String> getAspectsAspectNames() {
        return this.aspectsAspectNames;
    }
    
    public String getWeaverOptions() {
        return this.weaverOptions;
    }
    
    public List<SimpleNode> getWeaverIncludes() {
        return this.weaverIncludes;
    }
    
    public List<SimpleNode> getWeaverExcludes() {
        return this.weaverExcludes;
    }
    
    public List<SimpleNode> getWeaverDumps() {
        return this.weaverDumps;
    }
}
