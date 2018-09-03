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

import com.gbedido.gbedido.domain.StatusTache;
import com.gbedido.gbedido.repository.StatusTacheRepository;


@RestController
public class SatatusTacheController {

	@Autowired
	StatusTacheRepository statusTacheRepository;
	
	StatusTache statusTache;

	@PostMapping(value="/status-taches")
	public void saveStatusTache(@RequestBody StatusTache statusTache)
	{
		statusTacheRepository.save(statusTache);
	}
	
	@GetMapping(value="/status-taches")
	public ResponseEntity<Page<StatusTache>> findAllStatusTaches(@PageableDefault(size=10)Pageable pageable)
	{
		Page<StatusTache> page=statusTacheRepository.findAll(pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	
	@GetMapping(value="/search-statustache-by-libelle")
	public ResponseEntity <Page<StatusTache>>searchStatusTache(String status,Date date, @PageableDefault(size=10)Pageable pageable)
	{
		Page<StatusTache> page=statusTacheRepository.findByStatusContaining(status, date, pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	
	@GetMapping(value="/status_tache/{id}")
	public StatusTache findById(@PathVariable Long id)
	{
		return statusTacheRepository.findById(id).get();
	}
	
	@PutMapping(value="/status-taches")
	public String updateStatudsTache(@RequestBody StatusTache statusTache)
	{
		statusTacheRepository.save(statusTache);
		return "Mise A jour Ok";
	}
	
	@DeleteMapping(value="/status-tache/{id}")
	public String deletestatusTache(@PathVariable Long id)
	{
		statusTacheRepository.deleteById(id);
		return "Suppression faite";
	}
}
