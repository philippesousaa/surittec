package com.surittec.Cliente.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteEnderecoRepository extends JpaRepository<ClienteEndereco, Long> {
}
