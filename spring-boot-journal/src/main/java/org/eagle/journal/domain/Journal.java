package org.eagle.journal.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Journal {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id; 
	private String title; 
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy")
	private String created; 
	private String summary; 

	
	public Journal(String title,  String summary,String date) throws ParseException{
		this.title = title; 
		this.created = date;
		System.out.println("Date : "+this.created);
		this.summary = summary;
	}
	
	public Journal(){
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}


	@Override
	public String toString() {
		return "Journal [Id=" + Id + ", title=" + title + ", created=" + created + ", summary=" + summary + "]";
	}
	
}
