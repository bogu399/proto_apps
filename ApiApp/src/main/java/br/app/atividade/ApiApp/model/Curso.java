package br.app.atividade.ApiApp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class que implementa a estrutura do Curso
 * 
 * @author Paulo Alessander
 * @since 02/10/2021
 */

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	private Integer numeroMaximoAlunos;
	private Integer numeroAlunosMatriculados;
	private Date dataInicioCurso;
	private Date dataEncerramentoCurso;
	private String resumo;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getNumeroMaximoAlunos() {
		return numeroMaximoAlunos;
	}
	public void setNumeroMaximoAlunos(Integer numeroMaximoAlunos) {
		this.numeroMaximoAlunos = numeroMaximoAlunos;
	}
	public Integer getNumeroAlunosMatriculados() {
		return numeroAlunosMatriculados;
	}
	public void setNumeroAlunosMatriculados(Integer numeroAlunosMatriculados) {
		this.numeroAlunosMatriculados = numeroAlunosMatriculados;
	}
	public Date getDataInicioCurso() {
		return dataInicioCurso;
	}
	public void setDataInicioCurso(Date dataInicioCurso) {
		this.dataInicioCurso = dataInicioCurso;
	}
	public Date getDataEncerramentoCurso() {
		return dataEncerramentoCurso;
	}
	public void setDataEncerramentoCurso(Date dataEncerramentoCurso) {
		this.dataEncerramentoCurso = dataEncerramentoCurso;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
