import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompra {

	int quantProdutosNoCarrinho;
	
	public Map<Produto, Integer> cp = new HashMap<>();
	
	public void adicionaProduto(Produto produto, int quantidade){
		if(cp.containsKey(produto)){
			cp.put(produto, (cp.get(produto) + quantidade));
			quantProdutosNoCarrinho = quantProdutosNoCarrinho + quantidade;
		} else {
			cp.put(produto, quantidade);
			quantProdutosNoCarrinho = quantProdutosNoCarrinho + quantidade;
		}
	}
	
public void removeProduto(Produto produto, int quantidade){
		if(cp.containsKey(produto) && (cp.get(produto) - quantidade) <= 0){
			cp.remove(produto);
			quantProdutosNoCarrinho = quantProdutosNoCarrinho - quantidade;
		} if(cp.containsKey(produto) && (cp.get(produto) - quantidade) >= 1) {
			cp.put(produto, (cp.get(produto) - quantidade));
			quantProdutosNoCarrinho = quantProdutosNoCarrinho - quantidade;
		} if(this.quantProdutosNoCarrinho <= 0){
			this.quantProdutosNoCarrinho = 0;
		}
	}
	
	public int valorTotal(){
		int precoTotal = 0;
		for(Produto produto: cp.keySet()){
			int quantidade = cp.get(produto);
			precoTotal += (produto.preco * quantidade);
		}
		return precoTotal;
	}
	
}
