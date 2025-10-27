package com.stock.management.sales_service.service.utility;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.management.sales_service.domain.Shop;
import com.stock.management.sales_service.dto.ShopPayload;
import com.stock.management.sales_service.dto.ShopResponse;
import com.stock.management.sales_service.repository.ShopRepository;

@Component
public class ShopUtility {

	@Autowired
	ShopRepository shopRepository;
	
	public List<ShopResponse> getShopResponses(List<Shop> shops) {
		return shops.stream().map(e->getShopResponse(e)).collect(Collectors.toList());
	}
	
	public ShopResponse getShopResponse(Shop shop) {
		ShopResponse shopResponse = new ShopResponse();
		shopResponse.setAddress(shop.getAddress());
		shopResponse.setContactNumber(shop.getContactNumber());
		shopResponse.setCreatedAt(shop.getCreatedAt());
		shopResponse.setEmail(shop.getEmail());
		shopResponse.setShopId(shop.getShopId());
		shopResponse.setShopName(shop.getShopName());
		shopResponse.setUpdatedAt(shop.getUpdatedAt());
		return shopResponse;
	}

	public Shop getShop(ShopPayload shopPayload, Long id) {
		Shop shop = null;
		if(id==null) {
			shop = new Shop();
			shop.setCreatedAt(LocalDateTime.now());
		}else {
			shop = shopRepository.findById(id).orElseThrow();
		}
		
		if(StringUtils.isNotBlank(shopPayload.getAddress())) {
			shop.setAddress(shopPayload.getAddress());
		}
		if(StringUtils.isNotBlank(shopPayload.getContactNumber())) {
			shop.setContactNumber(shopPayload.getContactNumber());
		}
		if(StringUtils.isNotBlank(shopPayload.getEmail())) {
			shop.setEmail(shopPayload.getEmail());
		}
		if(StringUtils.isNotBlank(shopPayload.getShopName())) {
			shop.setShopName(shopPayload.getShopName());
		}
		return shop;
	}

}
