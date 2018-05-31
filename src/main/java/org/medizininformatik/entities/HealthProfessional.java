package org.medizininformatik.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tbl_Health_Professionals")
public class HealthProfessional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
    private Long HP_id;
	
	@Column (name="gln")
    private String HP_gln;
	
	@Column (name="fname")
	private String HP_fname;
	
	@Column (name="lname")
	private String HP_lname;
	
	@Column (name="prefix")
	private String HP_prefix;
	

	@Column (name="administrativeGender")
	private String HP_adminGender;

	@Column (name="type")
	private String HP_type;
	
	@Column (name="title")
	private String HP_title;
	
	@Column (name="fach")
	private String HP_fach;
	
	@Column (name="beruf")
	private String HP_beruf;
	
	@Column (name="addr")
	private String HP_addr;
	
	@Column (name="nation")
	private String HP_nation;
	
	@Column (name="language")
	private String HP_language;
	
	@Column (name="gender")
	private String HP_gender;
	
	@Column (name="email")
	private String HP_email;

	

	public String getHP_Gln() {
		return HP_gln;
	}

	public void setHP_Gln(String HP_gln) {
		this.HP_gln = HP_gln;
	}
	
	//fname = first name
	public String getHP_Fname() {
		return HP_fname;
	}


	public void setHP_Fname(String HP_fname) {
		this.HP_fname = HP_fname;
	}
	
	//lname = last name
	public String getHP_Lname() {
		return HP_lname;
	}
	
	public void setLname(String HP_lname) {
		this.HP_lname = HP_lname;
	}
	
	//prefix
	public String getHP_Prefix() {
		return HP_prefix;
	}
	
	public void setPrefix(String prefix) {
		this.HP_prefix = prefix;
	}
	// type
	public String getHP_type() {
		return HP_type;
	}

	public void setHP_type(String hP_type) {
		HP_type = hP_type;
	}

	
	//administrativeGender
	public String getHP_adminGender() {
		return HP_adminGender;
	}
	
	public void setAdminGender(String gender) {
		this.HP_adminGender = gender;
	}
	

	public String getHP_title() {
		return HP_title;
	}

	public void setHP_title(String hP_title) {
		HP_title = hP_title;
	}

	public String getHP_fach() {
		return HP_fach;
	}

	public void setHP_fach(String hP_fach) {
		HP_fach = hP_fach;
	}

	public String getHP_beruf() {
		return HP_beruf;
	}

	public void setHP_beruf(String hP_beruf) {
		HP_beruf = hP_beruf;
	}

	public String getHP_addr() {
		return HP_addr;
	}

	public void setHP_addr(String hP_addr) {
		HP_addr = hP_addr;
	}

	public String getHP_nation() {
		return HP_nation;
	}

	public void setHP_nation(String hP_nation) {
		HP_nation = hP_nation;
	}

	public String getHP_language() {
		return HP_language;
	}

	public void setHP_language(String hP_language) {
		HP_language = hP_language;
	}

	public String getHP_gender() {
		return HP_gender;
	}

	public void setHP_gender(String hP_gender) {
		HP_gender = hP_gender;
	}

	public String getHP_email() {
		return HP_email;
	}

	public void setHP_email(String hP_email) {
		HP_email = hP_email;
	}

	@Override
	public String toString() {
		return "HealthProfessional [HP_id=" + HP_id + ", HP_gln=" + HP_gln + ", HP_fname=" + HP_fname + ", HP_lname="
				+ HP_lname + ", HP_prefix=" + HP_prefix + ", HP_type=" + HP_type + ", HP_title=" + HP_title
				+ ", HP_fach=" + HP_fach + ", HP_beruf=" + HP_beruf + ", HP_addr=" + HP_addr + ", HP_nation="
				+ HP_nation + ", HP_language=" + HP_language + ", HP_gender=" + HP_gender + ", HP_email=" + HP_email
				+ "]";

	}

	public HealthProfessional() {
	}
	

	public HealthProfessional(String HP_gln, String HP_fname, String HP_lname, String HP_prefix, String HP_adminGender) {
	this.HP_gln = HP_gln;
	this.HP_fname = HP_fname;
	this.HP_lname = HP_lname;
	this.HP_prefix = HP_prefix;
	this.HP_adminGender = HP_adminGender;
	}	

	
	
	public HealthProfessional( String hP_gln, String hP_fname, String hP_lname, String hP_prefix, String HP_adminGender,
			String hP_type, String hP_title, String hP_fach, String hP_beruf, String hP_addr, String hP_nation,
			String hP_language, String hP_gender, String hP_email) {
		
		this.HP_gln = hP_gln;
		this.HP_fname = hP_fname;
		this.HP_lname = hP_lname;
		this.HP_prefix = hP_prefix;
		this.HP_adminGender = HP_adminGender;
		this.HP_type = hP_type;
		this.HP_title = hP_title;
		this.HP_fach = hP_fach;
		this.HP_beruf = hP_beruf;
		this.HP_addr = hP_addr;
		this.HP_nation = hP_nation;
		this.HP_language = hP_language;
		this.HP_gender = hP_gender;
		this.HP_email = hP_email;
	}

}


