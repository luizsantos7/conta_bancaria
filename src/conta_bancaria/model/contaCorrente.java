package conta_bancaria.model;

import java.text.NumberFormat;

public class contaCorrente extends Conta {
	
	private float limite;

	public contaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public void visualizar() {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		super.visualizar();
		System.out.println("Limite da Conta: "+ nfMoeda.format(this.limite));
	}
	
	//override serve pra mostrar que esta sobreescrevendo algo
	@Override
	public boolean sacar(float valor) {
			
		//verifica se o valor que foi desejado o saque é maior doque o saldo
		if ((this.getSaldo() + this.limite) < valor) {
			System.out.println("\nSaldo Insuficiente");
			return false;
		}
			
		//comando que é executado caso o saque seja efetuado com exito.
		this.setSaldo(this.getSaldo()-valor);
		return true;
	}

}
