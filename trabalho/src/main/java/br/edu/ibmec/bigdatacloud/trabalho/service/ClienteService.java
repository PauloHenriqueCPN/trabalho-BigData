package br.edu.ibmec.bigdatacloud.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ibmec.bigdatacloud.trabalho.exceptions.ClienteException;
import br.edu.ibmec.bigdatacloud.trabalho.model.Cliente;
import br.edu.ibmec.bigdatacloud.trabalho.repository.ClienteRepository;
import br.edu.ibmec.bigdatacloud.trabalho.validation.ClienteValidation;
import jakarta.persistence.Id;
import jakarta.validation.Valid;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(@Valid Cliente cliente) {

        if (!ClienteValidation.isMaiorDeIdade(cliente)) {
            throw new IllegalArgumentException("O Cliente deve ter no mínimo 18 anos");
        }

        if (clienteRepository.findClienteByEmail(cliente.getEmail())) {
            throw new ClienteException("E-mail já cadastrado");
        }

        if (clienteRepository.findClienteByCpf(cliente.getCpf())) {
            throw new ClienteException("CPF já cadastrado");
        }

        return clienteRepository.save(cliente);
    }
    
    public Cliente buscarClienteId(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> TodosClientes() {
        return clienteRepository.findAll();
    }


    public Cliente atualizarCliente(Long id, Cliente clienteRenova) {
        Cliente cliente = clienteRepository.findById(id);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        cliente.setNome(clienteRenova.getNome());
        cliente.setEmail(clienteRenova.getEmail());
        cliente.setCpf(clienteRenova.getCpf());
        cliente.setDtNascimento(clienteRenova.getDtNascimento());
        cliente.setTelefone(clienteRenova.getTelefone());

        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        clienteRepository.delete(cliente);
    }

}
