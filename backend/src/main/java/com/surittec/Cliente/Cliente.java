package com.surittec.Cliente;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.surittec.Cliente.Email.ClienteEmail;
import com.surittec.Cliente.Endereco.ClienteEndereco;
import com.surittec.Cliente.Telefone.ClienteTelefone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
@EntityListeners(AuditingEntityListener.class)
public class Cliente {

    public Cliente(Long clienteId) {
        this.setId(clienteId);
    }

    public Cliente(String clienteId) {
        this.setId(Long.parseLong(clienteId));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome", nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Somente são permitidos letras, espaços e números")
    private String nome;

    @Column(name = "cpf", nullable = false)
    private String CPF;

    @OneToOne(mappedBy = "cliente", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private ClienteEndereco endereco;

    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<ClienteTelefone> telefones;

    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<ClienteEmail> emails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF.replaceAll("[^a-zA-Z0-9]+", "");
    }

    @JsonIgnore
    public com.surittec.Cliente.Endereco.ClienteEndereco getEndereco() {
        return endereco;
    }

    public void setEndereco(com.surittec.Cliente.Endereco.ClienteEndereco endereco) {
        this.endereco = endereco;
    }

    public List<ClienteTelefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<ClienteTelefone> telefones) {
        this.telefones = telefones;
    }

    public List<ClienteEmail> getEmails() {
        return emails;
    }

    public void setEmails(List<ClienteEmail> emails) {
        this.emails = emails;
    }
}
