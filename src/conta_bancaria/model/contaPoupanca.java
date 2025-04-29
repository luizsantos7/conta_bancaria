package conta_bancaria.model;

public class contaPoupanca extends Conta {
	
	private String niver;

	public contaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, String niver) {
		super(numero, agencia, tipo, titular, saldo);
		this.niver = niver;
	}

	public String getNiver() {
		return niver;
	}

	public void setNiver(String niver) {
		this.niver = niver;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Data de Aniversário: " + this.niver);
	}
	

}

