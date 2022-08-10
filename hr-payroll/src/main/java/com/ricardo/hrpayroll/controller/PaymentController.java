package com.ricardo.hrpayroll.controller;

import javax.websocket.server.PathParam;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.hrpayroll.entities.Payment;
import com.ricardo.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private PaymentService payment;	

	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping("/{id}/{days}")
	public ResponseEntity<Payment> get(@PathVariable int id, @PathVariable int days) {
		Payment payment = this.payment.getPayment(id, days);
	
		return ResponseEntity.ok(payment);
	}

	//fluxo alternativo quando o serviço deu ruim
	public ResponseEntity<Payment> getPaymentAlternative(int id, int days) {
	 	return ResponseEntity.ok(new Payment("Mock", 400.0, days));
	}
}
