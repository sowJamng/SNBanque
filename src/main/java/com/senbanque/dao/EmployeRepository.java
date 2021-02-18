package com.senbanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senbanque.entities.Employes;

public interface EmployeRepository extends JpaRepository<Employes, Long> {

}
