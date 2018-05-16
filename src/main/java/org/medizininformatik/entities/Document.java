package org.medizininformatik.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@Column (name="docURL")
	private String doc_Url;

	public Long getDoc_Id() {
		return doc_Id;
	}

	public void setDoc_Id(Long doc_Id) {
		this.doc_Id = doc_Id;
	}

	public String getDoc_Title() {
		return doc_Title;
	}

	public void setDoc_Title(String doc_Title) {
		this.doc_Title = doc_Title;
	}

	public String getDoc_Url() {
		return doc_Url;
	}

	public void setDoc_Url(String doc_Url) {
		this.doc_Url = doc_Url;
	}

	@Override
	public String toString() {
		return "Document [doc_Id=" + doc_Id + ", doc_Title=" + doc_Title + ", doc_Url=" + doc_Url + "]";
	}

	public Document(String doc_Title, String doc_Url) {
		super();
		this.doc_Title = doc_Title;
		this.doc_Url = doc_Url;
	}
	
	public Document() {}

}
