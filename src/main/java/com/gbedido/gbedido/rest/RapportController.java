package com.gbedido.gbedido.rest;

import java.util.Date;

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

import com.gbedido.gbedido.domain.Rapport;
import com.gbedido.gbedido.repository.RapportRepository;

@RestController
public class RapportController {

	@Autowired
	RapportRepository rapportRepository;
	
	Rapport rapport;

	@PostMapping(value="/rapports")
	public void saveRapport(@RequestBody Rapport rapport)
	{
		rapportRepository.save(rapport);
	}
	
	@GetMapping(value="/rapports")
	public ResponseEntity<Page<Rapport>> findAllRapport(@PageableDefault(size=10)Pageable pageable)
	{
		Page<Rapport> page=rapportRepository.findAll(pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	
	@GetMapping(value="/search-rapport-by-libelle")
	public ResponseEntity <Page<Rapport>>searchRapport(String lib,Date date, @PageableDefault(size=10)Pageable pageable)
	{
		Page<Rapport> page=rapportRepository.findByLibContaining(lib, date, pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	
	@GetMapping(value="/rapport/{id}")
	public Rapport findById(@PathVariable Long id)
	{
		return rapportRepository.findById(id).get();
	}
	
	@PutMapping(value="/rapports")
	public String updateRapport(@RequestBody Rapport rapport)
	{
		rapportRepository.save(rapport);
		return "Mise A jour Ok";
	}
	
	@DeleteMapping(value="/rapport/{id}")
	public String deleteRapport(@PathVariable Long id)
	{
		rapportRepository.deleteById(id);
		return "Suppression faite";
	}
}
