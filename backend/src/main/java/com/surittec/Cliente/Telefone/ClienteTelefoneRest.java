package com.surittec.Cliente.Telefone;

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
public interface ClienteTelefoneRest {

    @GetMapping("/clienteTelefones")
    public List<ClienteTelefone> getAllTelefones();

    @PostMapping("/clienteTelefones")
    public ClienteTelefone createTelefone(@RequestBody ClienteTelefone clienteTelefone);

    @PutMapping("/clienteTelefones/{id}")
    public ResponseEntity<ClienteTelefone> updateTelefone(@PathVariable(value = "id") Long clTelefoneId,
            @Valid @RequestBody ClienteTelefone clTelefone);

    @DeleteMapping("/clienteTelefones/{id}")
    public void deleteTelefone(@PathVariable(value = "id") Long clTelefoneId);

}
