package com.pierleaning.hrpayroll.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pierleaning.hrpayroll.entities.Payment;
import com.pierleaning.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private PaymentService payment;

	// Essa annotation marca o seguinte método como uma "implementação de Circuit Braker".
	// Quer dizer que poderá haver problemas na comunicação dos serviços, ex a queda de um serviço.
	// Em caso de falha, o método mencionado no "fallbackMethod" irá ser acionado para redirecionar o fluxo
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
