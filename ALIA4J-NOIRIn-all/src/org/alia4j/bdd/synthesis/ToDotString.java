package org.alia4j.bdd.synthesis;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Set;
import org.alia4j.bdd.vertex.Sink;
import org.alia4j.bdd.vertex.Split;
import org.alia4j.bdd.vertex.UnaryOperation;
import org.alia4j.bdd.vertex.Vertex;

/**
 * Constructs a DOT representation of a given BDD. Note that, since this operation uses memoiziation, vertices are only
 * printed once.
 * 
 * @author Andreas Sewe
 * @see <a href="http://www.graphviz.org/doc/info/lang.html">The DOT Language</a>
 */
public final class ToDotString<X, Y> extends UnaryOperation<X, Y, String> {
    
    @Override
    public String visit(final Split<X, Y> split) {
        if (this.visitedVertices.contains(split))
            return "";
        else
            this.visitedVertices.add(split);
        
        final StringBuffer dot = new StringBuffer();
        
        dot.append(ToDotString.getUID(split));
        dot.append("[label=\"");
        dot.append(split.getVariable().toString());
        dot.append("\",shape=rect]; ");
        dot.append(ToDotString.getUID(split));
        dot.append(" -> ");
        dot.append(ToDotString.getUID(split.getLow()));
        dot.append("[style=dashed]; ");
        dot.append(ToDotString.getUID(split));
        dot.append(" -> ");
        dot.append(ToDotString.getUID(split.getHigh()));
        dot.append("[style=solid]; ");
        dot.append(this.apply(split.getLow()));
        dot.append(this.apply(split.getHigh()));
        
        return dot.toString();
    }
    
    @Override
    public String visit(final Sink<X, Y> sink) {
        if (this.visitedVertices.contains(sink))
            return "";
        else
            this.visitedVertices.add(sink);
        
        final StringBuffer dot = new StringBuffer();
        
        dot.append(ToDotString.getUID(sink));
        dot.append("[label=\"");
        dot.append(sink.toString());
        dot.append("\",shape=circle]; ");
        
        return dot.toString();
    }
    
    private final Set<Vertex<X, Y>> visitedVertices = new HashSet<Vertex<X, Y>>();
    
    private static IdentityHashMap<Split<?, ?>, Integer> splitUIDs = new IdentityHashMap<Split<?, ?>, Integer>();
    
    private static IdentityHashMap<Sink<?, ?>, Integer> sinkUIDs = new IdentityHashMap<Sink<?, ?>, Integer>();
    
    private static IdentityHashMap<Vertex<?, ?>, Integer> vertexUIDs = new IdentityHashMap<Vertex<?, ?>, Integer>();
    
    private static int nextUID = 0;
    
    private static synchronized int getUID(final Split<?, ?> split) {
        if (ToDotString.splitUIDs.containsKey(split))
            return ToDotString.splitUIDs.get(split);
        else {
            final int uid = ToDotString.nextUID;
            ToDotString.nextUID++;
            ToDotString.splitUIDs.put(split, uid);
            return uid;
        }
    }
    
    private static synchronized int getUID(final Sink<?, ?> sink) {
        if (ToDotString.sinkUIDs.containsKey(sink))
            return ToDotString.sinkUIDs.get(sink);
        else {
            final int uid = ToDotString.nextUID;
            ToDotString.nextUID++;
            ToDotString.sinkUIDs.put(sink, uid);
            return uid;
        }
    }
    
    private static synchronized int getUID(final Vertex<?, ?> vertex) {
        if (ToDotString.vertexUIDs.containsKey(vertex))
            return ToDotString.vertexUIDs.get(vertex);
        else {
            final int uid = ToDotString.nextUID;
            ToDotString.nextUID++;
            ToDotString.vertexUIDs.put(vertex, uid);
            return uid;
        }
    }
    
}
