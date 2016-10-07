import java.util.Scanner;

public class CaixaEletronico {

	public static void main(String[] args) throws LimiteSaquePorVezException, SaldoInsuficienteException {
		
		boolean continua = true;

		Pessoa pessoa = new Pessoa();
		
		System.out.println("Bem vindo ao nosso Caixa Eletr�nico");
		System.out.println("-----------------------------------\n");
		System.out.println("Insira seu cart�o e aperte enter");
		Scanner entrada = new Scanner(System.in);
		entrada.nextLine();
		System.out.println("Detectamos que � a primeira vez que voc� usa o nosso "
				+ "sistema, vamos coletar suas informa��es\nDigite enter para continuar");
		entrada.nextLine();
		
		while (continua) {
		
			System.out.println("Qual o seu nome?");
			pessoa.set_nome(entrada.nextLine());
			System.out.println("Qual o seu CPF?");
			pessoa.set_CPF(entrada.nextLine());
			System.out.println("Qual o tipo de sua conta?\nDigite cc"
					+ " para Conta Corrente e cp para Conta Poupan�a");
			String tipoConta = entrada.nextLine();
		
			if(tipoConta.equals("cc")){
				ContaCorrente cc = new ContaCorrente();
				pessoa.set_tipoConta(cc);
			}
		
			if(tipoConta.equals("cp")){
				ContaPoupanca cp = new ContaPoupanca();
				pessoa.set_tipoConta(cp);
			}
		
			System.out.println("Vamos ver se est� tudo correto?");
			System.out.println("Seu nome �: " + pessoa.get_nome());
			System.out.println("Seu cpf �: " + pessoa.get_CPF());
		
			if(tipoConta.equals("cc"))
				System.out.println("Seu tipo de conta � Conta Corrente.");
		
			if(tipoConta.equals("cp"))
				System.out.println("Seu tipo de conta � Conta Poupan�a.");
		
			System.out.println("\nEst� tudo correto? Digite s para sim e n para n�o.");
			String status = entrada.nextLine();
			
			if(status.equals("s"))
				break;
			System.out.println("Vamos come�ar de novo");
		}
		
		while (continua) {
			System.out.println("Sua senha para o cart�o � " + pessoa.get_tipoConta().get_senha());
			System.out.println("Voc� quer alterar a senha? Digite s para sim e n para n�o");
			String resposta = entrada.nextLine();
			
			if(resposta.equals("s")){
				System.out.println("Digite a nova senha.");
				pessoa.get_tipoConta().set_senha(Integer.parseInt(entrada.nextLine()));
			}
			
			System.out.println("Digite a sua senha.");
			for(int i = 3; i != 0; i--) {
				int verificaSenha = Integer.parseInt(entrada.nextLine());
				if(verificaSenha == pessoa.get_tipoConta().get_senha())
					break;
				System.out.println("Voc� tem mais " + (i - 1) + " tentativas");
			}
			break;
		}
		
		while (continua){
			System.out.println("Voc� quer sacar, depositar ou ver o saldo? Digite sacar, depositar ou saldo.");
			String acao = entrada.nextLine();
			if (acao.equals("sacar")){
				String referencia = pessoa.get_tipoConta().getClass().getSimpleName();
				System.out.println("Digite o valor do saque.");
				int valorSaque = Integer.parseInt(entrada.nextLine());
				try {
					if(pessoa.get_tipoConta().limiteSaquePorVez(valorSaque) && 
							pessoa.get_tipoConta().valorSaquePermitido(valorSaque)) {
						pessoa.get_tipoConta().saca(valorSaque);
						System.out.println("O saque de R$" + valorSaque + ",00 foi efetuado com sucesso");
					}
				} catch (LimiteSaquePorVezException e) {
					if(referencia.equals("ContaCorrente"))
						System.out.println("O seu limite de saque por vez � de R$1000,00");
					if(referencia.equals("ContaPoupanca"))
						System.out.println("O seu limite de saque por vez � de R$200,00");
					
				} catch (SaldoInsuficienteException e) {
					if(referencia.equals("ContaCorrente"))
						System.out.println("Voc� s� pode retirar R$" + (pessoa.get_tipoConta().get_saldo() + 1000) +
							",00 de sua conta.");
					if(referencia.equals("ContaPoupanca"))
						System.out.println("Voc� s� pode retirar R$" + (pessoa.get_tipoConta().get_saldo()) +
								",00 de sua conta.");
				}
			}
			
			if (acao.equals("depositar")){
				System.out.println("Digite o valor a ser depositado e insira o envelope");
				int valorDeposito = Integer.parseInt(entrada.nextLine());
				pessoa.get_tipoConta().deposita(valorDeposito);
				System.out.println("Seu dep�sito de R$" + valorDeposito + ",00 foi"
						+ " efetuado com sucesso");
			}
			
			if (acao.equals("saldo")) {
				System.out.println("Seu saldo � de R$" + pessoa.get_tipoConta().get_saldo() +
						",00.");
			}
			System.out.println("Quer fazer mais alguma opera��o? Digite s para sim"
					+ " e n para n�o");
			String maisOperacoes = entrada.nextLine();
			
			if(maisOperacoes.equals("n"))
				break;
		}
		System.out.println("Obrigado por utilizar nossos servi�os");
		entrada.close();
	}
}
