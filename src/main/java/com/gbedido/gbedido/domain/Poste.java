package com.gbedido.gbedido.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Poste {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length=80)
	private String poste;
	private boolean chefservice;
	private boolean chefdepartement;
	@ManyToOne(cascade=CascadeType.ALL)
	private Service service;
	
	public Poste() {
		
	}

	public Poste(String poste, boolean chefservice, boolean chefdepartement, Service service) {
		this.poste = poste;
		this.chefservice = chefservice;
		this.chefdepartement = chefdepartement;
		this.service = service;
	}

	public Long getId_poste() {
		return id;
	}

	public void setId_poste(Long id) {
		this.id = id;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public boolean isChefService() {
		return chefservice;
	}

	public void setChefService(boolean cherservice) {
		this.chefservice = cherservice;
	}

	public boolean isChefDepartement() {
		return chefdepartement;
	}

	public void setChefDepartement(boolean chefdepartement) {
		this.chefdepartement = chefdepartement;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
}
