package com.ricardo.hrpayroll.services;

import com.ricardo.hrpayroll.feignclients.WorkerFeingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.hrpayroll.entities.Payment;
import com.ricardo.hrpayroll.entities.Worker;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeingClient workerFeingClient;

	public Payment getPayment(int workerId, int days) {
		Worker worker = this.workerFeingClient.getWorker(workerId).getBody();

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
