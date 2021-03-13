package com.ricardo.hrworker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.hrworker.entities.Worker;
import com.ricardo.hrworker.repositories.WorkerRepository;

@RestController
public class WrokerController {
	
	@Autowired
	private WorkerRepository workerRepository;

	@GetMapping
	public ResponseEntity<Iterable<Worker>> getWorkers() {
		return ResponseEntity.ok(workerRepository.findAll());
	}
}
