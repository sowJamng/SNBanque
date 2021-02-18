package com.senbanque.metiers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.senbanque.entities.Compte;
import com.senbanque.entities.Operations;

public interface IBanque {
	//public Compte consulerCompte(Long numero);
	public void verser(Long numero, double montant);
	public void retirer(Long numero, double montant);
	public void virement(Long numerocp1,Long numerocp2, double montant);
	// on utilise page de spring data pour consulter des operations effectuees
	public Page<Operations> listOperation(Long numerocp,int page,int size);
	public Compte getCompt(Long id) ;

}
