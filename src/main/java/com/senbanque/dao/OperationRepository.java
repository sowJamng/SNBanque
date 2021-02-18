package com.senbanque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senbanque.entities.Operations;

public interface OperationRepository extends JpaRepository<Operations, Long> {
	@Query("select o from Operations o where o.compte.codeCompte=:x order by o.dateop desc")
	public Page<Operations> listOperation(@Param("x")Long codeCp,Pageable pageable);

}
