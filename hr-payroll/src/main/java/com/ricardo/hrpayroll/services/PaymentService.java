package com.ricardo.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.ricardo.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public PaymentService() {
		System.out.println("service");		
	}
	
	public Payment getPayment(int workerId, int days) {
		return new Payment("Ricardo", 45.0, 7);
	}
	
}
