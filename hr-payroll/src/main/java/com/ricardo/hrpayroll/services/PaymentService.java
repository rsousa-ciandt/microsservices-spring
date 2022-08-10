package com.ricardo.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import com.ricardo.hrpayroll.feignclients.WorkerFeingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ricardo.hrpayroll.entities.Payment;
import com.ricardo.hrpayroll.entities.Worker;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeingClient workerFeingClient;

	public Payment getPayment(int workerId, int days) {
		Worker worker = this.workerFeingClient.getWorkers(workerId).getBody();

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
