import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestArmazenamento {

	@Before
	public void inicializaArquivo(){
		File pontuacao = new File("pontos.txt");
		pontuacao.delete();
	}
	
	@Test
	public void testEscreverArquivo() throws IOException {
		Armazenamento arm = new Armazenamento();
		arm.armazenaPontos("Luis", "estrela", 1);
	}
	
	@Test
	public void testEscreverArquivo2() throws IOException {
		Armazenamento arm = new Armazenamento();
		arm.armazenaPontos("Luis", "estrela", 2);
		arm.armazenaPontos("Luis", "estrela", 3);
	}
	
	@Test
	public void testEscreverArquivo3() throws IOException {
		Armazenamento arm = new Armazenamento();
		arm.armazenaPontos("Luis", "estrela", 10);
		arm.armazenaPontos("Luis", "estrela", 20);
	}
	
	@Test
	public void testRetornarQuantidadeTipoDePontos() throws IOException {
		Armazenamento arm = new Armazenamento();
		arm.armazenaPontos("Luis", "estrela", 10);
		arm.armazenaPontos("Luis", "estrela", 20);
		assertEquals(arm.quantidadeTipoPontos("Luis", "estrela"), 30);
	}
	
	@Test
	public void testRetornarQuantidadeTipoDePontosUmUsuario() throws IOException {
		Armazenamento arm = new Armazenamento();
		arm.armazenaPontos("Luis", "moeda", 10);
		arm.armazenaPontos("Luis", "estrela", 20);
		arm.armazenaPontos("Luis", "moeda", 30);
		arm.armazenaPontos("Guerra", "moeda", 30);
		assertEquals(arm.quantidadeTipoPontos("Luis", "moeda"), 40);
	}
	
	@Test
	public void testRetornarQuantidadeTipoDePontosUmUsuarioDois() throws IOException {
		Armazenamento arm = new Armazenamento();
		arm.armazenaPontos("Luis", "moeda", 10);
		arm.armazenaPontos("Luis", "estrela", 20);
		arm.armazenaPontos("Luis", "moeda", 30);
		arm.armazenaPontos("Guerra", "estrela", 30);
		arm.armazenaPontos("Guerra", "moeda", 20);
		arm.armazenaPontos("Guerra", "moeda", 5);
		assertEquals(arm.quantidadeTipoPontos("Luis", "moeda"), 40);
		assertEquals(arm.quantidadeTipoPontos("Guerra", "moeda"), 25);
	}
	
	@Test
	public void testRetornarUsuariosQueJaReceberamPontos() throws IOException {
		Armazenamento arm = new Armazenamento();
		arm.armazenaPontos("Luis", "moeda", 10);
		arm.armazenaPontos("Luis", "estrela", 20);
		arm.armazenaPontos("Luis", "moeda", 30);
		arm.armazenaPontos("Guerra", "estrela", 30);
		arm.armazenaPontos("Guerra", "moeda", 20);
		arm.armazenaPontos("Guerra", "moeda", 5);
		List<String> usuariosQReceberamPontos = Arrays.asList("Luis", "Guerra");
		assertTrue(arm.retornarUsuariosComPontos().equals(usuariosQReceberamPontos));
	}
	
	@Test
	public void testRetornarUsuariosQueJaReceberamPontosComUsuariosQueNaoReceberamPontos() throws IOException {
		Armazenamento arm = new Armazenamento();
		arm.armazenaPontos("Luis", "moeda", 10);
		arm.armazenaPontos("Luis", "estrela", 20);
		arm.armazenaPontos("Guerra", "estrela", 30);
		arm.armazenaPontos("Pedro", "moeda", 20);
		arm.armazenaPontos("Joao", "moeda", 0);
		arm.armazenaPontos("Joao", "estrela", 0);
		List<String> usuariosQReceberamPontos = Arrays.asList("Luis", "Guerra", "Pedro");
		assertTrue(arm.retornarUsuariosComPontos().equals(usuariosQReceberamPontos));
	}
	
	@Test
	public void testRetornarTiposDePontoQueUmUsuarioRecebeu() throws IOException {
		Armazenamento arm = new Armazenamento();
		arm.armazenaPontos("Luis", "moeda", 10);
		arm.armazenaPontos("Luis", "estrela", 20);
		arm.armazenaPontos("Luis", "moeda", 30);
		arm.armazenaPontos("Guerra", "estrela", 30);
		arm.armazenaPontos("Guerra", "moeda", 20);
		arm.armazenaPontos("Guerra", "ouro", 5);
		List<String> tipoDePontoUsuarioRecebeu = Arrays.asList("moeda", "estrela");
		List<String> tipoDePontoGuerraRecebeu = Arrays.asList("estrela", "moeda", "ouro");
		assertTrue(arm.retornarTipoDePontosUmUsuario("Luis").equals(tipoDePontoUsuarioRecebeu));
		assertTrue(arm.retornarTipoDePontosUmUsuario("Guerra").equals(tipoDePontoGuerraRecebeu));
	}

}
