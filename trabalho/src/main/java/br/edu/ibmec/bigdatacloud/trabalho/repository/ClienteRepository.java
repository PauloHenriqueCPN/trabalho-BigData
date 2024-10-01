package br.edu.ibmec.bigdatacloud.trabalho.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ibmec.bigdatacloud.trabalho.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Busca um cliente pelo e-mail, retorna Optional para lidar com null
    Optional<Cliente> findByEmail(String email);

    // Busca um cliente pelo CPF, retorna Optional para lidar com null
    Optional<Cliente> findByCpf(String cpf);

}
