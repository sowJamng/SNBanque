package com.senbanque.metiers;

public interface OperationsMetier {

	public void retirer(Long codeCompte,double montant,Long codeEmp);
	public void verser(Long codeCompte,double montant,Long codeEmp);
	public void virement(Long codeCompte1,Long codeCompte2,double montant,Long codeEmp);
}
