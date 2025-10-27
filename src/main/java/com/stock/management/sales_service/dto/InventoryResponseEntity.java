package com.stock.management.sales_service.dto;

import java.util.List;

public class InventoryResponseEntity {
	
	private int offset;
	private int max;
	private int totalRecords;
	private List<InventoryResponse> inventoryResponses;
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<InventoryResponse> getInventoryResponses() {
		return inventoryResponses;
	}
	public void setInventoryResponses(List<InventoryResponse> inventoryResponses) {
		this.inventoryResponses = inventoryResponses;
	}
	
	

}
