package com.gbedido.gbedido.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
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
	
	Departement departement;
	@PostMapping(value="/departements")
	public List<Departement> saveDepartement(@RequestBody final Departement departement )
	{
		
		departementRepository.save(departement);
		return (List<Departement>)departementRepository.findAll();
	
	}
	
	@GetMapping(value="/departements")
	public List<Departement> getDepartements()
	{
		return  (List<Departement>)departementRepository.findAll();
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
	
	@GetMapping(value="list_Departement")
	public Page<Departement>showDeprtement(Pageable pageable)
	{
		PageRequest pageables=new PageRequest(1,5);
		return departementRepository.findAll(pageables);
	}
}