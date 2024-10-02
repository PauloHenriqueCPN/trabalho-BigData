package br.edu.ibmec.bigdatacloud.trabalho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ibmec.bigdatacloud.trabalho.model.Cliente;
import br.edu.ibmec.bigdatacloud.trabalho.model.Endereco;
import br.edu.ibmec.bigdatacloud.trabalho.repository.ClienteRepository;
import br.edu.ibmec.bigdatacloud.trabalho.repository.EnderecoRepository;
import jakarta.validation.Valid;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Endereco criarEndereco(Long id, @Valid Endereco endereco) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        endereco.setCliente(cliente);
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> buscarEnderecoCliente(Long id) {
        return enderecoRepository.findClienteById(id);
    }

    public Endereco buscarEnderecoId(Long id) {
            return enderecoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));
        }

    public Endereco atualizarEndereco(Long id, Endereco atualizarEndereco) {
        Endereco endereco = enderecoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));
        

        endereco.setRua(atualizarEndereco.getRua());
        endereco.setNumero(atualizarEndereco.getNumero());
        endereco.setBairro(atualizarEndereco.getBairro());
        endereco.setCidade(atualizarEndereco.getCidade());
        endereco.setEstado(atualizarEndereco.getEstado());
        endereco.setCep(atualizarEndereco.getCep());

        return enderecoRepository.save(endereco);

    }

    public void removerEndereco(Long id) {
        Endereco endereco = enderecoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));
        
        enderecoRepository.delete(endereco);
    }
    
}
