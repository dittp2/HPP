package org.medizininformatik.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Embeddable
public class PatientHealthProfessionalId 
	implements Serializable{
	
	/*
	 * Attribut of PatientHealth ID
	 */
    @Column(name = "patient_id")
    private Long patientId;
 
    @Column(name = "health_id")
    private Long healthId;
    
    /*
	 * Constructor
	 */ 
    private PatientHealthProfessionalId() {}
 
    public PatientHealthProfessionalId(
        Long patientId, 
        Long healthId) {
        this.patientId = patientId;
        this.healthId = healthId;
    }
 
    /*
	 * HashCode
	 */
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((healthId == null) ? 0 : healthId.hashCode());
		result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
		return result;
	}
    
    /*
	 * Equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientHealthProfessionalId other = (PatientHealthProfessionalId) obj;
		if (healthId == null) {
			if (other.healthId != null)
				return false;
		} else if (!healthId.equals(other.healthId))
			return false;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		return true;
	}
	
	
}




