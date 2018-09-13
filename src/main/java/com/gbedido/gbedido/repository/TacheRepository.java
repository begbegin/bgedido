package com.gbedido.gbedido.repository;


import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gbedido.gbedido.domain.Tache;

public interface TacheRepository extends JpaRepository<Tache,Long>{

	public Page<Tache> findByLibContaining(String lib, Pageable pageable);
	
	
	@Query("SELECT tache FROM Statustache s WHERE s.date=:dateJour AND s.rapport.user.id=:idUsers" )
	public Page<Tache> findAllByDate(@Param("dateJour") Date date, @Param("idUsers") Long id, Pageable pageable);
	
	@Query("SELECT tache FROM Statustache s WHERE s.status=:status AND s.rapport.user.id=:idUsers" )
	public Page<Tache> findAllByStatus(@Param("status") String status, @Param("idUsers") Long id, Pageable pageable);
}
