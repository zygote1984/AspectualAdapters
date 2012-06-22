package org.alia4j.addb.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

public class DataUtil {
   public static byte[] intToBytes(int i) {
   	 byte[] bytes = new byte[4];	    
     bytes[0] = (byte) (i >>> 24);
     bytes[1] = (byte) (i >>> 16);
     bytes[2] = (byte) (i >>>  8);
     bytes[3] = (byte) (i >>>  0);
   	 return bytes;
   }
   
   public static byte[] intsToBytes(int[] ints) {
	   byte[] allbytes = new byte[ints.length*4];
	   for(int i=0; i<ints.length; i++) {
		   byte[] bytes = intToBytes(ints[i]);
		   System.arraycopy(bytes, 0, allbytes, i*4, 4);
	   }
	   return allbytes;
   }
   
   public static int bytesToInt(byte[] bytes, int index) {
   	   int a = (bytes[index] & 0xff) << 24;
       int b = (bytes[index+1] & 0xff) << 16;
       int c = (bytes[index+2] & 0xff) << 8;
       int d = (bytes[index+3] & 0xff) << 0;
	   return a+b+c+d;
   }
   
   final public static Charset CharsetCode = Charset.forName("US-ASCII");
   
   public static byte[] stringToBytes(String s) {
     return s.getBytes(CharsetCode);
   }
   
   public static String bytesToString(byte[] bytes) {
 		ByteBuffer bb = ByteBuffer.allocate(bytes.length);
 		bb.put(bytes);
 		bb.flip();
 		return CharsetCode.decode(bb).toString();
   }
	
	public static byte booleanToByte(boolean bool) {
		if(bool)
			return (byte)1;
		else
			return (byte)0;
	}
	
	public static String removeStringQuote(String str){
	  int start = 0;
	  int end = str.length();
	  if(str.charAt(0)=='\"') {
	    start += 1;
	  }
	  if(str.charAt(end-1)=='\"') {
	    end -= 1;
	  }
	  return str.substring(start, end);
	}
	
	public static byte[] concatBytes(byte[]... bytes) {
		int length = 0;
		for(byte [] array : bytes) {
			length += array.length;
		}
		byte [] newArray = new byte[length];
		
		int index = 0;
		for(byte [] array : bytes) {
			System.arraycopy(array, 0, newArray, index, array.length);
			index += array.length;
		}
		return newArray;
	}
	
	public static List<String> extendStringList(List<String> list, String newStr) {
		List<String> listCopy = new LinkedList<String>();
		listCopy.addAll(list);
		listCopy.add(newStr);
		return listCopy;
	}

}
