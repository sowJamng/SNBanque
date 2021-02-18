package com.senbanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senbanque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long > {

}
