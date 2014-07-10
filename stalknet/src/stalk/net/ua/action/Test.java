package stalk.net.ua.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
