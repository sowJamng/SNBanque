package com.senbanque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senbanque.entities.Compte;
import com.senbanque.metiers.CompteMetier;

@RestController
//RestControler ca v dir kon utilise utilise spring donc on va mettre pathvariable dans la recherche de compte
public class ComptRestService {
	@Autowired
	private CompteMetier compteMetier;
     
	@RequestMapping(value="/comptes",method=RequestMethod.POST)
	public Compte sveCompte(@RequestBody Compte c) {
		return compteMetier.sveCompte(c);
	}
	@RequestMapping(value="/comptes",method=RequestMethod.GET)
	public List<Compte> listCompte() {
		return compteMetier.listCompte();
	}
	
	@RequestMapping(value="/comptes/{code}",method=RequestMethod.GET)
	public Compte getCompte(@PathVariable Long code){
		return compteMetier.getCompte(code);
	}
	/*@GetMapping(value="/comptes/{codecmp}")
	public Compte consultertCompte(@PathVariable(name="codecmp") Long codecmp) {
		return compteMetier.consulterCompte(codecmp);
	}*/

}
