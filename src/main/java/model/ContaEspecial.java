package model;

public class ContaEspecial extends ContaBancaria {

	private float limite;

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	public ContaEspecial() {
		super();
	}

	@Override
	public void sacar(float retirada) {
		if (retirada > getSaldo() + limite) {
			String e = "Valor ultrapassa saldo";
			throw new ArithmeticException(e);
		} else {
			if (retirada > getSaldo()) {
				retirada = retirada - getSaldo();
				setSaldo(0);
				limite = limite - retirada;
			} else {
				setSaldo(getSaldo() - retirada);
			}
		}
	}

}
