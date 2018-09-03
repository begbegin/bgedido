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

import com.gbedido.gbedido.domain.Poste;
import com.gbedido.gbedido.repository.PosteRepository;

@RestController
public class PosteController {

	@Autowired
	PosteRepository postRepository;
	
	Poste poste;
	
	@PostMapping(value="/postes")
	public void savePost(@RequestBody Poste poste)
	{
		postRepository.save(poste);
	}
	
	@GetMapping(value="/postes")
	public ResponseEntity<Page<Poste>> findAllPostes(@PageableDefault(size=10)Pageable pageable)
	{
		Page<Poste> page=postRepository.findAll(pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	
	@GetMapping(value="/search-poste-by-libelle")
	public ResponseEntity <Page<Poste>>searchPoste(String poste, @PageableDefault(size=10)Pageable pageable)
	{
		Page<Poste> page=postRepository.findByPosteContaining(poste, pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	
	@GetMapping(value="/postes/{id}")
	public Poste findById(@PathVariable Long id)
	{
		return postRepository.findById(id).get();
	}
	
	@PutMapping(value="/postes")
	public String updatePoste(@RequestBody Poste Poste)
	{
		postRepository.save(poste);
		return "Mise A jour Ok";
	}
	
	@DeleteMapping(value="/postes/{id}")
	public String deletePoste(@PathVariable Long id)
	{
		postRepository.deleteById(id);
		return "Suppression faite";
	}
}
