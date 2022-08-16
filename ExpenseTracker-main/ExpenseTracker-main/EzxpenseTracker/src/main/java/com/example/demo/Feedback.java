package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Feedback{
	  @Id
	  @Value("")
	   private String mailid;
	  
		public Feedback(String mailid, String firstname, String lastname, String country, String subject) {
		super();
		this.mailid = mailid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.country = country;
		this.subject = subject;
	}
		private String firstname;
		
		  private String lastname;
		  
		  private String country;
		  
		  private String subject;
		  
	  public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
public Feedback() {
	
}  
}
