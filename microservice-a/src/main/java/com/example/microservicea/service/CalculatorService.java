package com.example.microservicea.service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient("microservice-b")
@Cacheable("Calculator")
public interface CalculatorService {
    @GetMapping("/calculate/{firstParam}/{secondParam}")
    Object getResult(@PathVariable float firstParam, @PathVariable float secondParam);
}