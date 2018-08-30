package com.gbedido.gbedido.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.gbedido.gbedido.domain.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Long>{
	
	/*public Departement save(Departement departement);
	public List<Departement> findAll();
	public Departement findById(int id);*/
	@Query("SELECT c FROM Departement c WHERE c.lib LIKE CONCAT('%',:x,'%')")
	public List<Departement> chercher(@Param("x")String mc);
	
	public List<Departement> findByLibContaining(String lib);

}
