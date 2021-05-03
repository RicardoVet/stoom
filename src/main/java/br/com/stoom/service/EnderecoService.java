package br.com.stoom.service;

import java.util.List;

import br.com.stoom.model.Endereco;

public interface EnderecoService {
	
	Endereco salvar(final Endereco endereco);
	
	List<Endereco> buscarTodos();
	
	Endereco buscarPorId(final long id);
	
	void deletarPorId(final long id);

}
