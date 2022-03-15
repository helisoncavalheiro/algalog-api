package com.helison.algalog.algalogapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.helison.algalog.algalogapi.assembler.EntregaAssembler;
import com.helison.algalog.algalogapi.domain.model.Entrega;
import com.helison.algalog.algalogapi.domain.repository.EntregaRepository;
import com.helison.algalog.algalogapi.domain.service.FinalizacaoEntregaService;
import com.helison.algalog.algalogapi.domain.service.SolicitacaoEntregaService;
import com.helison.algalog.algalogapi.model.EntregaModel;
import com.helison.algalog.algalogapi.model.input.EntregaInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

  @Autowired
  private SolicitacaoEntregaService solicitacaoEntregaService;

  @Autowired
  private EntregaRepository entregaRepository;

  @Autowired
  private EntregaAssembler entregaAssembler;

  @Autowired
  private FinalizacaoEntregaService finalizacaoEntregaService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
    Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
    Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
    return entregaAssembler.toModel(entregaSolicitada);
  }

  @GetMapping
  public List<EntregaModel> listar() {
    return entregaAssembler.toCollectionModel(entregaRepository.findAll());
  }

  @GetMapping("/{entregaId}")
  public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
    return entregaRepository.findById(entregaId)
        .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
        .orElse(ResponseEntity.notFound().build());
  }
  
  @PutMapping("/{entregaId}/finalizacao")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void finalizar(@PathVariable Long entregaId){
    finalizacaoEntregaService.finalizar(entregaId);
  }

}
