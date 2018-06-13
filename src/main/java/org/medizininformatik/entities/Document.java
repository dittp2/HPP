package org.medizininformatik.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_Documents")
public class Document {
	
	@Id
	@GeneratedValue
	@Column (name="docId")
	private Long doc_Id;
	
	@Column (name="docTitle")
	private String doc_Title;
	
	@Column (name="docType")
	private String doc_Type;
	
	@Column (name="docRichtung")
	private String doc_Richtung;
	
	@Column (name="docInstitution")
	private String doc_Institution;
	
	@Column (name="docAutor")
	private String doc_Autor;
	
	@Column (name="docDatum")
	private String doc_Datum;
	
	@Column (name="docURL")
	private String doc_Url;

	@ManyToOne
	private Patient user;
	
	public Long getDoc_Id() {
		return doc_Id;
	}

	


	public String getDoc_Title() {
		return doc_Title;
	}




	public void setDoc_Title(String doc_Title) {
		this.doc_Title = doc_Title;
	}




	public String getDoc_Type() {
		return doc_Type;
	}




	public void setDoc_Type(String doc_Type) {
		this.doc_Type = doc_Type;
	}




	public String getDoc_Richtung() {
		return doc_Richtung;
	}




	public void setDoc_Richtung(String doc_Richtung) {
		this.doc_Richtung = doc_Richtung;
	}




	public String getDoc_Institution() {
		return doc_Institution;
	}




	public void setDoc_Institution(String doc_Institution) {
		this.doc_Institution = doc_Institution;
	}




	public String getDoc_Autor() {
		return doc_Autor;
	}




	public void setDoc_Autor(String doc_Autor) {
		this.doc_Autor = doc_Autor;
	}




	public String getDoc_Datum() {
		return doc_Datum;
	}




	public void setDoc_Datum(String doc_Datum) {
		this.doc_Datum = doc_Datum;
	}




	public String getDoc_Url() {
		return doc_Url;
	}




	public void setDoc_Url(String doc_Url) {
		this.doc_Url = doc_Url;
	}




	public void setDoc_Id(Long doc_Id) {
		this.doc_Id = doc_Id;
	}






	@Override
	public String toString() {
		return "Document [doc_Id=" + doc_Id + ", doc_Title=" + doc_Title + ", doc_Type=" + doc_Type + ", doc_Richtung="
				+ doc_Richtung + ", doc_Institution=" + doc_Institution + ", doc_Autor=" + doc_Autor + ", doc_Datum="
				+ doc_Datum + ", doc_Url=" + doc_Url + ", user=" + user + "]";
	}





	
	public Document( String doc_Title, String doc_Type, String doc_Richtung, String doc_Institution,
			String doc_Autor, String doc_Datum, String doc_Url) {
		super();
		
		this.doc_Title = doc_Title;
		this.doc_Type = doc_Type;
		this.doc_Richtung = doc_Richtung;
		this.doc_Institution = doc_Institution;
		this.doc_Autor = doc_Autor;
		this.doc_Datum = doc_Datum;
		this.doc_Url = doc_Url;
		
	}




//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Document() {}

}
