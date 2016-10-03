import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCarrinhoDeCompra {

	//Ordem do construtor Produto: Nome, codigo, preço.
	//Ordem do construtor ProdutoComTamanho: Nome, codigo, preço, tamanho.
	
	@Test
	public void testeQuantProdutosNoCarrinho() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		Produto bone = new Produto("Boné", 123, 25);
        Produto cinto = new Produto("Cinto", 323, 15);
        ProdutoComTamanho camiseta = new ProdutoComTamanho("Camiseta P", 523, 25, "P");
		ProdutoComTamanho camisetaMA = new ProdutoComTamanho("Camiseta M Azul", 523, 25, "M");
		ProdutoComTamanho camisetaMV = new ProdutoComTamanho("Camiseta M Verde", 523, 25, "M");
		Produto cintoPreto = new Produto("Cinto Preto", 323, 15);

		carrinho.adicionaProduto(bone, 3);
		carrinho.adicionaProduto(cinto, 1);
		carrinho.adicionaProduto(cintoPreto, 3);
		carrinho.adicionaProduto(camiseta, 1);
		carrinho.adicionaProduto(camisetaMA, 1);
		carrinho.adicionaProduto(camisetaMV, 1);
		
		assertEquals(carrinho.quantProdutosNoCarrinho, 10);
	}
	
	@Test
	public void testeQuantProdutosNoCarrinhoComRemoveProduto() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		Produto bone = new Produto("Boné", 123, 25);
        Produto cinto = new Produto("Cinto", 323, 15);
        ProdutoComTamanho camiseta = new ProdutoComTamanho("Camiseta P", 523, 25, "P");
		ProdutoComTamanho camisetaMA = new ProdutoComTamanho("Camiseta M Azul", 523, 25, "M");
		ProdutoComTamanho camisetaMV = new ProdutoComTamanho("Camiseta M Verde", 523, 25, "M");
		Produto cintoPreto = new Produto("Cinto Preto", 323, 15);
		
		carrinho.adicionaProduto(bone, 3);
		carrinho.adicionaProduto(cinto, 1);
		carrinho.adicionaProduto(cintoPreto, 3);
		carrinho.adicionaProduto(camiseta, 1);
		carrinho.adicionaProduto(camisetaMA, 1);
		carrinho.adicionaProduto(camisetaMV, 1);
		carrinho.removeProduto(camiseta, 1);
		carrinho.removeProduto(bone, 2);
		
		assertEquals(carrinho.quantProdutosNoCarrinho, 7);
	}
	
	@Test
	public void testeQuantProdutosNoCarrinhoComRemoveMaiorQueQuantNoCarrinho() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		ProdutoComTamanho camisetaAzul = new ProdutoComTamanho("Camiseta Azul", 325, 15, "G");
		
		carrinho.adicionaProduto(camisetaAzul, 2);
		carrinho.removeProduto(camisetaAzul, 4);
		
		assertEquals(carrinho.quantProdutosNoCarrinho, 0);
	}
	
	@Test
	public void testeValorTotalCarrinho() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		Produto bone = new Produto("Boné", 123, 25);
        Produto cinto = new Produto("Cinto", 323, 15);
        ProdutoComTamanho camiseta = new ProdutoComTamanho("Camiseta P", 523, 25, "P");
		ProdutoComTamanho camisetaMA = new ProdutoComTamanho("Camiseta M Azul", 523, 25, "M");
		ProdutoComTamanho camisetaMV = new ProdutoComTamanho("Camiseta M Verde", 523, 25, "M");
		Produto cintoPreto = new Produto("Cinto Preto", 323, 15);
		
		carrinho.adicionaProduto(bone, 3);
		carrinho.adicionaProduto(cinto, 1);
		carrinho.adicionaProduto(cintoPreto, 3);
		carrinho.adicionaProduto(camiseta, 1);
		carrinho.adicionaProduto(camisetaMA, 1);
		carrinho.adicionaProduto(camisetaMV, 1);
		
		assertEquals(carrinho.valorTotal(), 210);
	}
	
	@Test
	public void testeValorTotalCarrinhoComRemoveProduto() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		Produto bone = new Produto("Boné", 123, 25);
        Produto cinto = new Produto("Cinto", 323, 15);
        ProdutoComTamanho camiseta = new ProdutoComTamanho("Camiseta P", 523, 25, "P");
		ProdutoComTamanho camisetaMA = new ProdutoComTamanho("Camiseta M Azul", 523, 25, "M");
		ProdutoComTamanho camisetaMV = new ProdutoComTamanho("Camiseta M Verde", 523, 25, "M");
		Produto cintoPreto = new Produto("Cinto Preto", 323, 15);
		
		carrinho.adicionaProduto(bone, 3);
		carrinho.adicionaProduto(cinto, 1);
		carrinho.adicionaProduto(cintoPreto, 3);
		carrinho.adicionaProduto(camiseta, 1);
		carrinho.adicionaProduto(camisetaMA, 1);
		carrinho.adicionaProduto(camisetaMV, 1);
		carrinho.removeProduto(bone, 2);
		
		assertEquals(carrinho.valorTotal(), 160);
	}
	
	@Test
	public void testeValorTotalCarrinhoComRemoveProdutoEquals() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		Produto cinto = new Produto("Cinto", 323, 15);
		Produto cintoPreto = new Produto("Cinto Preto", 323, 15);
		
		carrinho.adicionaProduto(cinto, 1);
		carrinho.adicionaProduto(cintoPreto, 3);
		carrinho.removeProduto(cinto, 2);
		
		assertEquals(carrinho.valorTotal(), 30);
	}
	
	@Test
	public void testeQuantidadeDoMesmoTipoDeProdutoEquals() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		Produto cinto = new Produto("Cinto", 323, 15);
		Produto cintoPreto = new Produto("Cinto Preto", 323, 15);
		
		carrinho.adicionaProduto(cinto, 1);
		carrinho.adicionaProduto(cintoPreto, 2);
		
		assertEquals(3, carrinho.cp.get(cinto), 0.00001);
	}
	
	@Test
	public void testeQuantidadeDoMesmoTipoDeProdutoEqualsComRemove() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		Produto cinto = new Produto("Cinto", 323, 15);
		Produto cintoPreto = new Produto("Cinto Preto", 323, 15);
		
		carrinho.adicionaProduto(cinto, 1);
		carrinho.adicionaProduto(cintoPreto, 2);
		carrinho.removeProduto(cinto, 2);
		
		assertEquals(1, carrinho.cp.get(cinto), 0.00001);
	}
	
	@Test
	public void testeQuantidadeDoMesmoTipoDeProdutoNotEqualsComRemove() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		Produto cinto = new Produto("Cinto", 967, 15);
		Produto cintoCouro = new Produto("Cinto Couro", 147, 15);
		
		carrinho.adicionaProduto(cinto, 1);
		carrinho.adicionaProduto(cintoCouro, 5);
		carrinho.removeProduto(cintoCouro, 1);
		
		assertEquals(1, carrinho.cp.get(cinto), 0.00001);
		assertEquals(4, carrinho.cp.get(cintoCouro), 0.00001);
	}

	@Test
	public void testeQuantidadeDeProdutoNotEquals() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		Produto cinto = new Produto("Cinto", 862, 15);
		Produto cintoCouro = new Produto("Cinto Couro", 447, 15);
		
		carrinho.adicionaProduto(cinto, 3);
		carrinho.adicionaProduto(cintoCouro, 2);
		
		assertEquals(3, carrinho.cp.get(cinto), 0.00001);
		assertEquals(2, carrinho.cp.get(cintoCouro), 0.00001);
	}
	
	@Test
	public void testeQuantidadeDoMesmoTipoDeProdutoComTamanhoEquals() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		ProdutoComTamanho camisetaAzul = new ProdutoComTamanho("Camiseta Azul", 476, 15, "P");
		ProdutoComTamanho camisetaVerde = new ProdutoComTamanho("Camiseta Verde", 476, 15, "P");
		
		carrinho.adicionaProduto(camisetaAzul, 2);
		carrinho.adicionaProduto(camisetaVerde, 2);
		
		assertEquals(4, carrinho.cp.get(camisetaVerde), 0.00001);
	}
	
	@Test
	public void testeQuantidadeDoMesmoTipoDeProdutoComTamanhoNotEquals() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		ProdutoComTamanho camisetaAzul = new ProdutoComTamanho("Camiseta Azul", 476, 15, "GG");
		ProdutoComTamanho camisetaVerde = new ProdutoComTamanho("Camiseta Verde", 476, 15, "P");
		
		carrinho.adicionaProduto(camisetaAzul, 2);
		carrinho.adicionaProduto(camisetaVerde, 3);
		
		assertEquals(3, carrinho.cp.get(camisetaVerde), 0.00001);
		assertEquals(2, carrinho.cp.get(camisetaAzul), 0.00001);
	}
	
	@Test
	public void testeQuantidadeDoMesmoTipoDeProdutoComTamanhoEqualsRemove() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		ProdutoComTamanho camisetaAzul = new ProdutoComTamanho("Camiseta Azul", 544, 15, "M");
		ProdutoComTamanho camisetaVerde = new ProdutoComTamanho("Camiseta Verde", 544, 15, "M");
		
		carrinho.adicionaProduto(camisetaAzul, 2);
		carrinho.adicionaProduto(camisetaVerde, 2);
		carrinho.removeProduto(camisetaAzul, 1);
		
		assertEquals(3, carrinho.cp.get(camisetaVerde), 0.00001);
	}
	
	@Test
	public void testeQuantidadeDoMesmoTipoDeProdutoComTamanhoNotEqualsRemove() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		ProdutoComTamanho camisetaAzul = new ProdutoComTamanho("Camiseta Azul", 325, 15, "G");
		ProdutoComTamanho camisetaVerde = new ProdutoComTamanho("Camiseta Verde", 325, 15, "PP");
		
		carrinho.adicionaProduto(camisetaAzul, 2);
		carrinho.adicionaProduto(camisetaVerde, 2);
		carrinho.removeProduto(camisetaAzul, 1);
		
		assertEquals(2, carrinho.cp.get(camisetaVerde), 0.00001);
		assertEquals(1, carrinho.cp.get(camisetaAzul), 0.00001);
	}
	
	@Test
	public void testeRemoveQuantTotalMesmoProdutoGetApontaNull() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		ProdutoComTamanho camisetaAzul = new ProdutoComTamanho("Camiseta Azul", 325, 15, "G");
		
		carrinho.adicionaProduto(camisetaAzul, 2);
		carrinho.removeProduto(camisetaAzul, 2);
		
		assertNull(null, carrinho.cp.get(camisetaAzul));
	}
	
	@Test
	public void testeRemoveQuantMaiorDoQueFoiAdicionadoGetApontaNull() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		ProdutoComTamanho camisetaAzul = new ProdutoComTamanho("Camiseta Azul", 325, 15, "G");
		
		carrinho.adicionaProduto(camisetaAzul, 2);
		carrinho.removeProduto(camisetaAzul, 4);
		
		assertNull(null, carrinho.cp.get(camisetaAzul));
	}
	
	@Test
	public void testeRemoveQuantTotalMesmoProdutoKeyFalse() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		ProdutoComTamanho camisetaAzul = new ProdutoComTamanho("Camiseta Azul", 325, 15, "G");
		
		carrinho.adicionaProduto(camisetaAzul, 2);
		carrinho.removeProduto(camisetaAzul, 2);
		
		assertFalse(carrinho.cp.containsKey(camisetaAzul));
	}
	
	@Test
	public void testeRemoveQuantMaiorDoQueFoiAdicionadoKeyFalse() {
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		ProdutoComTamanho camisetaAzul = new ProdutoComTamanho("Camiseta Azul", 325, 15, "G");
		
		carrinho.adicionaProduto(camisetaAzul, 2);
		carrinho.removeProduto(camisetaAzul, 4);
		
		assertFalse(carrinho.cp.containsKey(camisetaAzul));
	}
	
}
