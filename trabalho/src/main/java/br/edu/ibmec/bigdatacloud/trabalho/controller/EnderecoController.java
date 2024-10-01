package br.edu.ibmec.bigdatacloud.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ibmec.bigdatacloud.trabalho.exceptions.ClienteException;
import br.edu.ibmec.bigdatacloud.trabalho.model.Endereco;
import br.edu.ibmec.bigdatacloud.trabalho.service.EnderecoService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{clienteId}")
    public ResponseEntity<String> criarEndereco(@PathVariable Long clienteId, @Valid @RequestBody Endereco endereco) {
        try {
            Endereco novoEndereco = enderecoService.criarEndereco(clienteId, endereco);
            return ResponseEntity.status(HttpStatus.CREATED).body("Endereço criado com sucesso");
        } catch (ClienteException e) {
            // Retorna um Bad Request com a mensagem de erro
            return ResponseEntity.badRequest().body("Cliente não encontrado");
        }
    }


    @GetMapping("/{clienteId}")
    public ResponseEntity<List<Endereco>> buscarEnderecosPorCliente(@PathVariable Long clienteId) {
        List<Endereco> enderecos = enderecoService.buscarEnderecoCliente(clienteId);
        return ResponseEntity.ok(enderecos);
    }

    @PutMapping("/{enderecoId}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long enderecoId, @Valid @RequestBody Endereco endereco) {
        Endereco enderecoAtualizado = enderecoService.atualizarEndereco(enderecoId, endereco);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{enderecoId}")
    public ResponseEntity<Void> removerEndereco(@PathVariable Long enderecoId) {
        enderecoService.removerEndereco(enderecoId);
        return ResponseEntity.noContent().build();
    }
}
