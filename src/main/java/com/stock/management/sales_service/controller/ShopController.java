package com.stock.management.sales_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.management.sales_service.dto.ShopPayload;
import com.stock.management.sales_service.dto.ShopResponseEntity;
import com.stock.management.sales_service.service.ShopService;

@RestController
@RequestMapping("/api/v1/shop")
public class ShopController {

	@Autowired
	ShopService shopService;
	
	@GetMapping("")
	public ResponseEntity<ShopResponseEntity> getAllShops(){
		ShopResponseEntity shopResponseEntity = shopService.getAllShops();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(shopResponseEntity);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ShopResponseEntity> getShopsById(Long id){
		ShopResponseEntity shopResponseEntity =  shopService.getShopById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(shopResponseEntity);
	}
	
	@PostMapping("")
	public ResponseEntity<ShopResponseEntity> createShop(@RequestBody ShopPayload shopPayload){
		ShopResponseEntity shopResponseEntity = shopService.createShop(shopPayload);
		return ResponseEntity.status(HttpStatus.CREATED).body(shopResponseEntity);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ShopResponseEntity> updateshop(@RequestBody ShopPayload shopPayload, Long id){
		ShopResponseEntity shopResponseEntity = shopService.updateShop(shopPayload,id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(shopResponseEntity);
	}
}
