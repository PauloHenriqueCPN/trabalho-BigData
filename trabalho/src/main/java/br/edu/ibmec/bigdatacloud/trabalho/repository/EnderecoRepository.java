package br.edu.ibmec.bigdatacloud.trabalho.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.bigdatacloud.trabalho.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    
    // Busca um endereço pelo ID
    Optional<Endereco> findById(Long id);

    // Salva um novo endereço
    @Override
    Endereco save(Endereco endereco);

    // Deleta um endereço
    @Override
    void delete(Endereco endereco);
    
    // Busca todos os endereços associados a um cliente pelo ID do cliente
    List<Endereco> findClienteById(Long id);
}