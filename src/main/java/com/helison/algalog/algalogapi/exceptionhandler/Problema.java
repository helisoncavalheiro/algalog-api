package com.helison.algalog.algalogapi.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//só inclui campos preenchidos
@JsonInclude(Include.NON_NULL)
public class Problema {
  
  private Integer status;
  private OffsetDateTime dataHora;
  private String titulo;
  private List<Campo> campos;
  public static class Campo{
    private String nome;
    private String mensagem;

    public Campo(String nome, String mensagem){
      this.nome = nome;
      this.mensagem = mensagem;
    }

    public String getNome() {
      return this.nome;
    }
  
    public String getMensagem() {
      return this.mensagem;
    }
        
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public OffsetDateTime getDataHora() {
    return this.dataHora;
  }

  public void setDataHora(OffsetDateTime dataHora) {
    this.dataHora = dataHora;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public List<Campo> getCampos() {
    return this.campos;
  }

  public void setCampos(List<Campo> campos) {
    this.campos = campos;
  }

}
