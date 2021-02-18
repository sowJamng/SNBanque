package com.senbanque.metiers;

import java.util.List;

import com.senbanque.entities.Client;

public interface ClientMetier  {
public Client saveClient(Client c);
public List<Client> listClient();
}
