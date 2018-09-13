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

import com.gbedido.gbedido.domain.Commentaire;
import com.gbedido.gbedido.repository.CommentaireRepository;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

	@Autowired

	CommentaireRepository commentaireRepository;
	

	@PostMapping
	public ResponseEntity<Commentaire> saveCommentaire(@RequestBody final Commentaire commentaire)
	{
		return ResponseEntity.ok().body(commentaireRepository.save(commentaire));
	}
	
	@GetMapping
	public ResponseEntity<Page<Commentaire>> findAllCommenttaire(@PageableDefault(size=10)Pageable pageable)
	{
		Page<Commentaire> page=commentaireRepository.findAll(pageable);
		return ResponseEntity.ok().body(page);
	}
	
	
	@GetMapping("/{id}")
	public Commentaire findById(@PathVariable Long id)
	{
		return commentaireRepository.findById(id).get();
	}
	
	@PostMapping("/{id}")
	public Commentaire updateCommentaire(@PathVariable Long id, @RequestBody final Commentaire commentaire)
	{
		commentaire.setId(id);
		return commentaireRepository.save(commentaire);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteCommentaire(@PathVariable Long id)
	{
		commentaireRepository.deleteById(id);
		return ResponseEntity.ok().body(id);
	}
}
