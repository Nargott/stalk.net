package com.nargott;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

public class Utils {

	static public String MD5(String src) {
		try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
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
	
	public static final char[] getPassValid(final String regex, final int lastchar) {
	    char[] potential = new char[lastchar]; // 32768 is not huge....
	    int size = 0;
	    final Pattern pattern = Pattern.compile(regex);
	    for (int c = 0; c <= lastchar; c++) {
	        if (pattern.matcher(String.valueOf((char)c)).matches()) {
	            potential[size++] = (char)c;
	        }
	    }
	    return Arrays.copyOf(potential, size);
	}
	
	public static final String genPass(char[] validchars, int len) {
	    char[] password = new char[len];
	    Random rand = new Random(System.nanoTime());
	    for (int i = 0; i < len; i++) {
	        password[i] = validchars[rand.nextInt(validchars.length)];
	    }
	    return new String(password);
	}
}
