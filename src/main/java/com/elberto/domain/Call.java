package com.elberto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.hateoas.ResourceSupport;


@Entity
@Table(name="TBL_CALL")
public class Call  extends ResourceSupport implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	@NotNull
	private Date timeAndDate;
	@NotEmpty
	private String notes;
	

	public Call(String notes)
	{
		// this defaults to a timestamp of "now"
		this (notes, new java.util.Date());
	}
	
	
	public Call(String notes, Date timestamp)
	{
		this.timeAndDate = timestamp;	
		this.notes = notes;
	}
	
	
	
	public String toString()
	{
		return this.timeAndDate + " : " + this.notes;
	}

	public Date getTimeAndDate() {
		return timeAndDate;
	}

	public void setTimeAndDate(Date timeAndDate) {
		this.timeAndDate = timeAndDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	//- ignore until then
	public Call() {}
}
