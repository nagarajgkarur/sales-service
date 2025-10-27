package com.stock.management.sales_service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponseEntity {

	private int offset;
	private int max;
	private Long totalRecords;
	private List<ProductResponse> products;
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
	public Long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<ProductResponse> getProducts() {
		return products;
	}
	public void setProducts(List<ProductResponse> products) {
		this.products = products;
	}
	
}
