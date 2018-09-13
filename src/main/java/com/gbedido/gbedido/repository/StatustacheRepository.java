package com.gbedido.gbedido.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gbedido.gbedido.domain.Statustache;

public interface StatustacheRepository extends JpaRepository<Statustache,Long>{
	
	
	public Page<Statustache> findByStatusAndDate(String status, Date date, Pageable pageable);
	
	public Page<Statustache> findByDate(Date date, Pageable pageable);
	
}
