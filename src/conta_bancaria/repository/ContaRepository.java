package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {
	
	//métodos do CRUD ( Create, Read, Update, Delete)
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int num);
	public void listarPorTitular(String titular);
	
	//metodo bancario
	public void sacar(int numero, float valor);
	public void depositar (int numero, float valor);
	public void transferencia(int numerodeOrigem, int numerodeDestino, float valor);
	
	

}
