package com.example.budget.budgetApp.User.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.budget.budgetApp.Transaction.model.Transaction;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	
	@Column(name = "monthlyGoalAmount")
	private Integer monthlyGoalAmount;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Transaction> transactions;
	
	public User() {
	}

	public User(String userName, Integer monthlyGoalAmount) {
		this.userName = userName;
		this.monthlyGoalAmount = monthlyGoalAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getMonthlyGoalAmount() {
		return monthlyGoalAmount;
	}

	public void setMonthlyGoalAmount(Integer monthlyGoalAmount) {
		this.monthlyGoalAmount = monthlyGoalAmount;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
}
