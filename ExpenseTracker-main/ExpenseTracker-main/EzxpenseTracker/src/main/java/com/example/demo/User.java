package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class User {
	  @Id
	  @Value("")
	   private String email;
	   private String name;
	   private String password;
	   private int amount;
	   private String expense;
	   private int expenseamount;
	   private String date;
	   public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public int getExpenseamount() {
		return expenseamount;
	}
	public void setExpenseamount(int expenseamount) {
		this.expenseamount = expenseamount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
