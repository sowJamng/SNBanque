package com.senbanque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length=1)
public abstract class Operations implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numop;
	private double montant;
	private Date dateop;
	@ManyToOne
	@JoinColumn(name="codeCmpte")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name="codeEmp")
	private Employes employes;
	public Long getNumop() {
		return numop;
	}
	public void setNumop(Long numop) {
		this.numop = numop;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateop() {
		return dateop;
	}
	public void setDateop(Date dateop) {
		this.dateop = dateop;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Employes getEmployes() {
		return employes;
	}
	public void setEmployes(Employes employes) {
		this.employes = employes;
	}
	public Operations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operations(double montant, Date dateop,Compte cp) {
		super();
		this.montant = montant;
		this.dateop = dateop;
		this.compte=cp;
	}
	
	

}
