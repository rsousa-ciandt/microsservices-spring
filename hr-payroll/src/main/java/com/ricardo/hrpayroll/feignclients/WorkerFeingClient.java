package com.ricardo.hrpayroll.feignclients;

import com.ricardo.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "localhost:3001", path = "/workers")
public interface WorkerFeingClient {
    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkers(@PathVariable int id);
}
