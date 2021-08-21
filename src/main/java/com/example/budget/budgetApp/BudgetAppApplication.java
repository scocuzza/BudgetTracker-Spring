package com.example.budget.budgetApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.budget.budgetApp.Transaction.model.Transaction;
import com.example.budget.budgetApp.Transaction.repository.TransactionRepository;
import com.example.budget.budgetApp.User.model.User;
import com.example.budget.budgetApp.User.repository.UserRepository;

@SpringBootApplication
public class BudgetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetAppApplication.class, args);
	}
	
	  @Bean
	    public CommandLineRunner mappingDemo(UserRepository userRepository,
	                                         TransactionRepository transactionRepository) {
	        return args -> {

	            // create a new user
//	            User user = new User("Steve", 1000);

	            // save the user
//	            userRepository.save(user);

	            // create and save new pages
//	            transactionRepository.save(new Transaction("Rent", -1000, "Housing", user));
//	            transactionRepository.save(new Transaction("Food", -150, "Groceries", user));
//	            transactionRepository.save(new Transaction("Car", -150, "Transportation", user));
//	            transactionRepository.save(new Transaction("Subscriptions", -150, "Lifestyle", user));
//	            transactionRepository.save(new Transaction("Salary", 1000, "Income", user));
//	            transactionRepository.save(new Transaction("Investments",1000, "Income", user));
	        };
	  }
}
