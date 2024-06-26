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
		ContaPoupanca cp = new ContaPoupanca();
		request.setAttribute("Conta não achada", 0);
		String saida ="";
		
		if(cmd.equals("Cadastrar")) {
			
			saida = cadastrarConta(cp, request, response);
			request.setAttribute("saida", saida);
			
		}else {
			if(cmd.equals("Consultar")) {
				String numConta = request.getParameter("numConta");
				
				int size = Poupancas.size();
				if(size > 0) {
					for(int i = 0; i < size; i++) {
						cp = Poupancas.get(i);
						if(cp.getNum_conta() == Integer.parseInt(numConta)) {
							ArrayList<ContaPoupanca> conta = new ArrayList<>();
							conta.add(cp);
							request.setAttribute("conta", conta);
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
					int size = Poupancas.size();
					
					saida = "Conta não Encotrada";
					
					for(int i = 0; i < size; i++) {
						cp = Poupancas.get(i);
						if(cp.getNum_conta() == Integer.parseInt(numConta)) {
							if(cp.getSaldo()>=saldoOP) {
								cp.sacar(saldoOP);
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
					int size = Poupancas.size();
					
					saida = "Conta não Encotrada";
					
					for(int i = 0; i < size; i++) {
						cp = Poupancas.get(i);
						if(cp.getNum_conta() == Integer.parseInt(numConta)) {
							cp.depositar(saldoOP);
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

	private String cadastrarConta(ContaPoupanca cp, HttpServletRequest request, HttpServletResponse response) {
		
		String numConta = request.getParameter("numConta");
		String nome = request.getParameter("nome");
		String saldo = request.getParameter("saldo");
		String dataRend = request.getParameter("dataRend");
		
		cp.setCliente(nome);
		cp.setNum_conta(Integer.parseInt(numConta));
		cp.setSaldo(Integer.parseInt(saldo));
		cp.setDiaDeRendimento(Integer.parseInt(dataRend));
		Poupancas.add(cp);
		return "Conta Cadastrada";
		
	}

}
