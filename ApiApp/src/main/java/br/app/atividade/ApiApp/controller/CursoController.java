package br.app.atividade.ApiApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.atividade.ApiApp.model.Curso;
import br.app.atividade.ApiApp.service.CursoService;

/**
 * SpringBoot RestController que criar todos os pontos-finais relativos aos cursos.
 * 
 * @author Paulo Alessander
 * @since 02/10/2021
 */

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public List<Curso> curso() {
		return cursoService.findAll();
	}
	
	@PostMapping
	public String save(@RequestBody Curso curso) {
		return cursoService.save(curso);
	}
	
	@PutMapping
	public String update(@RequestBody Curso curso) {
		return cursoService.update(curso);
	}
	
	@GetMapping("/{id}")
	public Curso busca(@PathVariable Integer id) {
		return cursoService.busca(id);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		return cursoService.delete(id);
	}
}
