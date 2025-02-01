package com.upskill.category.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.upskill.category.model.Category;
import com.upskill.category.repository.CategoryRepository;

@RestController
@CrossOrigin
public class CategoryController {
	@Autowired
	private Environment environment;
	
	@Autowired
	private CategoryRepository repo;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getCategories() {
	
		String port = environment.getProperty("local.server.port");
		System.out.println("env port "+ port);
		
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}

	
	@GetMapping("/category/{id}")
	public ResponseEntity<String> getCategoryById(@PathVariable int id) {
	
		String port = environment.getProperty("local.server.port");
		System.out.println("env port "+ port);
		
		return new ResponseEntity<>(repo.findById(id).get().getName(), HttpStatus.OK);
	}
}
