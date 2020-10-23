package com.surittec.Cliente.Email;

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
public interface ClienteEmailRest {

    @GetMapping("/clienteEmails")
    public List<ClienteEmail> getAllEmails();

    @PostMapping("/clienteEmails")
    public ClienteEmail createEmail(@RequestBody ClienteEmail clienteEmail);

    @PutMapping("/clienteEmails/{id}")
    public ResponseEntity<ClienteEmail> updateEmail(@PathVariable(value = "id") Long clEmailId, @Valid @RequestBody ClienteEmail clEmail);

    @DeleteMapping("/clienteEmails/{id}")
    public void deleteEmail(@PathVariable(value = "id") Long clEmailId);
}
