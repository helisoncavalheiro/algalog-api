package com.helison.algalog.algalogapi.domain.service;

import com.helison.algalog.algalogapi.domain.exception.EntidadeNaoEncontradaException;
import com.helison.algalog.algalogapi.domain.model.Entrega;
import com.helison.algalog.algalogapi.domain.repository.EntregaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaEntregaService {

  @Autowired
  private EntregaRepository entregaRepository;
  
  public Entrega buscar(Long entregaId){
    return entregaRepository.findById(entregaId).orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
  }
}
