package stalk.net.ua.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int uid;

	private int access;

	private int created;

	@Lob
	private String data;

	private String init;

	private String language;

	private int login;

	private String mail;

	private byte mode;

	private String name;

	private String pass;

	private String picture;

	private String signature;

	@Column(name="signature_format")
	private short signatureFormat;

	private byte sort;

	private byte status;

	private String theme;

	private byte threshold;

	private String timezone;

	@Column(name="timezone_id")
	private int timezoneId;

	@Column(name="timezone_name")
	private String timezoneName;

	public User() {
	}

	public int getUid() {
		return this.uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAccess() {
		return this.access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public int getCreated() {
		return this.created;
	}

	public void setCreated(int created) {
		this.created = created;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getInit() {
		return this.init;
	}

	public void setInit(String init) {
		this.init = init;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getLogin() {
		return this.login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public byte getMode() {
		return this.mode;
	}

	public void setMode(byte mode) {
		this.mode = mode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public short getSignatureFormat() {
		return this.signatureFormat;
	}

	public void setSignatureFormat(short signatureFormat) {
		this.signatureFormat = signatureFormat;
	}

	public byte getSort() {
		return this.sort;
	}

	public void setSort(byte sort) {
		this.sort = sort;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public byte getThreshold() {
		return this.threshold;
	}

	public void setThreshold(byte threshold) {
		this.threshold = threshold;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public int getTimezoneId() {
		return this.timezoneId;
	}

	public void setTimezoneId(int timezoneId) {
		this.timezoneId = timezoneId;
	}

	public String getTimezoneName() {
		return this.timezoneName;
	}

	public void setTimezoneName(String timezoneName) {
		this.timezoneName = timezoneName;
	}

}