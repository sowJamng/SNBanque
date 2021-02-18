package com.senbanque.metiers;

import java.util.List;
import java.util.Optional;

import com.senbanque.entities.Compte;

public interface CompteMetier {
	public Compte sveCompte(Compte c);
	public List<Compte> listCompte();
	public Compte getCompte(Long code);
	//public Compte consulterCompte(Long codecmp);

}
