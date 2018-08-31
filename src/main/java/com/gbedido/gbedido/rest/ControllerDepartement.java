package com.gbedido.gbedido.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
public class ControllerDepartement {

	@Autowired
	DepartementRepository departementRepository;
	
	@PostMapping(value="/departements")
	public long saveDepartement(@RequestBody final Departement departement )
	{
		departementRepository.save(departement);
		return departement.getId();
	}
	
	@GetMapping("/departements")
	public ResponseEntity<Page> findAllDepartement(Pageable pageable) {
		PageRequest pageables=new PageRequest(0,3);
		
		Page<Departement> page = departementRepository.findAll(pageables);
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.add("nombre", Integer.toString(page.getTotalPages()));
	 
	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body(departementRepository.findAll(pageables));
	}
	
	@GetMapping(value="/departements/{id}")
	public Departement getDepartement(@PathVariable long id)
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
	public String deleteDepartement(@PathVariable long id)
	{
		departementRepository.deleteById(id);	
		return "departement supprimer";
	}
	
	@GetMapping(value="/search-departements-by-libelle")
	public List<Departement> searchDepartement(String lib)
	{
		return departementRepository.findByLibContaining(lib);
	}
	
	
	
}