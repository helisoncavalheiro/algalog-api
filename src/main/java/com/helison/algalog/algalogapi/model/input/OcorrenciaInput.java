package com.helison.algalog.algalogapi.model.input;

import javax.validation.constraints.NotBlank;

public class OcorrenciaInput {
  @NotBlank  
  private String descricao;

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
