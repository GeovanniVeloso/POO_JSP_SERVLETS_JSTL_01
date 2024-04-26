package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContaEspecial;
import model.ContaPoupanca;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ContaEspecial")
public class ContaEspecialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<ContaEspecial> Especiais;
	
    public ContaEspecialServlet() {
    	Especiais = new ArrayList<>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("enviar");
		ContaEspecial ce = new ContaEspecial();
		request.setAttribute("Conta não achada", 0);
		String saida ="";
		
		if(cmd.equals("Cadastrar")) {
			
			saida = cadastrarConta(ce, request, response);
			request.setAttribute("saida", saida);
			
		}else {
			if(cmd.equals("Consultar")) {
				String numConta = request.getParameter("numConta");
				
				int size = Especiais.size();
				if(size > 0) {
					for(int i = 0; i < size; i++) {
						ce = Especiais.get(i);
						if(ce.getNum_conta() == Integer.parseInt(numConta)) {
							ArrayList<ContaEspecial> ContaE = new ArrayList<>();
							ContaE.add(ce);
							request.setAttribute("conta", ContaE);
							i = size;
						}
					}
				}else {
					saida = "Não há contas cadastradas";
					request.setAttribute("saida", saida);
				}
			}else {
				if(cmd.equals("Sacar")) {
					String numConta = request.getParameter("numConta");
					int saldoOP = Integer.parseInt(request.getParameter("saldoOP"));
					int size = Especiais.size();
					
					saida = "Conta não Encotrada";
					
					for(int i = 0; i < size; i++) {
						ce = Especiais.get(i);
						if(ce.getNum_conta() == Integer.parseInt(numConta)) {
							if(ce.getSaldo()>=saldoOP) {
								ce.sacar(saldoOP);
								i = size;
								saida = "Saque efetuado!";
							}else {
								String e = "Valor ultrapassa saldo corrente";
								throw new ArithmeticException(e);
							}
						}
					}
				}else {
					String numConta = request.getParameter("numConta");
					int saldoOP = Integer.parseInt(request.getParameter("saldoOP"));
					int size = Especiais.size();
					
					saida = "Conta não Encotrada";
					
					for(int i = 0; i < size; i++) {
						ce = Especiais.get(i);
						if(ce.getNum_conta() == Integer.parseInt(numConta)) {
							ce.depositar(saldoOP);
							i = size;
							saida = "Depósito efetuado!";
							request.setAttribute("saida", saida);
						}
					}
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("contaPoupancaCadastro.jsp");
		rd.forward(request, response);
	}

	private String cadastrarConta(ContaEspecial ce, HttpServletRequest request, HttpServletResponse response) {
		
		String numConta = request.getParameter("numConta");
		String nome = request.getParameter("nome");
		String saldo = request.getParameter("saldo");
		String limite = request.getParameter("limite");
		
		ce.setCliente(nome);
		ce.setNum_conta(Integer.parseInt(numConta));
		ce.setSaldo(Integer.parseInt(saldo));
		ce.setLimite(Integer.parseInt(limite));
		Especiais.add(ce);
		return "Conta Cadastrada";
		
	}

}
