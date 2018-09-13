package com.gbedido.gbedido.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

import com.gbedido.gbedido.domain.Tache;
import com.gbedido.gbedido.repository.StatustacheRepository;
import com.gbedido.gbedido.repository.TacheRepository;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

	@Autowired
	TacheRepository tacheRepository;
	StatustacheRepository statustacheRepository;
	@PostMapping
	public ResponseEntity<Tache> saveTache(@RequestBody final Tache tache)
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
	
	@PostMapping("/{id}")
	public Tache updateTache(@PathVariable Long id,@RequestBody final Tache tache)
	{
		tache.setId(id);
		return tacheRepository.save(tache);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteTache(@PathVariable Long id)
	{
		tacheRepository.deleteById(id);
		return ResponseEntity.ok().body(id);
	}

	@GetMapping("/tachestoday")
	public ResponseEntity<Page<Tache>> tachesToday(Long idUsers,String dateString,@PageableDefault(size=10)Pageable pageable) throws ParseException
	{
		Date date;
		if(dateString==null)
		{
			date= new Date();
		}
		else
		{
			SimpleDateFormat formater= new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			date = formater.parse(dateString);
		}
		Page<Tache> page = tacheRepository.findAllByDate(date, idUsers, pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping("/tachesstatus")
	public ResponseEntity<Page<Tache>> tachesstatus(Long idUsers,String status,@PageableDefault(size=10)Pageable pageable) throws ParseException
	{
		String statu;
		if(status==null)
		{
			statu= "Commencer";
		}
		else
		{
			statu=status;
		}
		Page<Tache> page = tacheRepository.findAllByStatus(statu, idUsers, pageable);
		return ResponseEntity.ok().body(page);
	}
	
}
