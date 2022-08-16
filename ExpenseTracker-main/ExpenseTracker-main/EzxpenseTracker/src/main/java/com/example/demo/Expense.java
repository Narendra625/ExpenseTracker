package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="expense")
public class Expense {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String expensedate;
	
	private String description;
	
	
	private String email;
	
	private long expenseamount;
	
	public long getExpenseamount() {
		return expenseamount;
	}

	public void setExpenseamount(long expenseamount) {
		this.expenseamount = expenseamount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getExpensedate() {
		return expensedate;
	}
	public void setExpensedate(String expensedate) {
		this.expensedate = expensedate;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Expense(long id, String expensedate, String description, User user) {
		super();
		this.id = id;
		this.expensedate = expensedate;
		this.description = description;
	
	}
	public Expense() {
		
	}
 
}
