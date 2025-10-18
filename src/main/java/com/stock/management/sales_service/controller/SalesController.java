package com.stock.management.sales_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.management.sales_service.dto.SalesInvoicePayload;
import com.stock.management.sales_service.dto.SalesResponseEntity;
import com.stock.management.sales_service.service.SalesService;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {
	
	@Autowired
	SalesService salesService;
	
	@GetMapping("")
	public ResponseEntity<SalesResponseEntity> getAllSalesInvoice(){
		SalesResponseEntity salesResponseEntity = salesService.getAllSalesInvoice();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(salesResponseEntity);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SalesResponseEntity> getSalesInvoiceById(@PathVariable Long id){
		SalesResponseEntity salesResponseEntity = salesService.getSalesInvoiceById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(salesResponseEntity);
	}
	
	@PostMapping("")
	public ResponseEntity<SalesResponseEntity> createSalesInvoice(@RequestBody SalesInvoicePayload salesInvoicePayload){
		SalesResponseEntity salesResponseEntity = salesService.createSalesInvoice(salesInvoicePayload);
		return ResponseEntity.status(HttpStatus.CREATED).body(salesResponseEntity);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SalesResponseEntity> updateSalesInvoice(@RequestBody SalesInvoicePayload invoicePayload,Long id){
		SalesResponseEntity salesResponseEntity = salesService.updateSalesInvoice(invoicePayload,id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(salesResponseEntity);
	}

}
