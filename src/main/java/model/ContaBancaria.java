package model;

public abstract class ContaBancaria {
	
	private String cliente;
	private int num_conta;
	private float saldo;

	public ContaBancaria() {
		super();
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getNum_conta() {
		return num_conta;
	}

	public void setNum_conta(int num_conta) {
		this.num_conta = num_conta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public abstract void sacar(float retirada);
	
	public void depositar(float deposito) {
		saldo = saldo + deposito;
	}

}
