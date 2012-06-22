package zygote.instancepc.lib.alia4j;

import java.io.StringReader;

import org.alia4j.aspectj.parser.ast.AJPointcutParser;


public class ALIA4JParser {
	
	
	public static AJPointcutParser parseExpression(String pcexp){
		
		System.out.println("[ALIA4JPARSER] : Parse --> " + pcexp);
		AJPointcutParser parser = new AJPointcutParser(new StringReader(pcexp));		
		try {
            parser.PointcutExpression();
            return parser;    
		} catch (final Exception e) {
            throw new RuntimeException("While parsing pointcut " + pcexp, e);
        }
	}


}
