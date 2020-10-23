package com.surittec.Cliente.Email;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ClienteEmailService {

    public List<ClienteEmail> getAllEmail();

    public ClienteEmail saveEmail(ClienteEmail clienteEmail);

    public ResponseEntity<ClienteEmail> updateEmail(Long clEmailId, ClienteEmail clEmail);

    public void deleteEmail(Long idEmail);

}
