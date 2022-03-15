package com.helison.algalog.algalogapi.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.helison.algalog.algalogapi.domain.model.StatusEntrega;

public class EntregaModel {
  
  private Long id;
  private ClienteResumoModel cliente;
  private BigDecimal taxa;
  private StatusEntrega status;
  private OffsetDateTime dataPedido;
  private OffsetDateTime dataFinalizacao;
  private DestinatarioModel destinatario;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ClienteResumoModel getCliente() {
    return this.cliente;
  }

  public void setCliente(ClienteResumoModel cliente) {
    this.cliente = cliente;
  }

  public BigDecimal getTaxa() {
    return this.taxa;
  }

  public void setTaxa(BigDecimal taxa) {
    this.taxa = taxa;
  }

  public StatusEntrega getStatus() {
    return this.status;
  }

  public void setStatus(StatusEntrega status) {
    this.status = status;
  }

  public OffsetDateTime getDataPedido() {
    return this.dataPedido;
  }

  public void setDataPedido(OffsetDateTime dataPedido) {
    this.dataPedido = dataPedido;
  }

  public OffsetDateTime getDataFinalizacao() {
    return this.dataFinalizacao;
  }

  public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
    this.dataFinalizacao = dataFinalizacao;
  }

  public DestinatarioModel getDestinatario() {
    return this.destinatario;
  }

  public void setDestinatario(DestinatarioModel destinatario) {
    this.destinatario = destinatario;
  }

}
