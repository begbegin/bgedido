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
public class StatusTache {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length=45)
	private String status;
	private Date date;
	@ManyToOne(cascade=CascadeType.ALL)
	private Tache tache;

	public StatusTache() {

	}

	public StatusTache(String status, Date date, Tache tache) {
		this.status = status;
		this.date = date;
		this.tache = tache;
	}

	public Long getId_status() {
		return id;
	}

	public void setId_status(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}
}
