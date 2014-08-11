package com.nargott;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;

import com.dumbster.smtp.SimpleSmtpServer;
import com.dumbster.smtp.SmtpMessage;

import org.apache.commons.mail.*;

public class Utils {

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
	
	public static final String genPass(char[] validchars, int len) {
	    char[] password = new char[len];
	    Random rand = new Random(System.nanoTime());
	    for (int i = 0; i < len; i++) {
	        password[i] = validchars[rand.nextInt(validchars.length)];
	    }
	    return new String(password);
	}
	
	public void sendEmail(
		    String aFromEmailAddr, String aToEmailAddr,
		    String aSubject, String aBody
		  ) {
		Email email = new SimpleEmail();
		//email.
		email.setSubject(aSubject);
		try {
			email.setFrom(aFromEmailAddr);
			email.setMsg(aBody);
			email.addTo(aToEmailAddr);
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testSend() {
	    //SimpleSmtpServer server = SimpleSmtpServer.start();

	    try {
	      // Submits an email using javamail to the email server listening on port 25 
	      // (method not shown here). Replace this with a call to your app logic.
	      sendEmail("java@stalk.net.ua", "KiberPUNK.mail@gmail.com", "Test Msg", "Test Java Body" );
	    } catch(Exception e) {
	      e.printStackTrace();
	      System.out.println("Unexpected exception: "+e);
	    }

	    /*server.stop();

	    assertTrue(server.getReceivedEmailSize() == 1);
	    Iterator emailIter = server.getReceivedEmail();
	    SmtpMessage email = (SmtpMessage)emailIter.next();
	    assertTrue(email.getHeaderValue("Subject").equals("Test"));
	    assertTrue(email.getBody().equals("Test Body"));	*/
	  }
}
