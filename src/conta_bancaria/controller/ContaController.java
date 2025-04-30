package conta_bancaria.controller;

import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// criar uma collection arrayList
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();	
	
	//variavel para controlar os numeros da conta
	int numero = 0;
	
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		if (conta != null)
			conta.visualizar();
		else 
			System.out.printf("\nA Conta número %d não foi encontrada.",numero);
		
	}

	@Override
	public void listarTodas() {
		
		for(var contas : listaContas) {
			contas.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta foi criada com sucesso!");
		
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferencia(int numerodeOrigem, int numerodeDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	// Métodos Auxiliares
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero()==numero) {
				return conta;
			}
		}
		return null;
	}

}
