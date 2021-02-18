package com.senbanque.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYP_CPTE",length=2)

//on fait tout ca parsk compte est une classe abstraite
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
//type cest a dire le type de compte propriete dans json
@JsonSubTypes({
	@Type(name="CC",value=CompteCourant.class),
	@Type(name="CE",value=CompteEpargne.class)
}) 
public abstract class Compte implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCompte;	
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name="codeClient")
	private Client client;
	@ManyToOne
	@JoinColumn(name="codeEmp")
	private Employes employes;
	@OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
	private Collection<Operations> operations;
	public Compte( Date dateCreation, double solde,Client client) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client=client;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(Long codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employes getEmployes() {
		return employes;
	}
	public void setEmploye(Employes employes) {
		this.employes = employes;
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
