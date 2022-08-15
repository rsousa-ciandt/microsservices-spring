package com.pierleaning.hrpayroll.feignclients;

import com.pierleaning.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", path = "/workers") // marca a interface como um feign client

// Feign Client são "interfaces de comunicação" dos serviços que estamos consumindo
// Basta imaginar que o celular tem uma entrada (interface) para o carregador (serviço)
public interface WorkerFeingClient {

    // Cada método deve ter a mesma assinatura declarada no serviço
    // Independente se o seviço é em outra linguagem, a assinatura deve ser "traduzida" para o Spring
    @GetMapping("/{id}")
    ResponseEntity<Worker> getWorker(@PathVariable int id);
}
