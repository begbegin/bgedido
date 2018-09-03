package com.gbedido.gbedido.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gbedido.gbedido.domain.StatusTache;

public interface StatusTacheRepository extends JpaRepository<StatusTache,Long>{

	public Page<StatusTache> findByStatusContaining(String status,Date date,Pageable pageable);
}
