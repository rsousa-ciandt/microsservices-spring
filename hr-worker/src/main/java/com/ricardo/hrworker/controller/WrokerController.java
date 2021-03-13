package com.ricardo.hrworker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.hrworker.entities.Worker;
import com.ricardo.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WrokerController {
	
	@Autowired
	private WorkerRepository workerRepository;

	@GetMapping
	public ResponseEntity<Iterable<Worker>> getWorkers() {
		return ResponseEntity.ok(workerRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> getWorkers(@PathVariable int id) {
		return ResponseEntity.ok(workerRepository.findById(id).get());
	}	
}
