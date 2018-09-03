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

import com.gbedido.gbedido.domain.Commentaire;
import com.gbedido.gbedido.repository.CommentaireRepository;

@RestController
public class CommentaireController {

	@Autowired

	CommentaireRepository commentaireRepository;
	
	Commentaire commentaire;

	@PostMapping(value="/commentaires")
	public void saveCommentaire(@RequestBody Commentaire commentaire)
	{
		commentaireRepository.save(commentaire);
	}
	
	@GetMapping(value="/Commentaires")
	public ResponseEntity<Page<Commentaire>> findAllCommenttaire(@PageableDefault(size=10)Pageable pageable)
	{
		Page<Commentaire> page=commentaireRepository.findAll(pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	
	
	@GetMapping(value="/commentaire/{id}")
	public Commentaire findById(@PathVariable Long id)
	{
		return commentaireRepository.findById(id).get();
	}
	
	@PutMapping(value="/commentaires")
	public String updateCommentaire(@RequestBody Commentaire commentaire)
	{
		commentaireRepository.save(commentaire);
		return "Mise A jour Ok";
	}
	
	@DeleteMapping(value="/commentaire/{id}")
	public String deleteCommentaire(@PathVariable Long id)
	{
		commentaireRepository.deleteById(id);
		return "Suppression faite";
	}
}
