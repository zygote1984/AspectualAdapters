package org.alia4j.noirin.debug.data;

public class ADBreakpoint {
	private int id;
	private String fileName;
	private int lineNumber;
	private boolean isChecked;
	
	public ADBreakpoint(String fileName, int lineNumber) {
		this.fileName = fileName;
		this.lineNumber = lineNumber;
		this.isChecked = true;
	}
	
	public String getFileName() {
		return fileName;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public boolean isChecked() {
		return isChecked;
	}
	
	void setId(int i) {
		id = i;
	}
	int getId(){
		return id;
	}
	void check() {
		isChecked = true;
	}
	void uncheck() {
		isChecked = false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof ADBreakpoint)) {
			return false;
		}
		ADBreakpoint that = (ADBreakpoint)obj;
		if(!this.fileName.equals(that.getFileName())) {
			return false;
		}
		if(this.lineNumber != that.getLineNumber()) {
			return false;
		}
		return true;
	}
}