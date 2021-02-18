package com.senbanque.metierImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.senbanque.dao.EmployeRepository;
import com.senbanque.entities.Employes;
import com.senbanque.metiers.EmployeMetier;

@Service
public class EmployeMetierImp implements EmployeMetier{
	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public Employes saveEmploye( Employes e) {
		return employeRepository.save(e);
	}

	@Override
	public List<Employes> listEmployes() {
		return employeRepository.findAll();
	}
	
	

}
