package com.example.budget.budgetApp.Transaction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.budget.budgetApp.User.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="transactions")
public class Transaction {
	@Id
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "amount")
	private Integer amount;
	
	@Column(name = "category")
	private String category;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Transaction() {
	}

	public Transaction(String description, Integer amount, String category, User user) {
		this.description = description;
		this.amount = amount;
		this.category = category;
		this.user = user;
	}
	
}
