package com.helison.algalog.algalogapi.domain.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ocorrencia {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Entrega entrega;
  
  private String descricao;
  private OffsetDateTime dataRegistro;


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Entrega getEntrega() {
    return this.entrega;
  }

  public void setEntrega(Entrega entrega) {
    this.entrega = entrega;
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

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ocorrencia)) {
            return false;
        }
        Ocorrencia ocorrencia = (Ocorrencia) o;
        return Objects.equals(id, ocorrencia.id) && Objects.equals(entrega, ocorrencia.entrega) && Objects.equals(descricao, ocorrencia.descricao) && Objects.equals(dataRegistro, ocorrencia.dataRegistro);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, entrega, descricao, dataRegistro);
  }

}
