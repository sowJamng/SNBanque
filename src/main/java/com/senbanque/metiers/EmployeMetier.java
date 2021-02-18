package com.senbanque.metiers;

import java.util.List;

import com.senbanque.entities.Employes;

public interface EmployeMetier {
	public Employes saveEmploye(Employes e);
	public List<Employes> listEmployes();

}
