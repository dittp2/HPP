package org.medizininformatik.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
    private Long id;
    private String fname;
    private String lname;
    private String gender;
    private String bdate;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getBdate() {
		return bdate;
	}
	
	public User(String fname, String lname, String gender, String bdate) {
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.bdate = bdate;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", bdate=" + bdate + "]";
	}
	public User() {
	}
    
}
