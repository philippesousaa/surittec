package com.surittec.Cliente.Endereco;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ClienteEnderecoService {

    public List<ClienteEndereco> getAllEnderecos();

    public ClienteEndereco saveEndereco(ClienteEndereco clienteEndereco);

    public ResponseEntity<ClienteEndereco> updateEndereco(Long clEnderecoId, ClienteEndereco clEndereco);

}
