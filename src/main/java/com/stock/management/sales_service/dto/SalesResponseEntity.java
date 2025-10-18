package com.stock.management.sales_service.dto;

import java.util.List;

public class SalesResponseEntity {
	
	private int offset;
	private int max;
	private int totalRecords;
	private List<SalesResponse> salesResponses;
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
	public List<SalesResponse> getSalesResponses() {
		return salesResponses;
	}
	public void setSalesResponses(List<SalesResponse> salesResponses) {
		this.salesResponses = salesResponses;
	}
	
	

}
