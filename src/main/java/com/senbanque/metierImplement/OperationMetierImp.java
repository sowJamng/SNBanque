package com.senbanque.metierImplement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senbanque.dao.CompteRepository;
import com.senbanque.dao.EmployeRepository;
import com.senbanque.dao.OperationRepository;
import com.senbanque.entities.Compte;
import com.senbanque.entities.CompteCourant;
import com.senbanque.entities.Employes;
import com.senbanque.entities.Operations;
import com.senbanque.entities.Retrait;
import com.senbanque.entities.Versement;
import com.senbanque.metiers.CompteMetier;
import com.senbanque.metiers.OperationsMetier;

@Transactional
@Service
public class OperationMetierImp implements OperationsMetier{
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    CompteMetier compteMetier;
    
 
	@Override
	public void retirer(Long codeCompte, double montant, Long codeEmp) {
		Employes emp=employeRepository.findById(codeEmp).get();
		Compte cp= compteMetier.getCompte(codeCompte);
	if(cp!=null) {
		double faciliteCaisse=0;
		if(cp instanceof CompteCourant) {
		faciliteCaisse=((CompteCourant)cp).getDecouvert();
		if(faciliteCaisse+ cp.getSolde()<montant) 
			throw new RuntimeException("Solde insuffisant pour effectuer cette operation");	
		//compteRepository.update()		
		Operations op=new Retrait(montant,new Date(),cp);
		op.setEmployes(emp);
		operationRepository.save(op);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);					
		}
	}
	else throw new RuntimeException("compte inexistant");
			
	}
 
	@Override
	public void verser(Long codeCompte, double montant, Long codeEmp) {
		Employes emp=employeRepository.findById(codeEmp).get();
		Compte cp= compteMetier.getCompte(codeCompte);
	if(cp!=null) {		
		Operations op=new Versement(montant,new Date(),cp);
		op.setEmployes(emp);
		operationRepository.save(op);
		cp.setSolde(cp.getSolde()+montant);
		compteRepository.save(cp);					
		}
	else throw new RuntimeException("compte inexistant");
		
	}

	@Override
	public void virement(Long codeCompte1, Long codeCompte2, double montant, Long codeEmp) {
		retirer(codeCompte1,montant,codeEmp);
		verser(codeCompte2,montant,codeEmp);
		
	}
	

}
