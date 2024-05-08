package mingCarServer.user.model;

import java.sql.Timestamp;

public class User {
	private String id;
	private String email;
	private String name;
	private String birth;
	private String phone;
	private String gender;
	private Timestamp regDate;
	private Timestamp modDate;
	
	
	public User(String id, String email, String name, String birth, String phone, String gender,
			Timestamp regDate, Timestamp modDate) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.gender = gender;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getModDate() {
		return modDate;
	}
	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}
}


