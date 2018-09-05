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
	private boolean chef_service;
	private boolean chef_departement;
	@ManyToOne
	private Service service;
	@OneToMany(mappedBy="poste")
    Set<User> users = new HashSet<User>();
	
	
	public Poste() {
		
	}
	
	public Poste(String poste, boolean chef_service, boolean chef_departement, Service service,Set<User> users) {
		this.poste = poste;
		this.chef_service = chef_service;
		this.chef_departement = chef_departement;
		this.service = service;
		this.users=users;
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
		return chef_service;
	}

	public void setChefService(boolean chef_service) {
		this.chef_service = chef_service;
	}

	public boolean isChefDepartement() {
		return chef_departement;
	}

	public void setChefDepartement(boolean chef_departement) {
		this.chef_departement = chef_departement;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public boolean isChef_service() {
		return chef_service;
	}

	public void setChef_service(boolean chef_service) {
		this.chef_service = chef_service;
	}

	public boolean isChef_departement() {
		return chef_departement;
	}

	public void setChef_departement(boolean chef_departement) {
		this.chef_departement = chef_departement;
	}
	
	
}
