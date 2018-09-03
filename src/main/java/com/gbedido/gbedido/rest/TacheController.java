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

import com.gbedido.gbedido.domain.Tache;
import com.gbedido.gbedido.repository.TacheRepository;

@RestController
public class TacheController {

	@Autowired
	TacheRepository tacheRepository;
	
	Tache tache;

	@PostMapping(value="/taches")
	public void saveTache(@RequestBody Tache tache)
	{
		tacheRepository.save(tache);
	}
	
	@GetMapping(value="/taches")
	public ResponseEntity<Page<Tache>> findAllTaches(@PageableDefault(size=10)Pageable pageable)
	{
		Page<Tache> page=tacheRepository.findAll(pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	
	@GetMapping(value="/search-tache-by-libelle")
	public ResponseEntity <Page<Tache>>searchTache(String lib, @PageableDefault(size=10)Pageable pageable)
	{
		Page<Tache> page=tacheRepository.findByLibContaining(lib, pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	
	@GetMapping(value="/tache/{id}")
	public Tache findById(@PathVariable Long id)
	{
		return tacheRepository.findById(id).get();
	}
	
	@PutMapping(value="/taches")
	public String updateTache(@RequestBody Tache tache)
	{
		tacheRepository.save(tache);
		return "Mise A jour Ok";
	}
	
	@DeleteMapping(value="/tache/{id}")
	public String deleteTache(@PathVariable Long id)
	{
		tacheRepository.deleteById(id);
		return "Suppression faite";
	}
}
