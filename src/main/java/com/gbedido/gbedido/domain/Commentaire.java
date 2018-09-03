package com.gbedido.gbedido.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commentaire {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String description;
	
	public Commentaire() {
		
	}

	public Commentaire(String description) {
		this.description = description;
	}

	public Long getId_commentaire() {
		return id;
	}

	public void setId_commentaire(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
