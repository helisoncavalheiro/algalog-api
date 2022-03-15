package com.helison.algalog.algalogapi.domain.service;

import com.helison.algalog.algalogapi.domain.model.Entrega;
import com.helison.algalog.algalogapi.domain.model.Ocorrencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroOcorrenciaService {

  @Autowired
  private BuscaEntregaService buscaEntregaService;

  @Transactional
  public Ocorrencia registrar(Long entregaId, String descricao){
    
    Entrega entrega = buscaEntregaService.buscar(entregaId);
    /**
     * Quando um método é anotado com o @Transactional, akarta Persistence sincroniza as alterações feitas nos objetos carregados.
     * Neste caso, qualquer alteração no objeto entrega será persistida no DB.
     * Quando a ocorrência é salva na entrega, a JPA salva essa ocorrência automaticamente no DB, dispensando o uso do save()
     * */ 
    return entrega.adicionarOcorrencia(descricao);
  }

}
