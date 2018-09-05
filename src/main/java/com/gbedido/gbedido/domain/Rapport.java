package com.gbedido.gbedido.domain;

import java.util.Date;
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
public class Rapport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length=80)
	private String lib;
	private String description;
	private Date date;
	private boolean etat;
	
	@ManyToOne
	User user;
	@OneToMany(mappedBy="rapport")
    Set<Statustache> statustaches = new HashSet<Statustache>();
	
	@OneToMany(mappedBy="rapport")
    Set<Commentaire> commentaires = new HashSet<Commentaire>();
	
	public Rapport() {
		
	}
	
	public Rapport(String lib, String description,Date date, boolean etat, User user, Set<Statustache> statustaches,
			Set<Commentaire> commentaires) {
		this.lib = lib;
		this.description=description;
		this.date = date;
		this.etat = etat;
		this.user = user;
		this.statustaches = statustaches;
		this.commentaires = commentaires;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
