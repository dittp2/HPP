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
<<<<<<< HEAD:src/main/java/org/medizininformatik/entities/Patient.java
@Table(name = "Patient")
public class Patient {
	/*
	 * Attribut of Patient
	 */
=======
@Table(name = "User")
public class User {
	
>>>>>>> parent of 2042fdf... umbrenennt:src/main/java/org/medizininformatik/entities/User.java
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
	/*
	 * Create a 1:n relation to the Document
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private List<Document> documents;
	
	/*
	 * Create a n:m relation to the Healthprofessional
	 */
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
	 @JoinTable(name = "patient_healthp",
     joinColumns = { @JoinColumn(name = "patient_id") },
     inverseJoinColumns = { @JoinColumn(name = "healthp_id") })
	private List<HealthProfessional> healthp;
	
	/*
	 * Constructor
	 */
	public Patient() {
	}
	
	public Patient(String vnr, String prefix, String fname, String secfname, String lname, int gender, Date bdate ) {
		this.vnr = vnr;
		this.prefix = prefix;
		this.fname = fname;
		this.secfname = secfname;
		this.lname = lname;
		this.gender = gender;
		this.bdate = bdate;
	
	}
	
	/*
	 * Getter and Setter of all attribut
	 */
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
<<<<<<< HEAD:src/main/java/org/medizininformatik/entities/Patient.java
=======
	public User(String vnr, String prefix, String fname, String secfname, String lname, int gender, Date bdate ) {
		this.vnr = vnr;
		this.prefix = prefix;
		this.fname = fname;
		this.secfname = secfname;
		this.lname = lname;
		this.gender = gender;
		this.bdate = bdate;
	
	}
	
>>>>>>> parent of 2042fdf... umbrenennt:src/main/java/org/medizininformatik/entities/User.java
	
	/*
	 * Override the toString with the Attribut
	 */	
	@Override
	public String toString() {
		return "User [id=" + id + ", prefix=" + prefix + ", fname=" + fname + ", secfname=" + secfname + ", lname="
				+ lname + ", gender=" + gender + ", bdate=" + bdate + "]";
<<<<<<< HEAD:src/main/java/org/medizininformatik/entities/Patient.java
	}    
=======
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
    
>>>>>>> parent of 2042fdf... umbrenennt:src/main/java/org/medizininformatik/entities/User.java
}
