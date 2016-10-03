import static org.junit.Assert.*;

import org.junit.Test;

public class TesteProduto {

	//Ordem do construtor: Nome do produto, código, preço.
	
	@Test
	public void testeEqualsProdutoMesmoCodigo() {
		Produto boneA = new Produto("Bone A", 123, 25);
		Produto boneB = new Produto("Bone B", 123, 25);
		assertTrue(boneA.equals(boneB));
	}
	
	@Test
	public void testeEqualsProdutoCodigoDiferente() {
		Produto bone = new Produto("Boné", 323, 25);
		Produto cinto = new Produto("Cinto", 123, 25);
		assertFalse(bone.equals(cinto));
	}
	
	@Test
	public void testeHashcodeIgualProdutoMesmoCodigo() {
		Produto boneC = new Produto("Boné C", 123, 25);
		Produto boneD = new Produto("Boné D", 123, 25);
		assertEquals(boneC.hashCode(), boneD.hashCode());
	}
	
	@Test
	public void testeHashcodeDiferenteProdutoCodigoDiferente() {
		Produto boneE = new Produto("Boné E", 123, 25);
		Produto cintoA = new Produto("Cinto A", 983, 15);
		assertNotEquals(boneE.hashCode(), cintoA.hashCode());
	}
	
	@Test
	public void testeSeEqualsVerdadeiroHashcodeIgual() {
		Produto cintoF = new Produto("Cinto F", 598, 25);
		Produto cintoH = new Produto("Cinto H", 598, 25);
		assertTrue(cintoF.equals(cintoH));
		assertEquals(cintoF.hashCode(), cintoH.hashCode());
	}
	
	@Test
	public void testeSeEqualsFalsoHashcodeDiferente() {
		Produto cintoJ = new Produto("Cinto J", 599, 25);
		Produto boneL = new Produto("Boné L", 123, 25);
		assertFalse(cintoJ.equals(boneL));
		assertNotEquals(cintoJ.hashCode(), boneL.hashCode());
	}

}
