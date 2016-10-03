import static org.junit.Assert.*;

import org.junit.Test;

public class TesteProdutoComTamanho {

	//Ordem do construtor: Nome do produto, código, preço, tamanho.
	
	@Test
	public void testeEqualsProdutoComCodigoIgualTamanhoDiferente() {
		ProdutoComTamanho camiseta1 = new ProdutoComTamanho("Camiseta 1", 123, 25, "P");
		ProdutoComTamanho camiseta2 = new ProdutoComTamanho("Camiseta 2", 123, 25, "M");
		assertFalse(camiseta2.equals(camiseta1));
	}
	
	@Test
	public void testeEqualsProdutoComCodigoIgualTamanhoIgual() {
		ProdutoComTamanho camiseta3 = new ProdutoComTamanho("Camiseta 3", 123, 25, "P");
		ProdutoComTamanho camiseta4 = new ProdutoComTamanho("Camiseta 4", 123, 25, "P");
		assertTrue(camiseta4.equals(camiseta3));
	}
	
	@Test
	public void testeHashcodeIgualProdutoComCodigoIgualTamanhoIgual() {
		ProdutoComTamanho camisetaA = new ProdutoComTamanho("Camiseta A", 437, 25, "P");
		ProdutoComTamanho camisetaC = new ProdutoComTamanho("Camiseta C", 437, 25, "P");
		assertEquals(camisetaA.hashCode(), camisetaC.hashCode());
	}
	
	@Test
	public void testeHashcodeDiferenteProdutoComCodigoIgualTamanhoDiferente() {
		ProdutoComTamanho agasalho1 = new ProdutoComTamanho("Agasalho 1", 657, 25, "P");
		ProdutoComTamanho agasalho2 = new ProdutoComTamanho("Agasalho 2", 657, 25, "M");
		assertNotEquals(agasalho1.hashCode(), agasalho2.hashCode());
	}
	
	@Test
	public void testeEqualsVerdadeiroHashcodeIgual() {
		ProdutoComTamanho moletomVerde = new ProdutoComTamanho("Moletom Verde", 322, 25, "P");
		ProdutoComTamanho moletomAzul = new ProdutoComTamanho("Moletom Azul", 322, 25, "P");
		assertTrue(moletomVerde.equals(moletomAzul));
		assertEquals(moletomVerde.hashCode(), moletomAzul.hashCode());
	}
	
	@Test
	public void testeEqualsFalsoHashcodeDiferente() {
		ProdutoComTamanho agasalhoJ = new ProdutoComTamanho("Agasalho J", 592, 25, "G");
		ProdutoComTamanho agasalhoJ2 = new ProdutoComTamanho("Agasalho J", 592, 25, "P");
		assertFalse(agasalhoJ.equals(agasalhoJ2));
		assertNotEquals(agasalhoJ.hashCode(), agasalhoJ2.hashCode());
	}
	
}
