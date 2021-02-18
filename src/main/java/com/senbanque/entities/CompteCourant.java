package com.senbanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
private double decouvert;

public double getDecouvert() {
	return decouvert;
}

public CompteCourant(Date dateCreation, double solde,Client client, double decouvert) {
	super(dateCreation, solde,client);
	this.decouvert = decouvert;
}

public CompteCourant() {
	super();
	// TODO Auto-generated constructor stub
}


public void setDecouvert(double decouvert) {
	this.decouvert = decouvert;
}

	
}
