package org.alia4j.noirin.debug.connection;

import java.io.IOException;

import org.alia4j.addb.util.DataUtil;

public class AddbReplyPacket extends AddbPacket {
	// Status Code
	final public static byte STATUS_OK = 0;
	final public static byte STATUS_START = 1;
	
	private byte fErrorCode = 0;
	private byte fIsEvent = 0;
	
	public AddbReplyPacket() {
		setFlags(FLAG_REPLY_PACKET);
	}
	
	public short errorCode() {
		return fErrorCode;
	}
	
	public void setErrorCode(byte newValue) {
		fErrorCode = newValue;
	}
	
	public void setEvent() {
		fIsEvent = 1;
	}
	
	public boolean isEvent() {
		return fIsEvent == 1;
	}
	
	protected int readSpecificHeaderFields(byte[] bytes, int index) throws IOException {
		fErrorCode =  bytes[index];
		fIsEvent =  bytes[index+1];
		return 2;
	}

	protected int writeSpecificHeaderFields(byte[] bytes, int index) throws IOException {
        bytes[index] = fErrorCode ;
        bytes[index+1] = fIsEvent;
        return 2;
	}
	
	public String toString() {
	    StringBuffer buf = new StringBuffer();
	    buf.append("Reply packet[" + fId +"]\n");
	    buf.append("\tlength:" + this.getLength());
	    buf.append("\terrorCode:").append(errorCode());
	    buf.append("\tevent:").append(isEvent());
	    buf.append("\tData:");
	    if(fDataBuf != null) {
	    	buf.append(DataUtil.bytesToInt(fDataBuf, 0));
	    } else {
	    	buf.append("null");
	    }
	    return buf.toString();
	}
}
