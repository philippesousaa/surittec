package com.surittec.Cliente;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest
class ClienteRestImplTest {

    @Autowired
    private ClienteRest clienteRest;
    @MockBean
    private ClienteService clienteService;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(this.clienteRest, clienteService);

    }

    @Test
    void testGetAllClientes() {
        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
        Cliente cliente = Cliente.builder().id(1L).CPF("12345678966").build();
        listCliente.add(cliente);
        Mockito.when(this.clienteService.findAll()).thenReturn(listCliente);
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/clientes");
        given().contentType(ContentType.JSON).when().get("/clientes").then().statusCode(HttpStatus.OK.value());
    }

    @Test
    void testGetOneCliente() {
        ResponseEntity<Cliente> cliente = new ResponseEntity<Cliente>(HttpStatus.OK);
        Mockito.when(this.clienteService.getOneCliente(1L)).thenReturn(cliente);
        given().contentType(ContentType.JSON).when().get("/clientes/1").then().statusCode(HttpStatus.OK.value());
    }

    @Test
    void testDelCliente() {
        // suporte
        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
        Cliente cliente = Cliente.builder().id(1L).CPF("12345678966").build();
        Cliente cliente2 = Cliente.builder().id(2L).CPF("1234378966").build();
        listCliente.add(cliente);
        listCliente.add(cliente2);

        // cases
        Mockito.doNothing().when(this.clienteService).deleteCliente(cliente.getId());
        given().contentType(ContentType.JSON).when().delete("/clientes/1").then().statusCode(HttpStatus.OK.value());
    }
}