package com.helison.algalog.algalogapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.helison.algalog.algalogapi.domain.model.Cliente;
import com.helison.algalog.algalogapi.domain.repository.ClienteRepository;
import com.helison.algalog.algalogapi.domain.service.CatalogoClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private CatalogoClienteService catalogoClienteService;

  @GetMapping
  public List<Cliente> listar(){
    return clienteRepository.findAll();
  }

  @GetMapping("/{clienteId}")
  public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
    return clienteRepository.findById(clienteId)
    //para cada objeto encontrado chama o método ResponseEntity::ok (method reference, o cliente é passado para o método ok())
    //como o resultado é sempre apenas um objeto (id unico) na primeira e única iteração é retornado o recurso solicitado
    .map(ResponseEntity::ok)
    //caso o optional esteja vazio retorna um 404
    .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cliente adicionar(@Valid @RequestBody Cliente cliente){
    return catalogoClienteService.salvar(cliente);
  }

  @PutMapping("/{clienteId}")
  public ResponseEntity<Cliente> atualizar(@Valid @RequestBody Cliente cliente, @PathVariable Long clienteId){

    if(!clienteRepository.existsById(clienteId)){
      return ResponseEntity.notFound().build();
    }

    cliente.setId(clienteId);
    cliente = catalogoClienteService.salvar(cliente);

    return ResponseEntity.ok(cliente);
  }

  @DeleteMapping("/{clienteId}")
  public ResponseEntity<Void> excluir(@PathVariable Long clienteId){

    if(!clienteRepository.existsById(clienteId)){
      return ResponseEntity.notFound().build();
    }

    catalogoClienteService.excluir(clienteId);

    return ResponseEntity.noContent().build();
  }
}
