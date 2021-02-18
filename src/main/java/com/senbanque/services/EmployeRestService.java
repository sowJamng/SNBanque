package com.senbanque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senbanque.entities.Employes;
import com.senbanque.metiers.EmployeMetier;
@RestController
public class EmployeRestService {
	@Autowired
	private EmployeMetier empMetier;
    
	@RequestMapping(value="/employes",method=RequestMethod.POST)
	public Employes saveEmploye(@RequestBody Employes e) {
		//sans le requestBody il ne pourra pas enregister un employe car il ne  va pas prendre le format jsonn
		return empMetier.saveEmploye(e);
	}
     
	@RequestMapping(value="/employes",method=RequestMethod.GET)
	public List<Employes> listEmployes() {
		return empMetier.listEmployes();
	}


}
