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

import com.gbedido.gbedido.domain.Tache;
import com.gbedido.gbedido.repository.TacheRepository;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

	@Autowired
	TacheRepository tacheRepository;

	@PostMapping
	public ResponseEntity<Tache> saveTache(@RequestBody Tache tache)
	{
		return ResponseEntity.ok().body(tacheRepository.save(tache));
	}
	
	@GetMapping
	public ResponseEntity<Page<Tache>> findAllTaches(@PageableDefault(size=10)Pageable pageable)
	{
		Page<Tache> page=tacheRepository.findAll(pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping("/search-by-libelle")
	public ResponseEntity <Page<Tache>>searchTache(String lib, @PageableDefault(size=10)Pageable pageable)
	{
		Page<Tache> page=tacheRepository.findByLibContaining(lib, pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping("/{id}")
	public Tache findById(@PathVariable Long id)
	{
		return tacheRepository.findById(id).get();
	}
	
	@PutMapping
	public Tache updateTache(@RequestBody Tache tache)
	{
		return tacheRepository.save(tache);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteTache(@PathVariable Long id)
	{
		tacheRepository.deleteById(id);
		return ResponseEntity.ok().body(id);
	}
}
