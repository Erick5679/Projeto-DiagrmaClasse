import java.util.Scanner;

import entities.Funcionario;
import services.FuncionarioService;

public class Main {
	public static void main(String[] args) {
		FuncionarioService funcionarioService = new FuncionarioService();
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\nMenu de Operações:");
			System.out.println("1. Incluir");
			System.out.println("2. Alterar");
			System.out.println("3. Excluir");
			System.out.println("4. Recuperar");
			System.out.println("5. Validar");
			System.out.println("6. Sair");
			System.out.print("Escolha uma opção: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consumir a nova linha

			switch (choice) {
			case 1:
				System.out.print("Digite o ID: ");
				int id = scanner.nextInt();
				scanner.nextLine(); // Consumir a nova linha
				if (funcionarioService.buscarFuncionarioPorId(id) != null) {
					System.out.println("\nFuncionário com ID " + id + " já existe. Inclusão não permitida.");
					continue;
				}
				System.out.print("Digite o nome: ");
				String nome = scanner.nextLine();
				System.out.print("Digite a cidade: ");
				String cidade = scanner.nextLine();
				System.out.print("Digite a UF: ");
				String uf = scanner.nextLine();
				Funcionario novoFuncionario = new Funcionario(id, nome, cidade, uf);
				funcionarioService.incluir(novoFuncionario);
				break;

			case 2:
				System.out.print("Digite o ID do funcionário a ser alterado: ");
				int idAlterar = scanner.nextInt();
				scanner.nextLine(); // Consumir a nova linha
				funcionarioService.alterar(idAlterar);
				break;
			case 3:
				System.out.print("Digite o ID do funcionário a ser excluído: ");
				int idExcluir = scanner.nextInt();
				scanner.nextLine(); // Consumir a nova linha
				funcionarioService.excluir(idExcluir);
				break;
			case 4:
				System.out.print("\nDigite o ID do funcionário a ser recuperado: ");
				int idRecuperar = scanner.nextInt();
				scanner.nextLine(); // Consumir a nova linha
				funcionarioService.recuperar(idRecuperar);
				break;
			case 5:
				System.out.print("Digite o ID do funcionário a ser validado: ");
				int idValidar = scanner.nextInt();
				scanner.nextLine(); // Consumir a nova linha
				funcionarioService.validar(idValidar);
				break;
			case 6:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (choice != 6);

		scanner.close();
	}
}
