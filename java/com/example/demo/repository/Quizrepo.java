package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Quizentity;

@Repository
public interface Quizrepo extends JpaRepository<Quizentity,Integer> {
	
	@Query(value = "SELECT u FROM Quizentity u WHERE u.type = ?1")
	List<Quizentity> getByQuizeType(int type);
}