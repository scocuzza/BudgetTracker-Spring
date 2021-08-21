package com.example.budget.budgetApp.Transaction.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.budget.budgetApp.Transaction.model.Transaction;
import com.example.budget.budgetApp.Transaction.repository.TransactionRepository;
import com.example.budget.budgetApp.User.model.User;
import com.example.budget.budgetApp.User.repository.UserRepository;
import com.example.budget.budgetApp.exception.ResourceNotFoundException;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private UserRepository userRepository;

	// get transactions
	public List<Transaction> getAllTransactions() {
		return this.transactionRepository.findAll();
	}

	public ResponseEntity<Transaction> getTransactionById(@PathVariable(value = "id") Long transactionId)
			throws ResourceNotFoundException {
		Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(
				() -> new ResourceNotFoundException("Transaction not found for this id :: " + transactionId));
		return ResponseEntity.ok().body(transaction);
	}

	// save transaction
	public Transaction createTransaction(Long userId, @RequestBody Transaction transactions) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserId" + userId + " not found"));
		transactions.setUser(user);
		return transactionRepository.save(transactions);
	}

	// update transaction
	public ResponseEntity<Transaction> updateTransaction(@PathVariable(value = "id") Long transactionId,
			@Validated @RequestBody Transaction transactionDetails) throws ResourceNotFoundException {
		Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(
				() -> new ResourceNotFoundException("Transaction not found for this id :: " + transactionId));
		transaction.setDescription(transaction.getDescription());
		transaction.setAmount(transaction.getAmount());
		transaction.setCategory(transaction.getCategory());

		return ResponseEntity.ok(this.transactionRepository.save(transaction));

	}

	// delete transaction
	public Map<String, Boolean> deleteTransaction(@PathVariable(value = "id") Long transactionId) throws ResourceNotFoundException {
		Transaction transaction = transactionRepository.findById(transactionId)
				.orElseThrow(()-> new ResourceNotFoundException("Transaction not found for this id :: " + transactionId));
		
		this.transactionRepository.delete(transaction);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
