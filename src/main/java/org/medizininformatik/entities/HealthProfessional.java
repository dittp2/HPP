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
	
	//administrativeGender
	public String getHP_adminGender() {
		return HP_adminGender;
	}
	
	public void setAdminGender(String gender) {
		this.HP_adminGender = gender;
	}
	

	@Override
	public String toString() {
		return "HealthProfessional [gln=" + HP_gln + ", fname=" + HP_fname + 
				", lname=" + HP_lname + ", prefix=" + HP_prefix +  ", adminGender=" + HP_adminGender + "]";
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
}


