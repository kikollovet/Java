import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Empresa empresa = new Empresa();
		
		System.out.println("Bem vindo ao cadastro de funcion�rios");
		System.out.println("-------------------------------------");
		System.out.println("");
		System.out.println("Quer cadastrar um novo funcion�rio? Digite sim ou n�o!");
		String resposta = entrada.next();
		
		while(resposta.equals("sim") || resposta.equals("Sim") || 
				resposta.equals("S") || resposta.equals("s")) {
			
			System.out.println("Digite o nome:");
			String nome = entrada.next();
			System.out.println("Digite o cpf:");
			String cpf = entrada.next();
			System.out.println("Digite o sal�rio:");
			int salario = entrada.nextInt();
			System.out.println("Digite o cargo:");
			String cargo = entrada.next();
		
			Funcionario funcionario = new Funcionario(nome, cpf, salario, cargo);
			
			empresa.get_listaFuncionarios().add(funcionario);
			
			System.out.println("Quer cadastrar um novo funcion�rio? Digite sim ou n�o!");
			resposta = entrada.next();
		}
		
		entrada.close();
		
		System.out.println("----------------------------------------");
		System.out.println("Lista dos novos funcion�rios cadastrados");
		System.out.println("----------------------------------------\n");
		
		for(Funcionario f: empresa.get_listaFuncionarios()){
			System.out.println("--------------------------");
			System.out.println("Informa��es do funcion�rio");
			System.out.println("--------------------------");
			System.out.println(f);
		}
		
	}

}
