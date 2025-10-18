package com.stock.management.sales_service.dto;

import java.util.List;

public class ShopResponseEntity {
	
	private int max;
	private int offset;
	private int totalRecords;
	private List<ShopResponse> shopResponses;
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<ShopResponse> getShopResponses() {
		return shopResponses;
	}
	public void setShopResponses(List<ShopResponse> shopResponses) {
		this.shopResponses = shopResponses;
	}

}
