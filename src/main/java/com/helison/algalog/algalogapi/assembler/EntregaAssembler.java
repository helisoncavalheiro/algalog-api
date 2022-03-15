package com.helison.algalog.algalogapi.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.helison.algalog.algalogapi.domain.model.Entrega;
import com.helison.algalog.algalogapi.model.EntregaModel;
import com.helison.algalog.algalogapi.model.input.EntregaInput;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntregaAssembler {

  @Autowired
  private ModelMapper modelMapper;

  public EntregaModel toModel(Entrega entrega) {
    return modelMapper.map(entrega, EntregaModel.class);
  }

  public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
    return entregas.stream()
        .map(this::toModel)
        .collect(Collectors.toList());
  }

  public Entrega toEntity(EntregaInput entregaInput){
    return modelMapper.map(entregaInput, Entrega.class);
  }

}
