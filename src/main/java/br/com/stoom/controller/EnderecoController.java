package br.com.stoom.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.stoom.model.Endereco;
import br.com.stoom.service.impl.EnderecoServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EnderecoController {
	
	private EnderecoServiceImpl enderecoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<Endereco> salvar(@RequestBody @Valid Endereco endereco) {
		Endereco enderecoAtualizado = this.enderecoService.salvar(endereco);
		return ResponseEntity.ok(enderecoAtualizado);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Endereco> atualizar(@RequestBody @Valid Endereco endereco) {
		Endereco enderecoAtualizado = this.enderecoService.salvar(endereco);
		return ResponseEntity.ok(enderecoAtualizado);
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<Endereco>> buscarTodos() {
		return ResponseEntity.ok(this.enderecoService.buscarTodos());
	}
	
	@GetMapping("/endereco/{id}")
	public  ResponseEntity<Endereco> buscarPorId(@PathVariable("id") final long id) {
		return ResponseEntity.ok(this.enderecoService.buscarPorId(id));
		
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletarPorId(@PathVariable("id") final long id) {
		 this.enderecoService.deletarPorId(id);
	}
}
