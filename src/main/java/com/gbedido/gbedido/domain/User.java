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
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length=80)
	private String nom;
	@Column(length=100)
	private String prenoms;
	@Column(length=45)
	private String login;
	@Column(length=45)
	private String password;
	@Column(length=45)
	private int telephone;
	@Column(length=45)
	private String email;
	@ManyToOne
	private Poste poste;
	@OneToMany(mappedBy="user")
    Set<Rapport> rapport = new HashSet<Rapport>();
	public User() {
		
	}
	
	public User(String nom, String prenoms, String login, String password, int telephone, String email, Poste poste,
			Set<Rapport> rapport) {
		this.nom = nom;
		this.prenoms = prenoms;
		this.login = login;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
		this.poste = poste;
		this.rapport = rapport;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
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
