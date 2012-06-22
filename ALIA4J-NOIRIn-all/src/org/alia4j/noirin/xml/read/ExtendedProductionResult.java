package org.alia4j.noirin.xml.read;

public class ExtendedProductionResult {
	private boolean isExtended;
	private Object result;
	
	public ExtendedProductionResult(boolean isExtended) {
		this(isExtended, null);
	}
	
	public ExtendedProductionResult(Object obj) {
		this(true, obj);
	}
	
	public ExtendedProductionResult(boolean isExtended, Object obj) {
		this.isExtended = isExtended;
		this.result = obj;
	}
	
	public boolean isExtended() {
		return isExtended;
	}
	
	public Object result() {
		return result;
	}
}
