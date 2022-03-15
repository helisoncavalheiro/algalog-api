package com.helison.algalog.algalogapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.helison.algalog.algalogapi.assembler.OcorrenciaAssembler;
import com.helison.algalog.algalogapi.domain.model.Ocorrencia;
import com.helison.algalog.algalogapi.domain.service.BuscaEntregaService;
import com.helison.algalog.algalogapi.domain.service.RegistroOcorrenciaService;
import com.helison.algalog.algalogapi.model.OcorrenciaModel;
import com.helison.algalog.algalogapi.model.input.OcorrenciaInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

  @Autowired
  private RegistroOcorrenciaService registroOcorrenciaService;

  @Autowired
  private OcorrenciaAssembler ocorrenciaAssembler;

  @Autowired
  private BuscaEntregaService buscaEntregaService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OcorrenciaModel registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput){
    Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
  
    return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
  }

  @GetMapping
  public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
    List<Ocorrencia> ocorrencias = buscaEntregaService.buscar(entregaId).getOcorrencias();
    
    return ocorrenciaAssembler.toCollectionModel(ocorrencias);
  }
  
}
