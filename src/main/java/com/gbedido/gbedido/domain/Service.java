package com.gbedido.gbedido.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Service {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length=80)
	private String lib;
	@ManyToOne(cascade=CascadeType.ALL)
	Departement departement;
	public Service() {
		
	}
	public Service(String lib,Departement departement) {
		this.lib = lib;
		this.departement=departement;
	}
	public Long getid_service() {
		return id;
	}
	public void setid_service(Long id) {
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
