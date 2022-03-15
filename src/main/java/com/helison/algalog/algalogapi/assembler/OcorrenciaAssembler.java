package com.helison.algalog.algalogapi.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.helison.algalog.algalogapi.domain.model.Ocorrencia;
import com.helison.algalog.algalogapi.model.OcorrenciaModel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OcorrenciaAssembler {
  
  @Autowired
  private ModelMapper mapper;

  public OcorrenciaModel toModel(Ocorrencia ocorrencia){
    return mapper.map(ocorrencia, OcorrenciaModel.class);
  }

  public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia> ocorrencias){
    return ocorrencias.stream().map(this::toModel).collect(Collectors.toList());
  }

}
