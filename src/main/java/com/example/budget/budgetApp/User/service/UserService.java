package com.example.budget.budgetApp.User.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.budget.budgetApp.User.model.User;
import com.example.budget.budgetApp.User.repository.UserRepository;
import com.example.budget.budgetApp.exception.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		
		return ResponseEntity.ok().body(user);
	}
	
}
