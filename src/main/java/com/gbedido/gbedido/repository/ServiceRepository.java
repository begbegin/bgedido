package com.gbedido.gbedido.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gbedido.gbedido.domain.Service;

public interface ServiceRepository extends JpaRepository<Service,Long>{

	public Page <Service>findByLibContaining(String lib, Pageable pageable);
}
