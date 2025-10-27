package com.stock.management.sales_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.management.sales_service.domain.Shop;
import com.stock.management.sales_service.dto.ShopPayload;
import com.stock.management.sales_service.dto.ShopResponse;
import com.stock.management.sales_service.dto.ShopResponseEntity;
import com.stock.management.sales_service.repository.ShopRepository;
import com.stock.management.sales_service.service.utility.ShopUtility;

@Service
public class ShopService {
	
	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	ShopUtility shopUtility;

	public ShopResponseEntity getAllShops() {
		List<Shop> shops = shopRepository.findAll();
		List<ShopResponse> shopResponses = shopUtility.getShopResponses(shops);  
		ShopResponseEntity shopResponseEntity = new ShopResponseEntity();
		shopResponseEntity.setShopResponses(shopResponses);
		return shopResponseEntity;
	}

	public ShopResponseEntity getShopById(Long id) {
		Shop shop= shopRepository.findById(id).orElseThrow();
		List<Shop> shops = new ArrayList<Shop>();
		shops.add(shop);
		List<ShopResponse> shopResponses = shopUtility.getShopResponses(shops);
		ShopResponseEntity shopResponseEntity = new ShopResponseEntity();
		shopResponseEntity.setShopResponses(shopResponses);
		return shopResponseEntity;
	}

	public ShopResponseEntity createShop(ShopPayload shopPayload) {
		Shop shop = shopUtility.getShop(shopPayload,null);
		shop = shopRepository.save(shop);
		List<Shop> shops = new ArrayList<Shop>();
		shops.add(shop);
		List<ShopResponse> shopResponses = shopUtility.getShopResponses(shops);
		ShopResponseEntity shopResponseEntity = new ShopResponseEntity();
		shopResponseEntity.setShopResponses(shopResponses);
		return shopResponseEntity;
	}

	public ShopResponseEntity updateShop(ShopPayload shopPayload, Long id) {
		Shop shop = shopUtility.getShop(shopPayload,id);
		List<Shop> shops = new ArrayList<Shop>();
		shops.add(shop);
		List<ShopResponse> shopResponses = shopUtility.getShopResponses(shops);
		ShopResponseEntity shopResponseEntity = new ShopResponseEntity();
		shopResponseEntity.setShopResponses(shopResponses);
		return shopResponseEntity;
	}

}
