package com.gbedido.gbedido.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gbedido.gbedido.domain.Departement;
import com.gbedido.gbedido.repository.DepartementRepository;


@RestController
public class DepartementController {

	@Autowired
	DepartementRepository departementRepository;
	
	@PostMapping(value="/departements")
	public ResponseEntity <Departement> saveDepartement(@RequestBody final Departement departement )
	{
		departementRepository.save(departement);
		HttpHeaders header= new HttpHeaders();
		header.add("202","Requete Accepter");
		return ResponseEntity.accepted().headers(header).body(null);
	}
	
	@GetMapping("/departements")
	public ResponseEntity<Page<Departement>> findAllDepartement(@PageableDefault(size=10)Pageable pageable) {
		Page<Departement> page = departementRepository.findAll(pageable);
		HttpHeaders header = new HttpHeaders();
	    header.add("nbreTotalePage ",Integer.toString(page.getTotalPages()));
	    return ResponseEntity.accepted().headers(header).body(page);
	}
	
	@GetMapping(value="/departements/{id}")
	public Departement getDepartement(@PathVariable Long id)
	{
		return departementRepository.findById(id).get();
	}
	
	@PutMapping(value="/departements")
	public String updateDepartement(@RequestBody final Departement departement)
	{
		departementRepository.save(departement);
		return "mise A JOUR OK";
	}

	@DeleteMapping(value="/departements/{id}")
	public String deleteDepartement(@PathVariable Long id)
	{
		departementRepository.deleteById(id);	
		return "departement supprimer";
	}
	
	@GetMapping(value="/search-departements-by-libelle")
	public ResponseEntity<Page<Departement>> searchDepartement(String lib,@PageableDefault(size=3) Pageable pageable)
	{
		System.out.println(pageable);
		Page<Departement> page = departementRepository.findByLibContaining(lib,pageable);
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.add("nombre", Integer.toString(page.getTotalPages()));
	    return new ResponseEntity(page.getContent(),responseHeaders,HttpStatus.OK);
		
	}
	
}