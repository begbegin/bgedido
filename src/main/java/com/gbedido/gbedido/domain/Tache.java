package com.gbedido.gbedido.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tache {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length=80)
	private String lib;
	private String description;
	@OneToMany(mappedBy="tache")
    Set<Statustache> statustaches = new HashSet<Statustache>();
	
	public Tache() {
		
	}

	public Tache(String lib, String description, Set<Statustache> statustaches) {
		this.lib = lib;
		this.description = description;
		this.statustaches = statustaches;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
