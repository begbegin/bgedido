package com.gbedido.gbedido.rest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbedido.gbedido.domain.Departement;
import com.gbedido.gbedido.repository.DepartementRepository;


@RestController
@RequestMapping("/api/departements")
public class DepartementController {

	@Autowired
	DepartementRepository departementRepository;
	
	@PostMapping
	public ResponseEntity <Departement> saveDepartement(@RequestBody final Departement departement )
	{
		return ResponseEntity.ok()
				.body(departementRepository.save(departement));
	}
	
	
	@GetMapping
	public ResponseEntity<Page<Departement>> findAllDepartement(@PageableDefault(size=10)Pageable pageable) {
		Page<Departement> page = departementRepository.findAll(pageable);
	    return ResponseEntity.ok().body(page);
	}
	
	@GetMapping("/search-by-libelle")
	public ResponseEntity<Page<Departement>> searchDepartement(@PathVariable String lib,@PageableDefault(size=3) Pageable pageable)
	{
		Page<Departement> page = departementRepository.findByLibContaining(lib,pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping("/{id}")
	public Departement getDepartement(@PathVariable Long id)
	{
		return departementRepository.findById(id).get();
	}
	
	@PutMapping
	public Departement updateDepartement(@RequestBody final Departement departement)
	{
		return departementRepository.save(departement);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity <Long> deleteDepartement(@PathVariable Long id)
	{
		departementRepository.deleteById(id);	
		return ResponseEntity.ok().body(id);
	}
	
}