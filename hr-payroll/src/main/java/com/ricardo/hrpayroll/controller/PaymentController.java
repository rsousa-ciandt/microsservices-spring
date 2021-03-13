package com.ricardo.hrpayroll.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.hrpayroll.entities.Payment;
import com.ricardo.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private PaymentService payment;	

	@GetMapping
	public ResponseEntity<Payment> get(@PathParam(value = "id") int id,@PathParam(value = "days") int days) {
		Payment payment = this.payment.getPayment(id, days);
	
		return ResponseEntity.ok(payment);
	}
}
