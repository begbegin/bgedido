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

import com.gbedido.gbedido.domain.Agent;
import com.gbedido.gbedido.repository.AgentRepository;


@RestController
public class AgentController {

	@Autowired
	AgentRepository agentRepository;
	
	Agent agent;

	@PostMapping(value="/agents")
	public void saveAgent(@RequestBody Agent agent)
	{
		agentRepository.save(agent);
	}
	
	@GetMapping(value="/agents")
	public ResponseEntity<Page<Agent>> findAllAgents(@PageableDefault(size=10)Pageable pageable)
	{
		Page<Agent> page=agentRepository.findAll(pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	
	@GetMapping(value="/search-agent-by-libelle")
	public ResponseEntity <Page<Agent>>searchAgent(String nom, @PageableDefault(size=10)Pageable pageable)
	{
		Page<Agent> page=agentRepository.findByNomContaining(nom, pageable);
		HttpHeaders header=new HttpHeaders();
		header.add("nbrTotalePage", Integer.toString(page.getTotalPages()));
		return ResponseEntity.accepted().headers(header).body(page);
	}
	
	@GetMapping(value="/agent/{id}")
	public Agent findById(@PathVariable Long id)
	{
		return agentRepository.findById(id).get();
	}
	
	@PutMapping(value="/agents")
	public String updateAgent(@RequestBody Agent agent)
	{
		agentRepository.save(agent);
		return "Mise A jour Ok";
	}
	
	@DeleteMapping(value="/agent/{id}")
	public String deleteAgent(@PathVariable Long id)
	{
		agentRepository.deleteById(id);
		return "Suppression faite";
	}
}
