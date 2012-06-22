package org.alia4j.noirin.debug.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.alia4j.addb.util.DataUtil;

public abstract class AddbPacketManager implements Runnable {
	protected Socket fSocket;
	
	public AddbPacketManager(Socket socket) {
		fSocket = socket;
	}
	
	public Socket getSocket() {
		return this.fSocket;
	}
	
	public boolean isConnected() {
		return fSocket.isConnected();
	}
	
	public void disconnect() {
		try {
            fSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public byte [] readPacket() throws IOException {
		DataInputStream stream = AddbServerAgent.instance().in();
        synchronized (stream) {
            int packetLength = 0;
            try {
                packetLength = stream.readInt();
            } catch (IOException e) {
              throw e;
            }

            if (packetLength < 11) {
                throw new IOException("Packet under 11 bytes"); //$NON-NLS-1$
            }

            byte[] packet = new byte[packetLength];
            packet[0] = (byte) ((packetLength >>> 24) & 0xFF);
            packet[1] = (byte) ((packetLength >>> 16) & 0xFF);
            packet[2] = (byte) ((packetLength >>> 8) & 0xFF);
            packet[3] = (byte) ((packetLength >>> 0) & 0xFF);

            stream.readFully(packet, 4, packetLength - 4);
            return packet;
        }
	}
	
	public void writePacket(byte[] packet) throws IOException {
        if (packet == null){
            throw new IllegalArgumentException("Invalid Packet, packet cannot be null");
        }
        if (packet.length < 11) {
            throw new IllegalArgumentException("Invalid Packet, must be at least 11 bytes. PacketSize:" + packet.length);
        }

        int packetSize = DataUtil.bytesToInt(packet, 0);	// convert the first 4 bytes to packet size
        
        if (packetSize < 11) {
            throw new IllegalArgumentException("Invalid Packet, must be at least 11 bytes. PacketSize:" + packetSize);
        }

        if (packetSize > packet.length) {
            throw new IllegalArgumentException("Invalid packet: Specified length is greater than actual length");
        }

        DataOutputStream stream = null;
        synchronized(this) {
            stream = AddbServerAgent.instance().out();
        }
        
        synchronized (stream) {
            // packet.length can be > packetSize. Sending too much will cause
            // errors on the other side
            stream.write(packet, 0, packetSize);
        }
    }
	
}
