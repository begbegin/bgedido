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

import com.gbedido.gbedido.domain.Statustache;
import com.gbedido.gbedido.repository.StatustacheRepository;


@RestController
@RequestMapping("/api/status-taches")
public class SatatustacheController {

	@Autowired
	StatustacheRepository statusTacheRepository;

	@PostMapping
	public ResponseEntity<Statustache> saveStatustache(@RequestBody Statustache statustache)
	{
		return ResponseEntity.ok().body(statusTacheRepository.save(statustache));
	}
	
	@GetMapping
	public ResponseEntity<Page<Statustache>> findAllStatustaches(@PageableDefault(size=10)Pageable pageable)
	{
		Page<Statustache> page=statusTacheRepository.findAll(pageable);
		return ResponseEntity.ok().body(page);
	}
	
	
	@GetMapping("/{id}")
	public Statustache findById(@PathVariable Long id)
	{
		return statusTacheRepository.findById(id).get();
	}
	
	@PutMapping
	public Statustache updateStatustache(@RequestBody final Statustache statusTache)
	{
		
		return statusTacheRepository.save(statusTache);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deletestatusTache(@PathVariable Long id)
	{
		statusTacheRepository.deleteById(id);
		return ResponseEntity.ok().body(id);
	}
}
