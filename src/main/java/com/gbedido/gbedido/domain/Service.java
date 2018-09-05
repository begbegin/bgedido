package com.gbedido.gbedido.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Service {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length=80)
	private String lib;
	@ManyToOne
	Departement departement;
	@OneToMany(mappedBy="service")
    Set<Poste> postes = new HashSet<Poste>();
	
	public Service() {
		
	}

	public Service(String lib, Departement departement, Set<Poste> postes) {
		this.lib = lib;
		this.departement = departement;
		this.postes = postes;
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
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
}
