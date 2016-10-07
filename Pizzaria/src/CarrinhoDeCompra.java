import java.util.HashMap;

public class CarrinhoDeCompra {

	HashMap<Pizza, Integer> _carrinhoCompra = new HashMap<>();
	
	public void adicionaPizzaNoCarrinho(Pizza pizza, int quantidade){
		if(_carrinhoCompra.containsKey(pizza)){
			_carrinhoCompra.put(pizza, (_carrinhoCompra.get(pizza) + quantidade));
		} else {
		_carrinhoCompra.put(pizza, quantidade);
		}
	}
	
	public void removeProduto(Pizza pizza, int quantidade){
		if(_carrinhoCompra.containsKey(pizza) && (_carrinhoCompra.get(pizza) - quantidade) <= 0)
			_carrinhoCompra.remove(pizza);
		if(_carrinhoCompra.containsKey(pizza) && (_carrinhoCompra.get(pizza) - quantidade) >= 1) 
			_carrinhoCompra.put(pizza, (_carrinhoCompra.get(pizza) - quantidade));
	}
	
	public int valorTotal(){
		int precoTotal = 0;
		for(Pizza pizza: _carrinhoCompra.keySet()){
			precoTotal += (pizza.get_preco() * _carrinhoCompra.get(pizza));
		}
		return precoTotal;
	}
	
	public void imprimePizzasNoCarrinho(){
		for(Pizza pizza: _carrinhoCompra.keySet()){
			System.out.println("Foram " + _carrinhoCompra.get(pizza) + " pizzas "
					+ "de " + pizza.get_nome());
			pizza.ingredientesUsados();
			System.out.println("O valor dessa pizza é R$" + pizza.get_preco() + ",00");
			System.out.println("----------------------------------");
		}
		System.out.println("O valor total da compra é R$" + valorTotal() + ",00");
	}
}
