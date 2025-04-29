package conta_bancaria;

import java.util.Scanner;
import conta_bancaria.model.contaCorrente;
import conta_bancaria.model.contaPoupanca;
import conta_bancaria.util.Cores;

public class menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		// instanciando um objeto da classe contaCorrente
		contaCorrente cc1 = new contaCorrente(2, 456, 1, "Renata Negrini", 600000, 60000);
		cc1.visualizar();

		cc1.sacar(659000);
		cc1.visualizar();

		cc1.depositar(50000);
		cc1.visualizar();

		// iniciando um objeto da classe conta poupança
		contaPoupanca cp1 = new contaPoupanca(3, 789, 2, "Iago Peruca", 4000, "17/10/2004");
		cp1.visualizar();

		cp1.sacar(3000);
		cp1.visualizar();
		cp1.depositar(5000);
		cp1.visualizar();

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
			System.out.println("            9 - Bônus                                ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("=====================================================");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_WHITE);

			opcao = leia.nextInt();

			if (opcao == 9) {
				sobre();
				System.exit(0);
			}
			System.out.printf(Cores.TEXT_CYAN_BOLD + "");
			switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n");
				break;
			case 2:
				System.out.println("Todas contas registradas\n");
				break;
			case 3:
				System.out.println("Buscar conta\n");
				break;
			case 4:
				System.out.println("Atualização de dados\n");
				break;
			case 5:
				System.out.println("Deletar conta\n");
				break;
			case 6:
				System.out.println("Saque\n");
				break;
			case 7:
				System.out.println("Depósito\n");
				break;
			case 8:
				System.out.println("Transferência\n");
				break;
			default:
				System.out.println("Opção inválida!");
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
}
