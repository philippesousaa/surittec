package com.surittec.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public ResponseEntity<Cliente> getOneCliente(Long userId) {
        Cliente cliente = clienteRepository.findById(userId).orElse(null);
        if (cliente != null) {
            return ResponseEntity.ok().body(cliente);
        } else {
            return (ResponseEntity<Cliente>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public ResponseEntity<Cliente> updateCliente(Long clienteId, Cliente cliente) {
        Cliente clientToSave = clienteRepository.findById(clienteId).orElse(null);
        if (clientToSave != null) {

            clientToSave.setNome(cliente.getNome());
            clientToSave.setCPF(cliente.getCPF());
            final Cliente clienteAtualizado = clienteRepository.save(clientToSave);
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return (ResponseEntity<Cliente>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteCliente(Long clientId) {
        Cliente cliente = clienteRepository.findById(clientId).orElse(null);
        if (cliente != null) {
            clienteRepository.delete(cliente);
        }
    }

}
