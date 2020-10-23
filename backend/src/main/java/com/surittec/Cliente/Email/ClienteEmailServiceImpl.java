package com.surittec.Cliente.Email;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surittec.Cliente.Cliente;

@Service
@Transactional
public class ClienteEmailServiceImpl implements ClienteEmailService {

    @Autowired
    private ClienteEmailRepository clienteEmailRepository;

    public List<ClienteEmail> getAllEmail() {
        return clienteEmailRepository.findAll();
    }

    public ClienteEmail saveEmail(ClienteEmail clienteEmail) {
        return clienteEmailRepository.save(clienteEmail);
    }

    public ResponseEntity<ClienteEmail> updateEmail(Long clEmailId, ClienteEmail clEmail) {
        ClienteEmail clienteEmail = clienteEmailRepository.findById(clEmailId).orElse(null);
        if (clienteEmail != null) {
            clienteEmail.setCliente(new Cliente(clEmail.getCliente().getId()));
            clienteEmail.setEmail(clEmail.getEmail());
            final ClienteEmail emailAtualizado = clienteEmailRepository.save(clienteEmail);
            return ResponseEntity.ok(emailAtualizado);
        } else {
            return (ResponseEntity<ClienteEmail>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteEmail(Long idEmail) {
        ClienteEmail emailToDelete = clienteEmailRepository.findById(idEmail).orElse(null);
        if (emailToDelete != null) {
            clienteEmailRepository.delete(emailToDelete);
        }
    }

}
