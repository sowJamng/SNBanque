package com.senbanque.metierImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.senbanque.dao.ClientRepository;
import com.senbanque.entities.Client;
import com.senbanque.metiers.ClientMetier;

// @service pour que spring instanci le bean apre ca on va creer la classe microserbive dans pack service 
//sion on mt pas le @service ou @compnent l'injection fait par autowired ne v pas marcher
@Service //pour dire quon a un bean  spring pour considerer la classe comme bean
//on pouver aussi utiliser @vomponent pour indiquer a spring qu cest un bean
public class ClientMetierImp implements ClientMetier {
	@Autowired
private ClientRepository clientRepository;
	@Override
	public Client saveClient( Client c) {
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listClient() {
		
		return clientRepository.findAll();
	}

}
