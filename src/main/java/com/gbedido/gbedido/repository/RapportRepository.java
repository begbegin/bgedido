package com.gbedido.gbedido.repository;


import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gbedido.gbedido.domain.Rapport;


public interface RapportRepository extends JpaRepository<Rapport,Long>{

	public Page<Rapport> findByLibAndDate(String lib,Date date, Pageable pageable);
	public Page<Rapport> findByUserId(Long userId, Pageable pageable);
	
}

