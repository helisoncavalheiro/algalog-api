package com.helison.algalog.algalogapi.model.input;

import javax.validation.constraints.NotNull;

public class ClienteIdInput {
  
  @NotNull
  private Long id;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
