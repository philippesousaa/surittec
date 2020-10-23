package com.surittec.Cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ClienteRest {

    @GetMapping("/clientes")
    public List<Cliente> getAllClientes();

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getOneCliente(@PathVariable(value = "id") Long userId);

    @PostMapping("/clientes")
    public Cliente createCliente(@Valid @RequestBody Cliente cliente);

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long clienteId, @Valid @RequestBody Cliente cliente);

    @DeleteMapping("/clientes/{id}")
    public void deleteCliente(@PathVariable(value = "id") Long clientId);

}
