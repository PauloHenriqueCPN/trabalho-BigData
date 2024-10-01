package br.edu.ibmec.bigdatacloud.trabalho.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ibmec.bigdatacloud.trabalho.exceptions.ClienteException;
import br.edu.ibmec.bigdatacloud.trabalho.model.Cliente;
import br.edu.ibmec.bigdatacloud.trabalho.repository.ClienteRepository;
import br.edu.ibmec.bigdatacloud.trabalho.validation.ClienteValidation;
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
    
}
