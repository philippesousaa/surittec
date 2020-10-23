package com.surittec.Cliente;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ClienteService {

    public List<Cliente> findAll();

    public ResponseEntity<Cliente> getOneCliente(Long userId);

    public Cliente save(Cliente cliente);

    public ResponseEntity<Cliente> updateCliente(Long clienteId, Cliente cliente);

    public void deleteCliente(Long clientId);

}
