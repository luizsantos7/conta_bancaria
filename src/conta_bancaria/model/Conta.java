package conta_bancaria.model;

import java.text.NumberFormat;

import conta_bancaria.util.Cores;

public abstract class Conta {

	// atributos da classe
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	// metodo construtor (responsavel pra criar obeto
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	// metodos bancarios
	
	//metodo sacar
	public boolean sacar(float valor) {
		
		//verifica se o valor que foi desejado o saque é maior doque o saldo
		if (this.saldo < valor) {
			System.out.println("\nSaldo Insuficiente");
			return false;
		}
		
		//comando que é executado caso o saque seja efetuado com exito.
		this.setSaldo(this.saldo-valor);
		return true;
	}
	
	//metodo depositar
	public void depositar(float valor) {
		this.saldo+= valor;
	}
	
	// metodos para visualizar e editar os dados da conta
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	// metodo para visualizar a conta inteira
	public void visualizar() {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		String tipo = "";
		
		switch(this.tipo) {
			case 1 -> tipo = "Conta Corrente";
			case 2 -> tipo = "Conta Poupança";
			default -> tipo = "Inválido";
		}
		
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD +"=====================================================");
		System.out.println("DADOS DA CONTA                                       ");
		System.out.println("=====================================================");
		System.out.println("Número da Conta:" + this.numero);
		System.out.println("Número da Agência:"+this.agencia);
		System.out.println("Tipo da Conta: "+ tipo);
		System.out.println("Titular da Conta:"+this.titular);
		System.out.println("Saldo da Conta:"+ nfMoeda.format(this.saldo));
	}
	
}
