package com.surittec.Cliente.Telefone;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteTelefoneRestImpl implements ClienteTelefoneRest {

    @Autowired
    private ClienteTelefoneService clienteTelefoneService;

    @GetMapping("/clienteTelefones")
    public List<ClienteTelefone> getAllTelefones() {
        return clienteTelefoneService.getAllTelefones();
    }

    @PostMapping("/clienteTelefones")
    public ClienteTelefone createTelefone(@RequestBody ClienteTelefone clienteTelefone) {
        return clienteTelefoneService.saveTelefone(clienteTelefone);
    }

    @PutMapping("/clienteTelefones/{id}")
    public ResponseEntity<ClienteTelefone> updateTelefone(@PathVariable(value = "id") Long clTelefoneId,
            @Valid @RequestBody ClienteTelefone clTelefone) {
        return clienteTelefoneService.updateTelefone(clTelefoneId, clTelefone);
    }

    @DeleteMapping("/clienteTelefones/{id}")
    public void deleteTelefone(@PathVariable(value = "id") Long clTelefoneId) {
        clienteTelefoneService.deleteTelefone(clTelefoneId);
    }

}
