package com.surittec.Cliente.Telefone;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClienteTelefoneService {

    public List<ClienteTelefone> getAllTelefones();

    public ClienteTelefone saveTelefone(ClienteTelefone clienteTelefone);

    public ResponseEntity<ClienteTelefone> updateTelefone(Long clTelefoneId, ClienteTelefone clTelefone);

    public void deleteTelefone(Long clTelefoneId);

}
