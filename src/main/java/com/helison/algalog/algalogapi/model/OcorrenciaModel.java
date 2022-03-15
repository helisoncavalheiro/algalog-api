package com.helison.algalog.algalogapi.model;

import java.time.OffsetDateTime;

public class OcorrenciaModel {
  private Long id;
  private String descricao;
  private OffsetDateTime dataRegistro;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public OffsetDateTime getDataRegistro() {
    return this.dataRegistro;
  }

  public void setDataRegistro(OffsetDateTime dataRegistro) {
    this.dataRegistro = dataRegistro;
  }

}
