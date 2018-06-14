package org.medizininformatik.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "PatientHealthProfessional")
@Table(name = "Patient_HealthProfessional")
public class Right {
	
	/*
	 * Attribut of Right
	 */
	@EmbeddedId
	private PatientHealthProfessionalId id;
	
	/*
	 * Create an n:1 Relation to the Patient
	 */
	@ManyToOne(fetch = FetchType.LAZY)
<<<<<<< HEAD
	@MapsId("patientId")
	private Patient patient;
=======
    @MapsId("userId")
	private User user;
>>>>>>> parent of 2042fdf... umbrenennt
	
	/*
	 * Create an n:1 Relation to the Healthprofessional
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("healthId")
	private HealthProfessional healthp;
	
	private Boolean erweitert;
	
	/*
	 * Constructor
	 */
	public Right() {}
	
<<<<<<< HEAD
	public Right(Patient patient, HealthProfessional healthp) {
        this.patient = patient;
        this.healthp = healthp;
        this.id = new PatientHealthProfessionalId(patient.getId(), healthp.getId());
        this.setErweitert(false);  
    }
	
	/*
	 * Getter and Setter of all attribut
	 */
	public PatientHealthProfessionalId getId() {
=======
	 public Right(User user, HealthProfessional healthp) {
	        this.user = user;
	        this.healthp = healthp;
	        this.id = new UserHealthProfessionalId(user.getId(), healthp.getId());
	        this.setErweitert(false);
	       
	    }

	public UserHealthProfessionalId getId() {
>>>>>>> parent of 2042fdf... umbrenennt
		return id;
	}

	public void setId(PatientHealthProfessionalId id) {
		this.id = id;
	}

<<<<<<< HEAD
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
=======
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
>>>>>>> parent of 2042fdf... umbrenennt
	}

	public HealthProfessional getHealth() {
		return healthp;
	}

	public void setHealth(HealthProfessional health) {
		this.healthp = health;
	}

	public Boolean getErweitert() {
		return erweitert;
	}

	public void setErweitert(Boolean erweitert) {
		this.erweitert = erweitert;
	}
}
