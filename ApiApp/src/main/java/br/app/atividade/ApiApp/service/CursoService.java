package br.app.atividade.ApiApp.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.app.atividade.ApiApp.model.Curso;
import br.app.atividade.ApiApp.repository.CursoRepository;

/**
 * Classe serviço com os métodos das regras de negócio da API
 * 
 * @author Paulo Alessander
 * @since 02/10/2021
 */

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@PostMapping
	public String save(@RequestBody Curso curso) {
		if (!(curso.getNumeroAlunosMatriculados() != null) || !(curso.getNumeroMaximoAlunos() != null)) {
			return "Algum valor de número de alunos está vazio! Corrija!";
		} else if (curso.getNumeroAlunosMatriculados() > curso.getNumeroMaximoAlunos()) {
			return "Limite de alunos excedido, Corrija!";
		} else if (!(curso.getDataEncerramentoCurso() != null) || !(curso.getDataInicioCurso() != null)) {
			return "Algum valor de data está vazio! Corrija!";
		} else if (curso.getDataEncerramentoCurso().before(curso.getDataInicioCurso())) {
			return "Data de Início ou Data de Encerramento do curso incorreta! Corrija!";
		} else {
			cursoRepository.save(curso);
			return "Curso salvo com sucesso!";
		}
	}
	
	@GetMapping
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}
	
	@PutMapping
	public String update(@RequestBody Curso curso) {
		if (curso.getId() == null) {
			return "ID inexistente";
		} else if (!(curso.getNumeroAlunosMatriculados() != null) || !(curso.getNumeroMaximoAlunos() != null)) {
			return "Algum valor de número de alunos está vazio! Corrija!";
		} else if (curso.getNumeroAlunosMatriculados() > curso.getNumeroMaximoAlunos()) {
			return "Limite de alunos excedido! Corrija!";
		} else if (!(curso.getDataEncerramentoCurso() != null) || !(curso.getDataInicioCurso() != null)) {
			return "Algum valor de data está vazio! Corrija!";
		} else if (curso.getDataEncerramentoCurso().before(curso.getDataInicioCurso())) {
			return "Data de Início ou Data de Encerramento do curso incorreta";
		} else {
			cursoRepository.save(curso);
			return "Dados atualizados com sucesso!";
		}
	}
	
	@GetMapping("/{id}")
	public Curso busca(@PathVariable Integer id) {
		Optional<Curso> optional = cursoRepository.findById(id);
		if(optional.isEmpty())
			return null;
		return optional.get();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		Optional<Curso> optional = cursoRepository.findById(id);
		if (optional.isEmpty())
			return "ID inexistente";
		String nome = busca(id).getNome();
		cursoRepository.deleteById(id);
		return "Curso " + nome + " excluído com sucesso";
	}

}
