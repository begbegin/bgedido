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

import com.gbedido.gbedido.domain.Rapport;
import com.gbedido.gbedido.repository.RapportRepository;

@RestController
@RequestMapping("/api/rapports")
public class RapportController {

	@Autowired
	RapportRepository rapportRepository;

	@PostMapping
	public ResponseEntity<Rapport> saveRapport(@RequestBody final Rapport rapport)
	{
		return ResponseEntity.ok().body(rapportRepository.save(rapport));
	}
	
	@GetMapping
	public ResponseEntity<Page<Rapport>> findAllRapport(@PageableDefault(size=10)Pageable pageable)
	{
		Page<Rapport> page=rapportRepository.findAll(pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping("/search-by-libelle-date")
	public ResponseEntity <Page<Rapport>>searchRapport(String lib, String dateString, @PageableDefault(size=10)Pageable pageable) throws ParseException
	{
		SimpleDateFormat formater =new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);	
		Date date = formater.parse(dateString);
		Page<Rapport> page=rapportRepository.findByLibAndDate(lib, date, pageable);
		System.out.println("date" +date);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping("/{id}")
	public Rapport findById(@PathVariable Long id)
	{
		return rapportRepository.findById(id).get();
	}
	
	@PostMapping("/{id}")
	public Rapport updateRapport(@PathVariable Long id, @RequestBody final Rapport rapport)
	{
		rapport.setId(id);
		return rapportRepository.save(rapport);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteRapport(@PathVariable Long id)
	{
		rapportRepository.deleteById(id);
		return ResponseEntity.ok().body(id);
	}
	@GetMapping("/byusers")
	public ResponseEntity <Page<Rapport>> rapportByusers(Long userId, @PageableDefault(size=10)Pageable pageable)
	{
		Page<Rapport> page=rapportRepository.findByUserId(userId, pageable);
		return ResponseEntity.ok().body(page);
	}
}
