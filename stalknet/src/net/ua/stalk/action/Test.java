package net.ua.stalk.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.primefaces.model.UploadedFile;


@ManagedBean //Означает, что этот бин будет виден для JSF
@SessionScoped //Область действия -- сессия
public class Test implements Serializable {
	private static final long serialVersionUID = -7145555352313720425L;
	
	private UploadedFile photo;
	private Boolean isSend = false;
	
	public String getStr() {
		System.out.println(System.getProperty("catalina.base"));
		return "1234";
	}
	
	
	
	public String submit() {
		if (photo!=null) {
			
			try {
	            File targetFolder = new File(System.getProperty("catalina.base")+"/eclipseApps/stalknet/resources/img/");
	            InputStream inputStream = photo.getInputstream();
	            OutputStream out = new FileOutputStream(new File(targetFolder, "photo.jpg"));
	            int read = 0;
	            byte[] bytes = new byte[1024];

	            while ((read = inputStream.read(bytes)) != -1) {
	                out.write(bytes, 0, read);
	            }
	            inputStream.close();
	            out.flush();
	            out.close();
	            isSend=true;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		} else {
			System.out.println("Photo is null! (");
		}
		return "";
	}
	
	public String sendViaGmail() {
		String username = "kiberpunk.mail@gmail.com";
		String password = "Fallout@)&&";
		System.out.println("username = "+username);
		String host = "smtp.gmail.com";
	    
	    Properties props = new Properties();
	    // set any needed mail.smtps.* properties here
	    Session session = Session.getInstance(props);
	    MimeMessage msg = new MimeMessage(session);
	    try {
			msg.setFrom(new InternetAddress("admin@stalk.net.ua"));
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("kiberpunk.mail@gmail.com"));
			msg.setSubject("Testing Subject");
			msg.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    // set the message content here
	    Transport t;
		
	    try {
	    	t = session.getTransport("smtps");
	    	t.connect(host, username, password);
	    	t.sendMessage(msg, msg.getAllRecipients());
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*finally {
	    	t.close();
	    }*/
		
		return "#";
	}
	
	public String send() {
		// Recipient's email ID needs to be mentioned.
	      String to = "kiberpunk.mail@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "admin@stalk.net.ua";

	      // Assuming you are sending email from localhost
	      String host = "localhost";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("This is the Subject Line!");

	         // Now set the actual message
	         message.setText("This is actual message");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   return "#";   
	}
	
	public UploadedFile getPhoto() {
		return photo;
	}

	public void setPhoto(UploadedFile photo) {
		this.photo = photo;
	}

	public Boolean getIsSend() {
		return isSend;
	}

	public void setIsSend(Boolean isSend) {
		this.isSend = isSend;
	}
	
	
}
