package com.senbanque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senbanque.metiers.OperationsMetier;

@RestController
public class OperationRestService {
	@Autowired
	private OperationsMetier operationMetier;

	@RequestMapping(value="/retrait",method=RequestMethod.PUT)
	public void retirer(@RequestParam Long codeCompte,@RequestParam  double montant,@RequestParam  Long codeEmp) {
		operationMetier.retirer(codeCompte, montant, codeEmp);
	}

	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public void verser(@RequestParam Long codeCompte,@RequestParam  double montant,@RequestParam  Long codeEmp) {
		operationMetier.verser(codeCompte, montant, codeEmp);
	}
	@RequestMapping(value="/virement",method=RequestMethod.PUT)
	public void virement(@RequestParam Long codeCompte1,@RequestParam  Long codeCompte2,@RequestParam  double montant, @RequestParam Long codeEmp) {
		operationMetier.virement(codeCompte1, codeCompte2, montant, codeEmp);
	}
	

}
