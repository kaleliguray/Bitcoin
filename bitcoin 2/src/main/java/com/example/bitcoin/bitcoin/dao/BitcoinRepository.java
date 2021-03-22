package com.example.bitcoin.bitcoin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bitcoin.bitcoin.entity.Bitcoin;

public interface BitcoinRepository extends JpaRepository<Bitcoin, Integer> {
	
}
