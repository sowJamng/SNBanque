package com.senbanque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.senbanque.dao.ClientRepository;
import com.senbanque.dao.CompteRepository;
import com.senbanque.dao.OperationRepository;
import com.senbanque.entities.Client;
import com.senbanque.entities.Compte;
import com.senbanque.entities.CompteCourant;
import com.senbanque.entities.CompteEpargne;
import com.senbanque.entities.Retrait;
import com.senbanque.entities.Versement;

@SpringBootApplication
public class SnBanqueApplication {
	/*@Autowired implements CommandLineRunner
  private ClientRepository clientRepository;
	@Autowired
  private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;*/
	public static void main(String[] args) {
		SpringApplication.run(SnBanqueApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
Client c1=clientRepository.save(new Client("Maodo","Sow","kaolack","sow@gmail.com"));
Client c2=clientRepository.save(new Client("Aram","Ba","kaolack","aram@gmail.com"));

Compte cp1= compteRepository.save(new CompteCourant(new Date(),90000,c1,6000));
Compte cp2= compteRepository.save(new CompteEpargne(new Date(),6000,c2,5.5));

operationRepository.save(new Versement(9000,new Date(),cp1));
operationRepository.save(new Versement(23000,new Date(),cp1));
operationRepository.save(new Retrait(7000,new Date(),cp1));

operationRepository.save(new Versement(9000,new Date(),cp2));
operationRepository.save(new Versement(10000,new Date(),cp2));
operationRepository.save(new Retrait(5000,new Date(),cp2));
	} */

}
