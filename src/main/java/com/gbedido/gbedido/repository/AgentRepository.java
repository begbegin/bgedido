package com.gbedido.gbedido.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gbedido.gbedido.domain.Agent;

public interface AgentRepository extends JpaRepository<Agent,Long>{

	public Page<Agent> findByNomContaining(String nom, Pageable pageable);

}
