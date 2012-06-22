package org.alia4j.noirin.debug.connection;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import org.alia4j.addb.util.DataUtil;


public abstract class AddbPacket {
	public static final byte FLAG_REPLY_PACKET = (byte)0x80;
	protected static final int MIN_PACKET_LENGTH = 11;
	
	protected int fId = 0;
	protected byte fFlags = 0;
	protected byte[] fDataBuf = null;
	

	public void setId(int id) {
		fId = id;
	}

	public int getId() {
		return fId;
	}
	
	void setFlags(byte flags) {
		fFlags = flags;
	}
	

	public byte getFlags() {
		return fFlags;
	}

	public int getLength() {
		return MIN_PACKET_LENGTH + getDataLength();
	}
	
	public int getDataLength() {
		return fDataBuf == null ? 0 : fDataBuf.length;
	}
	
	public byte[] getData() {
		return fDataBuf;
	}

	public void setData(byte[] data) {
		fDataBuf = data;
	}
	
	public DataInputStream dataInStream() {
		if (fDataBuf != null) {
			return new DataInputStream(new ByteArrayInputStream(fDataBuf));
		}
		return new DataInputStream(new ByteArrayInputStream(new byte[0]));
	}

	protected abstract int readSpecificHeaderFields(byte[] bytes, int index) throws IOException;
	

	protected abstract int writeSpecificHeaderFields(byte[] bytes, int index) throws IOException;
	

	public static AddbPacket build(byte[] bytes) throws IOException {

		int packetLength = DataUtil.bytesToInt(bytes, 0);
		int id = DataUtil.bytesToInt(bytes, 4);;

		// flags (byte)
		byte flags = bytes[8];

		// Determine type: command or reply.
		AddbPacket packet;
		if ((flags & FLAG_REPLY_PACKET) != 0)
			packet = new AddbReplyPacket();
		else
			packet = new AddbCommandPacket();
			
		// Assign generic header fields.
		packet.setId(id);
		packet.setFlags(flags);
			
		// Read specific header fields and data.
		int index = 9;
		index += packet.readSpecificHeaderFields(bytes, 9);
		if (packetLength - MIN_PACKET_LENGTH > 0) {
			packet.fDataBuf = new byte[packetLength - MIN_PACKET_LENGTH];
			System.arraycopy(bytes, index, packet.fDataBuf, 0, packet.fDataBuf.length);
		}
		
		return packet;
	}
	
	public byte[] getPacketAsBytes() throws IOException {
	    int len = getLength();
	    byte[] bytes = new byte[len];
	    
	    byte[] lenByte = DataUtil.intToBytes(len);
	    System.arraycopy(lenByte, 0, bytes, 0, 4);
	    
	    byte[] idByte = DataUtil.intToBytes(fId);
	    System.arraycopy(idByte, 0, bytes, 4, 4);
        
        bytes[8] = getFlags();
        
        //convert specific header fields
        int index = 9;
        index += writeSpecificHeaderFields(bytes, index);
        
        if (index < len && fDataBuf!=null) {
            //copy data
            System.arraycopy(fDataBuf, 0, bytes, index, fDataBuf.length);
        }
        return bytes;
	}
}
