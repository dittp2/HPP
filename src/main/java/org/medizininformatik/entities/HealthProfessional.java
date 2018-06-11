package org.medizininformatik.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_Health_Professionals")
public class HealthProfessional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
    private Long id;
	
	@Column (name="gln")
    private String gln;

	@Column (name="fname")
	private String fname;
	
	@Column (name="lname")
	private String lname;
	
	@Column (name="prefix")
	private String prefix;
	

	@Column (name="administrativeGender")
	private String adminGender;

	@Column (name="type")
	private String type;
	
	@Column (name="title")
	private String title;
	
	@Column (name="fach")
	private String fach;
	
	@Column (name="beruf")
	private String beruf;
	
	@Column (name="addr")
	private String addr;
	
	@Column (name="nation")
	private String nation;
	
	@Column (name="language")
	private String language;
	
	@Column (name="gender")
	private String gender;
	
	@Column (name="email")
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    private List<User> users ;

	@Column (name ="login")
	private String login;
	
	@Column (name ="pass")
	private String pass;
	
	public HealthProfessional() {
	}
	
	public HealthProfessional(String gln, String fname, String lname, String prefix, String adminGender, String login, String pass) {
		this.gln = gln;
		this.fname = fname;
		this.lname = lname;
		this.prefix = prefix;
		this.adminGender = adminGender;
		this.login = login;
		this.pass = pass;
	}
	
	

	public HealthProfessional( String gln, String fname, String lname, String prefix, String adminGender,
			String type, String title, String fach, String beruf, String addr, String nation, String language,
			String gender, String email,  String login, String pass) {
	
		this.gln = gln;
		this.fname = fname;
		this.lname = lname;
		this.prefix = prefix;
		this.adminGender = adminGender;
		this.type = type;
		this.title = title;
		this.fach = fach;
		this.beruf = beruf;
		this.addr = addr;
		this.nation = nation;
		this.language = language;
		this.gender = gender;
		this.email = email;
		this.login = login;
		this.pass = pass;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGln() {
		return gln;
	}

	public void setGln(String gln) {
		this.gln = gln;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFach() {
		return fach;
	}

	public void setFach(String fach) {
		this.fach = fach;
	}

	public String getBeruf() {
		return beruf;
	}

	public void setBeruf(String beruf) {
		this.beruf = beruf;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

	@Override
	public String toString() {
		return "HealthProfessional [id=" + id + ", gln=" + gln + ", fname=" + fname + ", lname=" + lname + ", prefix="
				+ prefix + ", adminGender=" + adminGender + ", type=" + type + ", title=" + title + ", fach=" + fach
				+ ", beruf=" + beruf + ", addr=" + addr + ", nation=" + nation + ", language=" + language + ", gender="
				+ gender + ", email=" + email + ", users=" + users + ", login=" + login + ", pass=" + pass + "]";
	}
	
	

	
	
}


