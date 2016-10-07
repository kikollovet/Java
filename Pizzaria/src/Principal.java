
public class Principal {

	public static void main(String[] args) {
		
		Ingrediente queijo = new Ingrediente("queijo");
		Ingrediente tomate = new Ingrediente("tomate");
		Ingrediente manjericao = new Ingrediente("manjericao");
		Ingrediente calabresa = new Ingrediente("calabresa");
		
		Pizza pizza = new Pizza("Marguerita");
		pizza.adicionaIngrediente(queijo);
		pizza.adicionaIngrediente(tomate);
		pizza.adicionaIngrediente(manjericao);
		
		Pizza pizza2 = new Pizza("Calabresa");
		pizza2.adicionaIngrediente(queijo);
		pizza2.adicionaIngrediente(calabresa);
		
		CarrinhoDeCompra cp = new CarrinhoDeCompra();
		cp.adicionaPizzaNoCarrinho(pizza, 1);
		cp.adicionaPizzaNoCarrinho(pizza, 2);
		cp.adicionaPizzaNoCarrinho(pizza, 3);
		cp.adicionaPizzaNoCarrinho(pizza2, 2);
		cp.removeProduto(pizza, 2);
		
		cp.imprimePizzasNoCarrinho();
	}
	
}
