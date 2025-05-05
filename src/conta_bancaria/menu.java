package conta_bancaria;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.contaCorrente;
import conta_bancaria.model.contaPoupanca;
import conta_bancaria.util.Cores;

public class menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		
		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo;
		String titular, aniversario;
		float saldo, limite;
		
		contaCorrente cc1 = new contaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		
		contaPoupanca cp1 = new contaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, "07/12/2004");
		contas.cadastrar(cp1);
		

		while (true) {
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD
					+ "=====================================================");
			System.out.println("            ____________________________             ");
			System.out.println("            ||   BANCO DO BRASILIAN   ||             ");
			System.out.println("                                                     ");
			System.out.println("=====================================================");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("=====================================================");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_WHITE);

			opcao = leia.nextInt();

			if (opcao == 0) {
				sobre();
				System.exit(0);
			}
			System.out.printf(Cores.TEXT_CYAN_BOLD + "");
			switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n");
				
				System.out.println("Digite o numero da Agência");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do Titular da conta:");
				leia.skip("\\R");
				titular = leia.nextLine();
				System.out.println("Digite o tipo da Conta: (1 - Corrente || 2 - Poupança");
				tipo = leia.nextInt();
				System.out.println("Digite o Saldo inicial da conta");
				saldo = leia.nextFloat();
				
				switch(tipo) {
					case 1 ->{
						System.out.println("Digite o Limite:");
						limite = leia.nextFloat();
						contas.cadastrar(new contaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 ->{
						System.out.println("Digite o seu Aniversário:");
						leia.skip("\\R");
						aniversario = leia.nextLine();
						contas.cadastrar(new contaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				
				keyPress();
				break;
			case 2:
				System.out.println("Todas contas registradas\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println("Buscar conta\n");
				System.out.println("Digite o NUMERO/ID da conta que deseja consultar!\n");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println("Atualização de dados\n");
				
				System.out.println("Digite o NUMERO/ID da conta que deseja Atualizar!\n");
				numero = leia.nextInt();
				
				Optional<Conta> conta = contas.buscarNaCollection(numero);
				
				//confere se o numero esta cheio e se a conta existe
				if(conta.isPresent()) {
					
					System.out.println("Digite o numero da Agência");
					agencia = leia.nextInt();
					
					System.out.println("Digite o nome do Titular da conta:");
					leia.skip("\\R");
					titular = leia.nextLine();
					
					tipo = conta.get().getTipo();
					
					System.out.println("Digite o Saldo inicial da conta");
					saldo = leia.nextFloat();
					
					//identifica o tipo
					switch(tipo) {
					case 1 ->{// se conta for corrente
						System.out.println("Digite o Limite:");
						limite = leia.nextFloat();
						contas.atualizar(new contaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 ->{// se conta for poupança
						System.out.println("Digite o seu Aniversário:");
						leia.skip("\\R");
						aniversario = leia.nextLine();
						contas.atualizar(new contaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
				}
					
				}else
					System.out.printf("\n A conta numero %d não existe!", numero);
				
				keyPress();
				break;
			case 5:
				System.out.println("Deletar conta\n");
				System.out.println("Digite o NUMERO/ID da conta que deseja deletar"
						+ "!\n");
				numero = leia.nextInt();
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println("Saque\n");
				keyPress();
				break;
			case 7:
				System.out.println("Depósito\n");
				keyPress();
				break;
			case 8:
				System.out.println("Transferência\n");
				keyPress();
				break;
			default:
				System.out.println("Opção inválida!");
				keyPress();
			}

		}

	}

	public static void sobre() {
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD
				+ "=====================================================");
		System.out.println("Sistema desenvolvido por: Luiz H. dos Santos         ");
		System.out.println("Generation: JAVA 82                                  ");
		System.out.println("=====================================================");
	}
	
	public static void keyPress() {
		 
		try {
 
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
 
		} catch (IOException e) {
 
			System.err.println("Ocorreu um erro ao tentar ler o teclado");
 
		}
	}
 
}
