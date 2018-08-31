package com.gbedido.gbedido.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gbedido.gbedido.domain.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Long>{
	
	
	
	
	public Page<Departement> findByLibContaining(String lib,Pageable pageable);	
	
	
	
	
}
