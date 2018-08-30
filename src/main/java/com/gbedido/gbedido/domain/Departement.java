package com.gbedido.gbedido.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Departement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(length=80)
	private String lib;
	
	
	
	public Departement() {
		
	}
	
	public Departement(String lib) {
		this.lib = lib;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLib() {
		return lib;
	}
	public void setLib(String lib) {
		this.lib = lib;
	}
	
	
}
