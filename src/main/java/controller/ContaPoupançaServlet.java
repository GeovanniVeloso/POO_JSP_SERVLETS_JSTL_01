package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContaPoupanca;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ContaPoupança")
public class ContaPoupançaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ArrayList<ContaPoupanca> Poupancas;
	
    public ContaPoupançaServlet() {
        Poupancas = new ArrayList<>();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("enviar");
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String dataNasc = request.getParameter("dataNasc");
		
		String saida = "OP Concluida";
		
		request.setAttribute("saida", saida);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
