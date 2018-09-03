package com.gbedido.gbedido.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Agent {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length=80)
	private String nom;
	@Column(length=100)
	private String prenom;
	@Column(length=45)
	private String login;
	@Column(length=45)
	private String password;
	@Column(length=45)
	private int telephone;
	@Column(length=45)
	private String email;
	@ManyToOne(cascade=CascadeType.ALL)
	private Poste poste;
	
	public Agent() {
		
	}

	public Agent(String nom, String prenom, String login, String password, int telephone, String email, Poste poste) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
		this.poste = poste;
	}

	public Long getId_agent() {
		return id;
	}

	public void setId_agent(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}
		
}
