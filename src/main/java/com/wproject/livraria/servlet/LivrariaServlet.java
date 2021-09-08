package com.wproject.livraria.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wproject.livraria.dao.LivrariaDao;
import com.wproject.livraria.factory.ConnectionFactory;
import com.wproject.livraria.model.Autor;

@WebServlet("/registro")
public class LivrariaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LivrariaDao dao;

	public LivrariaServlet() {
		this.dao = new LivrariaDao(new ConnectionFactory().getConnection());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("autores", dao.listar());
		
		req.getRequestDispatcher("WEB-INF/jsp/registro.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(
			req.getParameter("nome").isEmpty() || 
			req.getParameter("email").isEmpty() ||
			req.getParameter("nascimento").isEmpty()
			) {
			resp.sendRedirect("registro?erro=Campos em branco");
		}else {
			try {
				String nome = req.getParameter("nome");
				String email = req.getParameter("email");
				LocalDate nascimento = LocalDate.parse(req.getParameter("nascimento"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				String curriculo  = req.getParameter("curriculo");
				
				Autor autor = new Autor(nome, email, nascimento, curriculo);
				dao.cadastrar(autor);
				resp.sendRedirect("registro");
			} catch (Exception e) {
				e.printStackTrace();
				resp.sendRedirect("registro?erro=verificar os campos com erros correspondentes!");
				
			}
		}
	}
	
	
	
}
