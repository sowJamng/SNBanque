package com.senbanque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senbanque.entities.Client;
import com.senbanque.metiers.ClientMetier;
//Get pour consulter ,Post pour ajouter et put pour modifier
@RestController // avec ca tt va etr retourne en format json
public class ClientRestService {
	@Autowired
	ClientMetier clientMetier;

	@RequestMapping(value="/clients",method=RequestMethod.POST)
	//requestMapping il doit recuperer les donnes dans le corps de la requete en format JSON
	public Client saveClient(@RequestBody Client c) {
		return clientMetier.saveClient(c);
	} 

	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public List<Client> listClient() {
		return clientMetier.listClient();
	}
	

}
