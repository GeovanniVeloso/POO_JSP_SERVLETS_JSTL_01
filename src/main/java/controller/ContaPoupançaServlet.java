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
		String numConta = request.getParameter("numConta");
		String nome = request.getParameter("nome");
		String saldo = request.getParameter("saldo");
		String dataRend = request.getParameter("dataRend");
		String saida ="";
		ContaPoupanca cp = new ContaPoupanca();
		request.setAttribute("Conta não achada", 0);
		
		if(cmd.equals("Cadastrar")) {
			cp.setCliente(nome);
			cp.setNum_conta(Integer.parseInt(numConta));
			cp.setSaldo(Integer.parseInt(saldo));
			cp.setDiaDeRendimento(Integer.parseInt(dataRend));
			Poupancas.add(cp);
			saida = "Conta Cadastrada";
			request.setAttribute("saida", saida);
		}else {
			int size = Poupancas.size();
			if(size > 0) {
				for(int i = 0; i < size; i++) {
					cp = Poupancas.get(i);
					if(cp.getNum_conta() == Integer.parseInt(numConta)) {
						request.setAttribute("conta", cp);
						i = size;
					}
				}
			}else {
				saida = "Não há contas cadastradas";
				request.setAttribute("saida", saida);
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("contaPoupancaCadastro.jsp");
		rd.forward(request, response);
	}

}
