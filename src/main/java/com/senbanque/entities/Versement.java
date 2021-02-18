package com.senbanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operations {

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(double montant, Date dateop, Compte cp) {
		super(montant, dateop, cp);
		// TODO Auto-generated constructor stub
	}
	

}
