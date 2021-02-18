package com.senbanque.metierImplement;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.senbanque.dao.CompteRepository;
import com.senbanque.entities.Compte;
import com.senbanque.metiers.CompteMetier;

@Service
public class CompteMetierImp implements CompteMetier{
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte sveCompte(Compte c) {
		c.setDateCreation(new Date());
		return compteRepository.save(c);
	}

	@Override
	public List<Compte> listCompte() {
		return compteRepository.findAll();
	}

	@Override
	public Compte getCompte(Long code) {
		return compteRepository.findById(code).get();
	}
	
	/*@Override
	public Compte consulterCompte(Long codecmp) {
		return compteRepository.findById(codecmp).get();
	}*/

}
