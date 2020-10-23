package com.surittec.Cliente.Endereco;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ClienteEnderecoRest {

    @GetMapping("/clienteEndereco")
    public List<ClienteEndereco> getAllEnderecos();

    @PostMapping("/clienteEndereco")
    public ClienteEndereco createEndereco(@RequestBody ClienteEndereco clienteEndereco);

    @PutMapping("/clienteEndereco/{id}")
    public ResponseEntity<ClienteEndereco> updateEndereco(@PathVariable(value = "id") Long clEnderecoId,
            @Valid @RequestBody ClienteEndereco clEndereco);

}
