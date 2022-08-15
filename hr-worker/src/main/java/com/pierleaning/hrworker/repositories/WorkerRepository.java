package com.pierleaning.hrworker.repositories;

import com.pierleaning.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Integer>{

}
