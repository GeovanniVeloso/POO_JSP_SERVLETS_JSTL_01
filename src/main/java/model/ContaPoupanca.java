package model;

public class ContaPoupanca extends ContaBancaria {

	private int diaDeRendimento;

	public ContaPoupanca() {
		super();
	}

	public int getDiaDeRendimento() {
		return diaDeRendimento;
	}

	public void setDiaDeRendimento(int diaDeRendimento) {
		this.diaDeRendimento = diaDeRendimento;
	}

	public void calcularNovoSaldo(float taxa) {
		setSaldo(getSaldo() + ((getSaldo() * taxa) / 100));
	}

	@Override
	public void sacar(float retirada) {
		if (retirada > getSaldo()) {
			String e = "Valor ultrapassa saldo";
			throw new ArithmeticException(e);
		} else {
			setSaldo(getSaldo() - retirada);
		}
	}

}
