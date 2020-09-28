package com.example.ozona.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ozona.Model.Prices;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long>{

}