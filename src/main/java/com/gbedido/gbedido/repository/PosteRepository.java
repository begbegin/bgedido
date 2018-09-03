package com.gbedido.gbedido.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gbedido.gbedido.domain.Poste;

public interface PosteRepository extends JpaRepository<Poste,Long>{

	public Page <Poste>findByPosteContaining(String lib, Pageable pageable);
}
