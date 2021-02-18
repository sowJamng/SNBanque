package com.senbanque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Employes implements Serializable{
	
	public Employes(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmp;
	private String nom;
	private String prenom;
	@ManyToOne
	@JoinColumn(name="code_emp_sup")
	private Employes employeSup;
	@OneToMany(mappedBy ="employes",fetch = FetchType.LAZY)
	private Collection<Compte> comptes;
	@OneToMany(mappedBy = "employes",fetch = FetchType.LAZY)
	private Collection<Operations> operations;
	@ManyToMany
	@JoinColumn(name="Emp_groupe")
	private Collection<Groupe> groupes;
	
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	public Employes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(Long idEmp) {
		this.idEmp = idEmp;
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
	@JsonIgnore
	public Employes getEmployeSup() {
		return employeSup;
	}
	@JsonSetter
	public void setEmployeSup(Employes employeSup) {
		this.employeSup = employeSup;
	}
	@JsonIgnore
	public Collection<Compte> getComptes() {
		return comptes;
	}
	@JsonSetter
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	@JsonIgnore
	public Collection<Operations> getOperations() {
		return operations;
	}
	@JsonSetter
	public void setOperations(Collection<Operations> operations) {
		this.operations = operations;
	}
	
	

}
