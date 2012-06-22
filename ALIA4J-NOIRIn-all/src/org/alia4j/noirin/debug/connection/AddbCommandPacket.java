package org.alia4j.noirin.debug.connection;

import java.io.IOException;

import org.alia4j.addb.util.AddbCommand;
import org.alia4j.addb.util.DataUtil;


public class AddbCommandPacket extends AddbPacket {
	private static int fgNextId = 1;
	private int fCommand;
	
	protected AddbCommandPacket() {
	}
	
	public AddbCommandPacket(int command) {
		setCommand(command);
		setId(getNewId());
	}
	
	public static synchronized int getNewId() {
		return fgNextId++;
	}
	
	public byte getCommandSet() {
		return (byte)(fCommand >>> 8);
	}
	
	public int getCommand() {
		return fCommand;
	}
	
	public void setCommand(int command) {
		fCommand = command;
	}

	@Override
	protected int readSpecificHeaderFields(byte[] bytes, int index) throws IOException {
		byte commandSet = bytes[index];
		fCommand = bytes[index+1]  + (commandSet << 8);
		return 2;
	}

	@Override
	protected int writeSpecificHeaderFields(byte[] bytes, int index) throws IOException {
		bytes[index] = getCommandSet();
	    bytes[index+1] = (byte) fCommand;
	    return 2;
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Command packet[" + fId +"]\n");
		buf.append("\tlength:" + this.getLength());
		buf.append("\tcommand:").append(AddbCommand.commandName(fCommand));
		if(this.getDataLength()==4)
			buf.append("\tID:"+ DataUtil.bytesToInt(fDataBuf, 0));
		return buf.toString();
	}
}
