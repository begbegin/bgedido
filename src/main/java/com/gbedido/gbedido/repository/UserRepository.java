package com.gbedido.gbedido.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gbedido.gbedido.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{

	public Page<User> findByNomContaining(String nom, Pageable pageable);

}
