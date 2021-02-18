package com.senbanque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Groupe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGoupe;
	private String nomGp;
	@ManyToMany(mappedBy = "groupes")
	private Collection<Employes> employes;
	public Groupe(String nomGp) {
		super();
		this.nomGp = nomGp;
	}

	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdGoupe() {
		return idGoupe;
	}

	public void setIdGoupe(Long idGoupe) {
		this.idGoupe = idGoupe;
	}

	public String getNomGp() {
		return nomGp;
	}

	public void setNomGp(String nomGp) {
		this.nomGp = nomGp;
	}

	public Collection<Employes> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employes> employes) {
		this.employes = employes;
	}

	
	
	

}
