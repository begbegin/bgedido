package com.gbedido.gbedido.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rapport {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length=80)
	private String lib;
	private Date date;
	private boolean etat;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Commentaire commentaire;
	@ManyToOne(cascade=CascadeType.ALL)
	Agent agent;
	@ManyToOne(cascade=CascadeType.ALL)
	StatusTache statusTache;
	public Rapport() {
		
	}
	public Rapport(String lib, Date date, boolean etat, Commentaire commentaire, Agent agent, StatusTache statusTache) {
		this.lib = lib;
		this.date = date;
		this.etat = etat;
		this.commentaire = commentaire;
		this.agent = agent;
		this.statusTache = statusTache;
	}
	public Long getId_rapport() {
		return id;
	}
	public void setId_rapport(Long id) {
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
	public Commentaire getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public StatusTache getStatusTache() {
		return statusTache;
	}
	public void setStatusTache(StatusTache statusTache) {
		this.statusTache = statusTache;
	}
	
	
	
}
