package com.senbanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{
	public double getTaux() {
		return taux;
	}

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(Date dateCreation, double solde,Client client, double taux) {
		super(dateCreation, solde,client);
		this.taux = taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	private double taux;

}
