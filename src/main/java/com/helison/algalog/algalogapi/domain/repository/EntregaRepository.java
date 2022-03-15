package com.helison.algalog.algalogapi.domain.repository;

import com.helison.algalog.algalogapi.domain.model.Entrega;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
  


}
