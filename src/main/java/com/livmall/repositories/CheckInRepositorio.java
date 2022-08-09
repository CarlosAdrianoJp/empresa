package com.livmall.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livmall.entities.CheckIn;

public interface CheckInRepositorio extends JpaRepository<CheckIn, Long> {
	
	

}
