package br.com.stoom.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.stoom.localizador.Localizador;
import br.com.stoom.model.Endereco;
import br.com.stoom.repository.EnderecoRepository;
import br.com.stoom.service.EnderecoService;



class EnderecoServiceImplTest {

	
	private EnderecoRepository enderecoRepository;
	private EnderecoService enderecoServiceTest;
	private Localizador localizador;

	@BeforeEach
	public void testando() {
		enderecoRepository = mock(EnderecoRepository.class);
		enderecoServiceTest = new EnderecoServiceImpl(enderecoRepository, localizador);
	}
	
	@Test
	void testandoContrutor() {
		assertNotNull(enderecoServiceTest);
	}
	
	@Test
	public void testandoSalvar() {
		Endereco endereco = new Endereco();
		endereco.setLatitude("123");
		endereco.setLongitude("456");
		when(enderecoRepository.save(endereco)).thenReturn(endereco);
		enderecoServiceTest.salvar(endereco);
		verify(enderecoRepository, times(1)).save(endereco);
	}
	
	@Test
	public void testandoBuscarTodos() {
		when(enderecoRepository.findAll()).thenReturn(new ArrayList<>());
		enderecoServiceTest.buscarTodos();
		verify(enderecoRepository, times(1)).findAll();
	}
	
	@Test
	public void testandoBuscarPorId() {
		Endereco endereco = new Endereco();
		when(enderecoRepository.getOne(1L)).thenReturn(endereco);
		enderecoServiceTest.buscarPorId(1L);
		verify(enderecoRepository, times(1)).findById(1L);
	}
	
	@Test
	public void testandoDeletarPorId() {
		enderecoServiceTest.deletarPorId(1L);
		verify(enderecoRepository, times(1)).deleteById(1L);
	}
}
