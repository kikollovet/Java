import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Empresa empresa = new Empresa();
		
		System.out.println("Bem vindo ao cadastro de funcionários");
		System.out.println("-------------------------------------");
		System.out.println("");
		System.out.println("Quer cadastrar um novo funcionário? Digite sim ou não!");
		String resposta = entrada.nextLine();
		
		while(resposta.equals("sim") || resposta.equals("Sim") || 
				resposta.equals("S") || resposta.equals("s")) {
			
			System.out.println("Digite o nome:");
			String nome = entrada.nextLine();
			
			while (empresa.usuarioJaCadastrado(nome)){
				System.out.println("Nome do funcionario já existente. Digite outro nome:");
				nome = entrada.nextLine();
			}
			
			System.out.println("Digite o cpf:");
			String cpf = entrada.nextLine();
			System.out.println("Digite o salário:");
			String salario = entrada.nextLine();
			int salarioNum = Integer.parseInt(salario);
			System.out.println("Digite o cargo:");
			String cargo = entrada.nextLine();
		
			Funcionario funcionario = new Funcionario(nome, cpf, salarioNum, cargo);
			
			empresa.get_listaFuncionarios().add(funcionario);
			
			System.out.println("Quer cadastrar um novo funcionário? Digite sim ou não!");
			resposta = entrada.nextLine();
		}
		
		System.out.println("----------------------------------------");
		System.out.println("Lista dos novos funcionários cadastrados");
		System.out.println("----------------------------------------\n");
		
		System.out.println("Digite enter para continuar\n");
		entrada.nextLine();
		
		for(Funcionario f: empresa.get_listaFuncionarios()){
			System.out.println("----------------------------");
			System.out.println("Informações do funcionário " + (empresa.get_listaFuncionarios().indexOf(f) + 1));
			System.out.println("----------------------------");
			System.out.println(f);
			
			if(empresa.get_listaFuncionarios().size() != (empresa.get_listaFuncionarios().indexOf(f) + 1)){	
				System.out.println("\nDigite enter para continuar");
				entrada.nextLine();
			} else {
				System.out.println("\nFim da lista de novos funcionários");
			}
		}
		entrada.close();
	}

}
