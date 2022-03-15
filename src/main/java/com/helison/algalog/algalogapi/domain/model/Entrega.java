package com.helison.algalog.algalogapi.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.helison.algalog.algalogapi.domain.ValidationGroups;
import com.helison.algalog.algalogapi.domain.exception.NegocioException;

@Entity
public class Entrega {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @ManyToOne
  //valida o cliente também
  @Valid
  //altera o validation group para o custom, evitando que toda a classe seja validada, apenas os campos do validation especificado
  @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
  private Cliente cliente;

  @NotNull
  @Valid
  @Embedded
  private Destinatario destinatario;
  
  @NotNull
  private BigDecimal taxa;

  /**
   * CascadeType.ALL define que as alterações deverão ser feitas em cascata pela JPA.
   * Quando um objeto entrega for alterado dentro de uma transação (métodos com o @Transactional)
   * as ocorrências também serão salvas em cascata.
  */
  @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
  private List<Ocorrencia> ocorrencias = new ArrayList<>();

  @JsonProperty(access = Access.READ_ONLY)
  @Enumerated(EnumType.STRING)
  private StatusEntrega status;
  
  @JsonProperty(access = Access.READ_ONLY)
  private OffsetDateTime dataPedido;

  @JsonProperty(access = Access.READ_ONLY)
  private OffsetDateTime dataFinalizacao;


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Destinatario getDestinatario() {
    return this.destinatario;
  }

  public void setDestinatario(Destinatario destinatario) {
    this.destinatario = destinatario;
  }

  public BigDecimal getTaxa() {
    return this.taxa;
  }

  public void setTaxa(BigDecimal taxa) {
    this.taxa = taxa;
  }

  public StatusEntrega getStatusEntrega() {
    return this.status;
  }

  public void setStatus(StatusEntrega statusEntrega) {
    this.status = statusEntrega;
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


  public List<Ocorrencia> getOcorrencias() {
    return this.ocorrencias;
  }

  public void setOcorrencias(List<Ocorrencia> ocorrencias) {
    this.ocorrencias = ocorrencias;
  }

  public StatusEntrega getStatus() {
    return this.status;
  }

  public Ocorrencia adicionarOcorrencia(String descricao) {
    Ocorrencia ocorrencia = new Ocorrencia();
    ocorrencia.setDescricao(descricao);
    ocorrencia.setDataRegistro(OffsetDateTime.now());
    ocorrencia.setEntrega(this);
    
    this.getOcorrencias().add(ocorrencia);

    return ocorrencia;
  }

  public void finalizar(){
    if(naoPodeSerFinalizada()){
      throw new NegocioException("Entrega não pode ser finalizada.");
    }

    /**
     * É salvo automaticamente no DB quando usado em um método transacional (@Transctional)
    */
    setStatus(StatusEntrega.FINALIZADA);
    setDataFinalizacao(OffsetDateTime.now());
  
  }

  public boolean podeSerFinalizada(){
    return StatusEntrega.PENDENTE.equals(getStatus());
  }

  public boolean naoPodeSerFinalizada(){
    return !podeSerFinalizada();
  }

}
