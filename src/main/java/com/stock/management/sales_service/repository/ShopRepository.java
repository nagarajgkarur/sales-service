package com.stock.management.sales_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.management.sales_service.domain.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{

}
