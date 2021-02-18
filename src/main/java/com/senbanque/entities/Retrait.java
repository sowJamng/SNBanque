package com.senbanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operations  {

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(double montant, Date dateop, Compte cp) {
		super(montant, dateop, cp);
		// TODO Auto-generated constructor stub
	}

}
