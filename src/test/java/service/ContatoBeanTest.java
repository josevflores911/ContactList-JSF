package service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import controller.ContatoBean;
import model.Contato;
import model.Endereco;

@ExtendWith(MockitoExtension.class)
class ContatoBeanTest {

    @InjectMocks
    private ContatoBean contatoBean;

    @Mock
    private ContatoService service;

    @BeforeEach
    void setUp() {
        List<Contato> contatos = new ArrayList<>();
        when(service.listAll()).thenReturn(contatos);
        contatoBean.init(); // chama o @PostConstruct
    }

    @Test
    void deveSalvarNovoContato() {
        Contato novo = new Contato();
        novo.setCpfCnpj(null); // simula contato novo
        novo.setEnderecos(List.of(new Endereco()));

        contatoBean.setNovoContato(novo);

        contatoBean.salvarOuAtualizarContato();

        verify(service).save(novo);
        assertFalse(contatoBean.getContatos().isEmpty());
    }

    @Test
    void deveAtualizarContatoExistente() {
        Contato existente = new Contato();
        existente.setCpfCnpj("12345678900");
        existente.setEnderecos(List.of(new Endereco()));

        contatoBean.setNovoContato(existente);

        contatoBean.salvarOuAtualizarContato();

        verify(service).update(existente);
    }

    @Test
    void deveRemoverContato() {
        Contato contato = new Contato();
        when(service.listAll()).thenReturn(new ArrayList<>());

        contatoBean.remove(contato);

        verify(service).remove(contato);
        verify(service).listAll();
        assertTrue(contatoBean.getContatos().isEmpty());
    }
}
