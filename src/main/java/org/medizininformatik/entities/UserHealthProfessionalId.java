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
public class UserHealthProfessionalId 
	implements Serializable{
 
    @Column(name = "user_id")
    private Long userId;
 
    @Column(name = "health_id")
    private Long healthId;
 
    private UserHealthProfessionalId() {}
 
    public UserHealthProfessionalId(
        Long userId, 
        Long healthId) {
        this.userId = userId;
        this.healthId = healthId;
    }
 
    //Getters omitted for brevity
 
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((healthId == null) ? 0 : healthId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserHealthProfessionalId other = (UserHealthProfessionalId) obj;
		if (healthId == null) {
			if (other.healthId != null)
				return false;
		} else if (!healthId.equals(other.healthId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
}




