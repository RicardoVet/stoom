package br.com.stoom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.stoom.localizador.Localizador;
import br.com.stoom.model.Endereco;
import br.com.stoom.repository.EnderecoRepository;
import br.com.stoom.service.EnderecoService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

	private EnderecoRepository enderecoRepository;
	
	private Localizador localizador;
	
	@Override
	public Endereco salvar(final Endereco endereco) {
		if(endereco != null && endereco.getLatitude() == null && endereco.getLongitude() == null) {
			this.localizador.buscarInformacoes(endereco);
		}
		return this.enderecoRepository.save(endereco);
	}

	@Override
	public List<Endereco> buscarTodos() {
		return this.enderecoRepository.findAll();
	}

	@Override
	public Endereco buscarPorId(long id) {
		return this.enderecoRepository.findById(id).orElse(null);
	}

	@Override
	public void deletarPorId(long id) {
		this.enderecoRepository.deleteById(id);
	}
}
