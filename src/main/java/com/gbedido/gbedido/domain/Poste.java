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
public class Poste {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length=80)
	private String poste;
	private boolean chefService;
	private boolean chefDepartement;
	@ManyToOne
	private Service service;
	@OneToMany(mappedBy="poste")
    Set<User> users = new HashSet<User>();
	
	
	
	public Poste() {

	}

	public Poste(String poste, boolean chefService, boolean chefDepartement, Service service, Set<User> users) {
		super();
		this.poste = poste;
		this.chefService = chefService;
		this.chefDepartement = chefDepartement;
		this.service = service;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public boolean isChefService() {
		return chefService;
	}

	public void setChefService(boolean chefService) {
		this.chefService = chefService;
	}

	public boolean isChefDepartement() {
		return chefDepartement;
	}

	public void setChefDepartement(boolean chefDepartement) {
		this.chefDepartement = chefDepartement;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
	
	
	
	
	
}
