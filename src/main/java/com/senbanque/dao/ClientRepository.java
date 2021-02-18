package com.senbanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senbanque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
