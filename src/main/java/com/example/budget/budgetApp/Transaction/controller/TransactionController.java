package com.example.budget.budgetApp.Transaction.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.budget.budgetApp.Transaction.model.Transaction;
import com.example.budget.budgetApp.Transaction.service.TransactionService;
import com.example.budget.budgetApp.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/api/v1/")
public class TransactionController {
	
	private final TransactionService transactionService;
	
	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	// get transactions
	@GetMapping("transactions")
	public List<Transaction> getAllTransactions(){
		return transactionService.getAllTransactions();
	}
	
	// get transaction by id
	@GetMapping("/transactions/{id}")
		public ResponseEntity<Transaction> getTransactionById(@PathVariable(value = "id") Long transactionId) throws ResourceNotFoundException {
			return transactionService.getTransactionById(transactionId);
	}
	
	// save transaction
	@PostMapping("user/transactions/{id}")
	public Transaction createTransaction(@PathVariable(value = "id") Long userId, @RequestBody Transaction transactions) throws ResourceNotFoundException {
		return transactionService.createTransaction(userId, transactions);
	}
	
	// update transaction
	@PutMapping("transactions/{id}")
	public ResponseEntity<Transaction> updateTransaction(@PathVariable(value = "id") Long transactionId, 
			@Validated @RequestBody Transaction transactionDetails) throws ResourceNotFoundException {
		return transactionService.updateTransaction(transactionId, transactionDetails);
	}
	
	// delete transaction
	@DeleteMapping("transactions/{id}")
	public Map<String, Boolean> deleteTransaction(@PathVariable(value = "id") Long transactionId) throws ResourceNotFoundException {
		return transactionService.deleteTransaction(transactionId);
	}
}
