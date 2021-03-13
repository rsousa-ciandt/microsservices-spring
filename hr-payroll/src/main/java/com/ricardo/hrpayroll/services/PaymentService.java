package com.ricardo.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ricardo.hrpayroll.entities.Payment;
import com.ricardo.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String host;
	
	private RestTemplate restTemplate;
	
	public PaymentService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Payment getPayment(int workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId + "");
		
		Worker worker = restTemplate.getForObject(host + "/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
