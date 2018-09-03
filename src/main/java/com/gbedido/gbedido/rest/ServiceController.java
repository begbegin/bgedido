package com.gbedido.gbedido.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gbedido.gbedido.domain.Service;
import com.gbedido.gbedido.repository.ServiceRepository;

@RestController
public class ServiceController {

	@Autowired
	ServiceRepository serviceRepository;
	
	Service service;
	@PostMapping(value="/services")
	public void saveService(@RequestBody Service service)
	{
		System.out.println(service);
		serviceRepository.save(service);
		
	}
	
	@GetMapping(value="/services")
	public ResponseEntity<Page<Service>> findAllService(@PageableDefault(size=10)Pageable pageable)
	{
		Page<Service> page=serviceRepository.findAll(pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	
	@GetMapping(value="/search-services-by-libelle")
	public ResponseEntity <Page<Service>>searchService(String lib, @PageableDefault(size=10)Pageable pageable)
	{
		Page<Service> page=serviceRepository.findByLibContaining(lib, pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	@GetMapping(value="/service/{id}")
	public Service findById(@PathVariable Long id)
	{
		return serviceRepository.findById(id).get();
	}
	
	@PutMapping(value="/services")
	public String updateService(@RequestBody Service service)
	{
		serviceRepository.save(service);
		return "Mise A jour Ok";
	}
	
	@DeleteMapping(value="/service/{id}")
	public String deleteService(@PathVariable Long id)
	{
		serviceRepository.deleteById(id);
		return "Suppression faite";
	}
}
