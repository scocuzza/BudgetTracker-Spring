package com.example.budget.budgetApp.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.budget.budgetApp.User.model.User;
import com.example.budget.budgetApp.User.service.UserService;
import com.example.budget.budgetApp.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/api/v1/")
public class UserController {	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// get Users
	@GetMapping("users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	// get User by id
	@GetMapping("/users/{id}")
		public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long UserId) throws ResourceNotFoundException {
			return userService.getUserById(UserId);
	}
}
