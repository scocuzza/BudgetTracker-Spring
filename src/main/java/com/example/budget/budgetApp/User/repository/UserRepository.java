package com.example.budget.budgetApp.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.budget.budgetApp.User.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
