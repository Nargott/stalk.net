package com.nargott;

import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Utils {
	
	/**
	 * generates MD5-hash from the string
	 * @param src Source
	 * @return MD5-hash
	 */
	public static final String MD5(String src) {
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
	
	/**
	 * Generates random password
	 * @param strength -- PasswordStrength enum type
	 * @param len -- the length of the needle password
	 * @return
	 */
	public static final String genPass(PasswordStrength strength, int len) {
		char[] validchars = strength.getStrength();
		char[] password = new char[len];
	    Random rand = new Random(System.nanoTime());
	    for (int i = 0; i < len; i++) {
	        password[i] = validchars[rand.nextInt(validchars.length)];
	    }
	    return new String(password);
	}
	
	public static Boolean SendMail(String msgTo, String msgSubject, String msgText) {
		// Sender's email ID needs to be mentioned
		String from = "robot@stalk.net.ua";
		// Assuming you are sending email from localhost
		String host = "localhost";
		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		// Get the default Session object.
		Session session = Session.getInstance(properties);
		try {
		    // Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO,
		                          new InternetAddress(msgTo));
			message.addHeader("Content-Type", "text/plain; charset=UTF-8");
			message.setSubject(msgSubject, "UTF-8");
			message.setText(msgText, "UTF-8");
			
			Transport.send(message);
			//System.out.println("Sent message successfully....");
			return true;
		  } catch (MessagingException mex) {
			  mex.printStackTrace();
			  return false;
		  }
	}
}
