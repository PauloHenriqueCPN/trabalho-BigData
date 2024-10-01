package br.edu.ibmec.bigdatacloud.trabalho.service;

import br.edu.ibmec.bigdatacloud.trabalho.model.Cliente;
import br.edu.ibmec.bigdatacloud.trabalho.model.Endereco;
import br.edu.ibmec.bigdatacloud.trabalho.repository.ClienteRepository;
import br.edu.ibmec.bigdatacloud.trabalho.repository.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EnderecoServiceTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private EnderecoService enderecoService;

    private Endereco endereco;
    private Cliente cliente;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente();
        cliente.setId(1);

        endereco = new Endereco();
        endereco.setRua("Rua A");
        endereco.setNumero("12345");
    }

    @Test
    public void testCriarEndereco_Sucesso() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(enderecoRepository.save(endereco)).thenReturn(endereco);

        Endereco novoEndereco = enderecoService.criarEndereco(1L, endereco);
        assertNotNull(novoEndereco);
        assertEquals("Rua A", novoEndereco.getRua());
    }

    @Test
    public void testCriarEndereco_ClienteNaoEncontrado() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            enderecoService.criarEndereco(1L, endereco);
        });

        assertEquals("Cliente não encontrado", exception.getMessage());
    }
}
