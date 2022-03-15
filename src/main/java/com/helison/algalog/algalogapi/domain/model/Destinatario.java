package com.helison.algalog.algalogapi.domain.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Destinatario {
  @NotBlank
  @Column(name = "destinatario_nome")
  private String nome;
  
  @NotBlank
  @Column(name = "destinatario_logradouro")
  private String logradouro;

  @NotBlank
  @Column(name = "destinatario_numero")
  private String numero;

  @NotBlank
  @Column(name = "destinatario_complemento")
  private String complemento;

  @NotBlank
  @Column(name = "destinatario_bairro")
  private String bairro;

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

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Destinatario)) {
      return false;
    }
    Destinatario destinatario = (Destinatario) o;
    return Objects.equals(nome, destinatario.nome) && Objects.equals(logradouro, destinatario.logradouro)
        && Objects.equals(numero, destinatario.numero) && Objects.equals(complemento, destinatario.complemento)
        && Objects.equals(bairro, destinatario.bairro);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, logradouro, numero, complemento, bairro);
  }

}
