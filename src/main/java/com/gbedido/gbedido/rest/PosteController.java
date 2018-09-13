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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbedido.gbedido.domain.Poste;
import com.gbedido.gbedido.repository.PosteRepository;

@RestController
@RequestMapping("/api/postes")
public class PosteController {

	@Autowired
	PosteRepository postRepository;
	
	@PostMapping
	public ResponseEntity <Poste>  savePost(@RequestBody final Poste poste)
	{
		return ResponseEntity.ok().body(postRepository.save(poste));
	}
	
	@GetMapping
	public ResponseEntity<Page<Poste>> findAllPostes(@PageableDefault(size=10)Pageable pageable)
	{
		Page<Poste> page=postRepository.findAll(pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping("/search-by-libelle")
	public ResponseEntity <Page<Poste>>searchPoste(String poste, @PageableDefault(size=10)Pageable pageable)
	{
		Page<Poste> page=postRepository.findByPosteContaining(poste, pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping("/{id}")
	public Poste findById(@PathVariable Long id)
	{
		return postRepository.findById(id).get();
	}
	
	@PostMapping("/{id}")
	public Poste updatePoste(@PathVariable Long id, @RequestBody final Poste poste)
	{
		poste.setId(id);
		return postRepository.save(poste);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deletePoste(@PathVariable Long id)
	{
		postRepository.deleteById(id);
		return ResponseEntity.ok().body(id);
	}
}
