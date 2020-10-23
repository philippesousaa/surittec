package com.surittec.Cliente;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.surittec.Cliente.Email.ClienteEmail;

@SpringBootTest
public class ClienteServiceImplTest {

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    public void testFindAll() {
        List<Cliente> listCliente = new ArrayList<Cliente>();
        Cliente cliente = new Cliente();
        listCliente.add(cliente);

        ArrayList<ClienteEmail> listEmail = new ArrayList<ClienteEmail>();
        when(clienteService.findAll()).thenReturn(listCliente);
    }

//    public ResponseEntity<Cliente> getOneCliente(Long userId) {
//        Cliente cliente = clienteRepository.findById(userId).orElse(null);
//        if (cliente != null) {
//            return ResponseEntity.ok().body(cliente);
//        } else {
//            return (ResponseEntity<Cliente>) ResponseEntity.status(HttpStatus.NOT_FOUND);
//        }
//
//    }
//
//    public Cliente save(Cliente cliente) {
//        return clienteRepository.save(cliente);
//    }
//
//    public ResponseEntity<Cliente> updateCliente(Long clienteId, Cliente cliente) {
//        Cliente clientToSave = clienteRepository.findById(clienteId).orElse(null);
//        if (clientToSave != null) {
//
//            clientToSave.setNome(cliente.getNome());
//            clientToSave.setCPF(cliente.getCPF());
//            final Cliente clienteAtualizado = clienteRepository.save(clientToSave);
//            return ResponseEntity.ok(clienteAtualizado);
//        } else {
//            return (ResponseEntity<Cliente>) ResponseEntity.status(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    public void deleteCliente(Long clientId) {
//        Cliente cliente = clienteRepository.findById(clientId).orElse(null);
//        if (cliente != null) {
//            clienteRepository.delete(cliente);
//        }
//    }

}
