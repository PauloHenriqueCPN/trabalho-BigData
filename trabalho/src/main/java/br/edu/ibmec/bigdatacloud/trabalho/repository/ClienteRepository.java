package br.edu.ibmec.bigdatacloud.trabalho.repository;

import java.util.Optional;

import br.edu.ibmec.bigdatacloud.trabalho.model.Cliente;
import jakarta.validation.Valid;

public class ClienteRepository {

    public Cliente save(@Valid Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public boolean findClienteByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findClienteByEmail'");
    }

    public boolean findClienteByCpf(String cpf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findClienteByCpf'");
    }
    
}
