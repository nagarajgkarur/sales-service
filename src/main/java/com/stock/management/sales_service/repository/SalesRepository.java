package com.stock.management.sales_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.management.sales_service.domain.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long>{

}
