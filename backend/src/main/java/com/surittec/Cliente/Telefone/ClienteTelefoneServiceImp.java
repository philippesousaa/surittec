package com.surittec.Cliente.Telefone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surittec.Cliente.Cliente;

@Service
@Transactional
public class ClienteTelefoneServiceImp implements ClienteTelefoneService {

    @Autowired
    private ClienteTelefoneRepository clienteTelefoneRepository;

    @Override
    public List<ClienteTelefone> getAllTelefones() {
        return clienteTelefoneRepository.findAll();
    }

    @Override
    public ClienteTelefone saveTelefone(ClienteTelefone clienteTelefone) {
        return clienteTelefoneRepository.save(clienteTelefone);
    }

    @Override
    public ResponseEntity<ClienteTelefone> updateTelefone(Long clTelefoneId, ClienteTelefone clTelefone) {
        ClienteTelefone clienteTelefone = clienteTelefoneRepository.findById(clTelefoneId).orElse(null);
        if (clienteTelefone != null) {
            clienteTelefone.setCliente(new Cliente(clTelefone.getCliente().getId()));
            clienteTelefone.setNumero(clTelefone.getNumero());
            clienteTelefone.setTipo(clTelefone.getTipo());
            final ClienteTelefone telefoneAtualizado = clienteTelefoneRepository.save(clienteTelefone);
            return ResponseEntity.ok(telefoneAtualizado);
        }
        return (ResponseEntity<ClienteTelefone>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }

    @Override
    public void deleteTelefone(Long clTelefoneId) {
        ClienteTelefone telefoneToDelete = clienteTelefoneRepository.findById(clTelefoneId).orElse(null);
        if (telefoneToDelete != null) {
            clienteTelefoneRepository.delete(telefoneToDelete);
        }
    }
}
