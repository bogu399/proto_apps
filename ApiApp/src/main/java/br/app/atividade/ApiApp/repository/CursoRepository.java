package br.app.atividade.ApiApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.atividade.ApiApp.model.Curso;

/**
 * Interface que implementa o Repositório com os métodos do JPA CRUD
 *
 * @author Paulo Alessander
 * @since 02/10/2021
 */

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
