package br.edu.ibmec.bigdatacloud.trabalho.service;

import br.edu.ibmec.bigdatacloud.trabalho.model.Cliente;
import br.edu.ibmec.bigdatacloud.trabalho.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente();
        cliente.setNome("Paulo");
        cliente.setCpf("123.456.789-00");
        cliente.setEmail("ph@gmail.com");
        cliente.setDtNascimento(LocalDateTime.of(2004, 4, 20, 0, 0, 0));
    }

    @Test
    public void testCriarCliente_Sucesso() {
        when(clienteRepository.findByEmail(cliente.getEmail())).thenReturn(Optional.empty());
        when(clienteRepository.findByCpf(cliente.getCpf())).thenReturn(Optional.empty());
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente novoCliente = clienteService.criarCliente(cliente);
        assertNotNull(novoCliente);
        assertEquals("Paulo", novoCliente.getNome());
    }

    @Test
    public void testCriarCliente_EmailJaCadastrado() {
        when(clienteRepository.findByEmail(cliente.getEmail())).thenReturn(Optional.of(cliente));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            clienteService.criarCliente(cliente);
        });

        assertEquals("E-mail já cadastrado", exception.getMessage());
    }

    @Test
    public void testBuscarClienteId_ClienteNaoEncontrado() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            clienteService.buscarClienteId(1L);
        });

        assertEquals("Cliente não encontrado", exception.getMessage());
    }
}
