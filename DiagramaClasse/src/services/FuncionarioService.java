package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Funcionario;
import entities.ModeloCrud;

public class FuncionarioService implements ModeloCrud<Funcionario> {
	private List<Funcionario> funcionarios = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	@Override
    public void incluir(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("\nIncluído: " + funcionario);
    }

	@Override
	public void alterar(int id) {
		Funcionario funcionario = buscarFuncionarioPorId(id);
		if (funcionario != null) {
			System.out.print("Digite o novo nome: ");
			funcionario.setNome(scanner.nextLine());
			System.out.print("Digite a nova cidade: ");
			funcionario.setCidade(scanner.nextLine());
			System.out.print("Digite a nova UF: ");
			funcionario.setUf(scanner.nextLine());
			System.out.println("\nAlterado: " + funcionario);
		} else {
			System.out.println("\nFuncionário não encontrado.");
		}
	}

	@Override
	public void excluir(int id) {
		Funcionario funcionario = buscarFuncionarioPorId(id);
		if (funcionario != null) {
			funcionarios.remove(funcionario);
			System.out.println("\nExcluído: " + funcionario);
		} else {
			System.out.println("\nFuncionário não encontrado.");
		}
	}

	@Override
	public void recuperar(int id) {
		Funcionario funcionario = buscarFuncionarioPorId(id);
		if (funcionario != null) {
			System.out.println("\nRecuperar: " + funcionario);
		} else {
			System.out.println("\nFuncionário não encontrado.");
		}
	}

	@Override
	public void validar(int id) {
		Funcionario funcionario = buscarFuncionarioPorId(id);
		if (funcionario != null) {
			if (funcionario.getId() > 0 && funcionario.getNome() != null && !funcionario.getNome().isEmpty()
					&& funcionario.getCidade() != null && !funcionario.getCidade().isEmpty()
					&& funcionario.getUf() != null && !funcionario.getUf().isEmpty()) {
				System.out.println("\nValidação bem-sucedida");
			} else {
				if (funcionario.getNome().isEmpty()) {
					System.out.println("\nValidação falhou: Dado inválido no campo nome!");
				}
				if (funcionario.getCidade().isEmpty()) {
					System.out.println("\nValidação falhou: Dado inválido no campo cidade!");
				}
				if (funcionario.getUf().isEmpty()) {
					System.out.println("\nValidação falhou: Dado inválido no campo UF!");
				}
			}
		} else {
			System.out.println("\nFuncionário não encontrado.");
		}
	}

	public Funcionario buscarFuncionarioPorId(int id) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getId() == id) {
				return funcionario;
			}
		}
		return null;
	}
}
