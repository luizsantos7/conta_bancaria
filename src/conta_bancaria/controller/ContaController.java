package conta_bancaria.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// criar uma collection arrayList
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();	
	
	//variavel para controlar os numeros da conta
	int numero = 0;
	
	
	@Override
	public void procurarPorNumero(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		if (conta.isPresent())
			conta.get().visualizar();
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
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.printf("A conta %d foi atualizada com sucesso!!",conta.getNumero());
	}
		else 
			System.out.printf("\nA Conta número %d não foi encontrada.",numero);
	}

	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		if (conta.isPresent()) {
			if(listaContas.remove(conta.get()) == true);
				System.out.printf("\nA conta %d foi excluída com sucesso!!", numero);
		}
		else
			System.out.printf("\nA Conta número %d não foi encontrada.",numero);
		
		
	}

	@Override
	public void sacar(int numero, float valor) {	
		Optional<Conta> conta = buscarNaCollection(numero);
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		if (conta.isPresent()) {
			if (conta.get().sacar(valor)== true)
				System.out.printf("\nO saque no valor de %s"
						+ ", foi efetuado com sucesso na Conta número %d", nfMoeda.format(valor), numero);
		}else 
			System.out.printf("\nA Conta número %d não foi encontrada.",numero);
		
	}

	@Override
	public void depositar(int numero, float valor) {
		Optional<Conta> conta = buscarNaCollection(numero);
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		if (conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.printf("\nO Depósito no valor de %s foi efetuado com sucesso na conta %d !!", nfMoeda.format(valor),numero);		
		}else 
			System.out.printf("\nA Conta número %d não foi encontrada.",numero);
		
	}

	@Override
	public void transferencia(int numeroOrigem, int numeroDestino, float valor) {
		
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			if (contaOrigem.get().sacar(valor)== true) {
				contaDestino.get().depositar(valor);
				System.out.printf("\nA transferência no valor de %s, da Conta Numero %d para a Conta Numero %d foi efetuado!!", nfMoeda.format(valor),numeroOrigem,numeroDestino);		
				}
		}else 
			System.out.printf("\nA Conta número %d não foi encontrada.",numero);
		
	}
		
	
	// Métodos Auxiliares
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Optional<Conta> buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero()==numero) {
				return Optional.of(conta);
			}
		}
		return Optional.empty();
	}

}
