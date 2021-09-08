package com.wproject.livraria.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Autor {
	private String nome;
	private String email;
	private LocalDate nascimento;
	private String curriculo;
	
	public Autor() {
	}
	
	public Autor(String nome, String email, LocalDate nascimento, String curriculo) {
		super();
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.curriculo = curriculo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNascimentoFormatado() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return nascimento.format(formatter);
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}
	
	
	
}
