package com.gbedido.gbedido.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tache {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String lib;
	private String description;
	
	public Tache() {
		
	}

	public Tache(String lib, String description) {
		this.lib = lib;
		this.description = description;
	}

	public Long getId_tache() {
		return id;
	}

	public void setId_tache(Long id) {
		this.id = id;
	}

	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
