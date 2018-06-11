package org.medizininformatik.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;




@Entity(name = "UserHealthProfessional")
@Table(name = "User_HealthProfessional")
public class Right {
	
	@EmbeddedId
	private UserHealthProfessionalId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("healthId")
	private HealthProfessional healthp;
	
	private Boolean erweitert;
	
	public Right() {}
	
	 public Right(User user, HealthProfessional healthp) {
	        this.user = user;
	        this.healthp = healthp;
	        this.id = new UserHealthProfessionalId(user.getId(), healthp.getId());
	        this.setErweitert(false);
	       
	    }

	public UserHealthProfessionalId getId() {
		return id;
	}

	public void setId(UserHealthProfessionalId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
