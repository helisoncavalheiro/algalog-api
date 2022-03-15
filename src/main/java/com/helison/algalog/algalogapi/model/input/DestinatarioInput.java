package com.helison.algalog.algalogapi.model.input;

import javax.validation.constraints.NotBlank;

public class DestinatarioInput {
  @NotBlank

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getLogradouro() {
    return this.logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getNumero() {
    return this.numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return this.complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return this.bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }
  private String nome;
  
  @NotBlank
  private String logradouro;

  @NotBlank
  private String numero;

  @NotBlank
  private String complemento;

  @NotBlank
  private String bairro;
}
