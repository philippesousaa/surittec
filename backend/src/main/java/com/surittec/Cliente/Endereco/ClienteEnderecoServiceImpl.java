package com.surittec.Cliente.Endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surittec.Cliente.Cliente;

@Service
@Transactional
public class ClienteEnderecoServiceImpl implements ClienteEnderecoService {

    @Autowired
    private ClienteEnderecoRepository clienteEnderecoRepository;

    @Override
    public List<ClienteEndereco> getAllEnderecos() {
        return clienteEnderecoRepository.findAll();
    }

    @Override
    public ClienteEndereco saveEndereco(ClienteEndereco clienteEndereco) {
        return clienteEnderecoRepository.save(clienteEndereco);
    }

    @Override
    public ResponseEntity<ClienteEndereco> updateEndereco(Long clEnderecoId, ClienteEndereco clEndereco) {
        ClienteEndereco clienteEndereco = clienteEnderecoRepository.findById(clEnderecoId).orElse(null);

        if (clienteEndereco != null) {
            clienteEndereco.setCliente(new Cliente(clEndereco.getCliente().getId()));
            clienteEndereco.setCep(clEndereco.getCep());
            clienteEndereco.setLogradouro(clEndereco.getLogradouro());
            clienteEndereco.setBairro(clEndereco.getBairro());
            clienteEndereco.setCidade(clEndereco.getCidade());
            clienteEndereco.setUf(clEndereco.getUf());
            clienteEndereco.setComplemento(clEndereco.getComplemento());
            final ClienteEndereco enderecoAtualizado = clienteEnderecoRepository.save(clienteEndereco);
            return ResponseEntity.ok(enderecoAtualizado);
        }
        return (ResponseEntity<ClienteEndereco>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }

}
