package br.com.stoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.stoom.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
