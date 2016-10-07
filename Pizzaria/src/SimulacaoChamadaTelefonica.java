import java.util.Scanner;

public class SimulacaoChamadaTelefonica {

	public static void main(String[] args) {
		
		boolean confirmaCadastro = true;
		
		Cliente um = new Cliente("Joao Paulo", "99123-4567", "Rua do Sol, 767");
		Pizzaria pizzaria = new Pizzaria("Macaiba");
		pizzaria.adicionaCliente(um);
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Pizzaria " + pizzaria.get_nome() + ", boa noite!"
				+ " Qual o seu telefone pra confirmarmos no cadastro");
		String telefone = entrada.nextLine();
		System.out.println("Aguarde um momento enquanto verificamos se temos seu cadastro");
		for(Cliente cliente: pizzaria.get_listaClientes()){
			if(cliente.get_telefone().equals(telefone)){
				System.out.println("Encontramos o seu cadastro");
				System.out.println(cliente);
				confirmaCadastro = false;
			}
		}
		while(confirmaCadastro){
			System.out.println("Não encontramos seu cadastro");
			System.out.println("Vou coletar seus dados");
			System.out.println("Qual seu nome completo?");
			Cliente novo = new Cliente();
			novo.set_nome(entrada.nextLine());
			System.out.println("Qual seu telefone?");
			novo.set_telefone(entrada.nextLine());
			System.out.println("Qual seu endereço?");
			novo.set_endereco(entrada.nextLine());
			System.out.println("Seus dados de cadastro são:");
			System.out.println(novo);
			System.out.println("Telefone: " + novo.get_telefone());
			pizzaria.adicionaCliente(novo);
			break;
		}
		
		Ingrediente queijo = new Ingrediente("queijo");
		Ingrediente tomate = new Ingrediente("tomate");
		Ingrediente manjericao = new Ingrediente("manjericao");
		Ingrediente calabresa = new Ingrediente("calabresa");
		Ingrediente cebola = new Ingrediente("cebola");
		Ingrediente atum = new Ingrediente("atum");
		
		Pizza marguerita = new Pizza("Marguerita");
		marguerita.adicionaIngrediente(queijo);
		marguerita.adicionaIngrediente(tomate);
		marguerita.adicionaIngrediente(manjericao);
		
		Pizza deCalabresa = new Pizza("Calabresa");
		deCalabresa.adicionaIngrediente(queijo);
		deCalabresa.adicionaIngrediente(calabresa);
		deCalabresa.adicionaIngrediente(cebola);
		
		Pizza deAtum = new Pizza("Atum");
		deAtum.adicionaIngrediente(atum);
		deAtum.adicionaIngrediente(cebola);
		
		boolean seguePedido = true;
		
		CarrinhoDeCompra cp = new CarrinhoDeCompra();
		pizzaria.set_cp(cp);
		
		System.out.println("Ok, temos tres tipos de pizza, Calabresa, Atum e Marguerita");
		System.out.println("Diga o seu pedido");
		
		while(seguePedido){
			String pedido = entrada.nextLine();
			int quant = Integer.parseInt(pedido.substring(0, 1));
			String tipoPizza = pedido.substring(2, 6);
			if(tipoPizza.equals("atum"))
				pizzaria.get_cp().adicionaPizzaNoCarrinho(deAtum, quant);
			if(tipoPizza.equals("marg"))
				pizzaria.get_cp().adicionaPizzaNoCarrinho(marguerita, quant);
			if(tipoPizza.equals("cala"))
				pizzaria.get_cp().adicionaPizzaNoCarrinho(deCalabresa, quant);
			System.out.println("Mais alguma coisa?");
			String resposta = entrada.nextLine();
			if(resposta.equals("s")){
				System.out.println("O que mais deseja?");
			} else {
				break;
			}
		}
		System.out.println("Seu pedido foi:");
		System.out.println("===============");
		pizzaria.get_cp().imprimePizzasNoCarrinho();
		System.out.println("===============");
		System.out.println("Em aproximadamente 40 minutos chegarão suas pizzas");
		System.out.println("Pizzaria " + pizzaria.get_nome() + " agradece, tenha uma boa noite");
		

	}

}
