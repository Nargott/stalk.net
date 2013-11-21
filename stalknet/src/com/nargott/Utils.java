package com.nargott;

public class Utils {

	static public String MD5(String src) {
		try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("sha512");
	        byte[] array = md.digest(src.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    }
	    return null;
	}
}
