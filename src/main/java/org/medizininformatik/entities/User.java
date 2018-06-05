package org.medizininformatik.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue
	@Column (name="id")
    private Long id;
	
	@Column (name="vnr")
	private String vnr;
	
	@Column (name="prefix")
	private String prefix;
	
	@Column (name="fname")
    private String fname;
	
	@Column (name="secname")
    private String secfname;
	
	@Column (name="lname")
    private String lname;
	
	@Column (name="gender")
    private int gender;
	
	@Column (name="bdate")
    private Date bdate;
    
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private List<Document> documents;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
	 @JoinTable(name = "user_healthp",
     joinColumns = { @JoinColumn(name = "user_id") },
     inverseJoinColumns = { @JoinColumn(name = "healthp_id") })
	private List<HealthProfessional> healthp;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVnr() {
		return vnr;
	}
	public void setVnr(String vnr) {
		this.vnr = vnr;
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
	
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getGender() {
		return gender;
	}
	
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public Date getBdate() {
		return bdate;
	}
	
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	public List<HealthProfessional> getHealthp() {
		return healthp;
	}
	public void setHealthp(List<HealthProfessional> healthp) {
		this.healthp = healthp;
	}
	public User(String vnr, String prefix, String fname, String secfname, String lname, int gender, Date bdate ) {
		this.vnr = vnr;
		this.prefix = prefix;
		this.fname = fname;
		this.secfname = secfname;
		this.lname = lname;
		this.gender = gender;
		this.bdate = bdate;
	
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", prefix=" + prefix + ", fname=" + fname + ", secfname=" + secfname + ", lname="
				+ lname + ", gender=" + gender + ", bdate=" + bdate + "]";
	}
	public User() {
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSecfname() {
		return secfname;
	}
	public void setSecfname(String secfname) {
		this.secfname = secfname;
	}
    
}
