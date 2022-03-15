package com.helison.algalog.algalogapi.domain.service;

import com.helison.algalog.algalogapi.domain.exception.NegocioException;
import com.helison.algalog.algalogapi.domain.model.Cliente;
import com.helison.algalog.algalogapi.domain.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Transactional
  public Cliente salvar(Cliente cliente) {

    boolean emailExiste = clienteRepository.findByEmail(cliente.getEmail())
                          .stream()
                          //se for o mesmo cliente, o programa segue normal
                          //se for diferente é pq existe dois clientes com o msm email
                          .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

    if(emailExiste){
      throw new NegocioException("Já existe um cliente com este email.");
    }

    return clienteRepository.save(cliente);
  }

  @Transactional
  public void excluir(Long idCliente) {
    clienteRepository.deleteById(idCliente);
  }

  public Cliente buscar(Long clienteId){
    return clienteRepository.findById(clienteId).
    orElseThrow(() -> new NegocioException("Cliente não encontrado."));
  }
}
