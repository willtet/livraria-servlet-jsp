package com.wproject.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.wproject.livraria.model.Autor;


public class LivrariaDao {
	private Connection conexao;

	public LivrariaDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrar(Autor author) { 
		try {
			String sql = "INSERT INTO autores(nome, email, nascimento, curriculo) values(?, ?, ?, ?);";
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, author.getNome());
			ps.setString(2, author.getEmail());
			ps.setDate(3, Date.valueOf(author.getNascimento()));
			ps.setString(4, author.getCurriculo());
			
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Autor> listar(){
		try {
			String sql = "SELECT * FROM autores;";
			PreparedStatement ps = conexao.prepareStatement(sql);
			List<Autor> autores = new ArrayList<Autor>();
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Autor autor  = new Autor();
				autor.setNome(rs.getString("nome"));
				autor.setEmail(rs.getString("email"));
				autor.setNascimento(rs.getDate("nascimento").toLocalDate());
				autor.setCurriculo(rs.getString("curriculo"));
				
				autores.add(autor);
			}
			return autores;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	//Futura implementação
	public void deletar(long id) {
		
	}
	
	//Futura implementação
	public Autor listarId(long id) {
		return null;
	}
}
