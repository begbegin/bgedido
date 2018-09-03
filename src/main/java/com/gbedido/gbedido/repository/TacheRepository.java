package com.gbedido.gbedido.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gbedido.gbedido.domain.Tache;

public interface TacheRepository extends JpaRepository<Tache,Long>{
	
	public Page<Tache> findByLibContaining(String lib, Pageable pageable);
}
