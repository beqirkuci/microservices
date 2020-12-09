package com.example.microservicea.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservicea.model.CalculatorBean;

@Service
@FeignClient("microservice-b")
public interface CalculatorService {
    @GetMapping("/calculate/{firstParam}/{secondParam}")
    CalculatorBean getResult(@PathVariable float firstParam, @PathVariable float secondParam);
}