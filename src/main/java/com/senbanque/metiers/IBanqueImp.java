package com.senbanque.metiers;

import java.util.Date;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.senbanque.dao.CompteRepository;
import com.senbanque.dao.OperationRepository;
import com.senbanque.entities.Compte;
import com.senbanque.entities.CompteCourant;
import com.senbanque.entities.Operations;
import com.senbanque.entities.Retrait;
import com.senbanque.entities.Versement;

@Service
//pour tout les instructions qui son dans une methode sexecutent correctement 
//ou on annule tout.on sassure que tout se passe bien
@Transactional
public class IBanqueImp implements IBanque{
	// il faut injecter aussi les dependances
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;

	/*@Override
	public Compte consulerCompte(Long numero) {
	//Compte cp=compteRepository.findOne(numero);
		if(cp==null) throw new RuntimeException("compte introuvable");	
		return cp;	
	}*/
	@Override
	public Compte getCompt( Long id) {
		return compteRepository.findById(id).get();
	}

	@Override
	public void verser(Long numero, double montant) {
		if(montant<=0) throw new RuntimeException("veuillez bien verifie le solde que vous entrez");
		//Compte cp=this.consulerCompte(numero);
		Compte cp=this.getCompt(numero);
		if(montant>0) {
		Versement v=new Versement(montant,new Date(),cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()+montant);
		compteRepository.save(cp);
		}
		
	}

	@Override
	public void retirer(Long numero, double montant) {
		Compte cp=this.getCompt(numero);
		double faciliteCaisse=0;
		if(cp instanceof CompteCourant) {
		faciliteCaisse=((CompteCourant)cp).getDecouvert();
		if(faciliteCaisse+ cp.getSolde()<montant) 
			throw new RuntimeException("Solde insuffisant");		
		Retrait r=new Retrait(montant,new Date(),cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);		
	  }
	}

	@Override
	public void virement(Long numerocp1,Long numerocp2, double montant) {
		retirer(numerocp1,montant);
		verser(numerocp2,montant);
		
	}

	@Override
	public Page<Operations> listOperation(Long numerocp, int page, int size) {
	//return operationRepository.listOperation(numerocp,new PageRequest(page,size));
		return null;
	
	}
// service pour que spring puisse instancier la cla&sse au demarage de lapplication
	

}
