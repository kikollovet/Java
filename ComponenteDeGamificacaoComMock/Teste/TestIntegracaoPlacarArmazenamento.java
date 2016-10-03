import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestIntegracaoPlacarArmazenamento {

	@Before
	public void inicializaArquivo(){
		File pontuacao = new File("pontos.txt");
		pontuacao.delete();
	}
	
	@Test
	public void testQuantPontosEstrela() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento arm = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(arm);
		placar.criarTopico(luis);
		assertEquals(placar.get_armazenamentoArquivo().quantidadeTipoPontos("Luis", "estrela"), 15);
	}
	
	@Test
	public void testQuantPontosEstrelaMaisPontos() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento arm = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(arm);
		placar.criarTopico(luis);
		placar.criarTopico(luis);
		placar.criarTopico(luis);
		assertEquals(placar.get_armazenamentoArquivo().quantidadeTipoPontos("Luis", "estrela"), 45);
	}
	
	@Test
	public void testQuantPontosMoeda() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento arm = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(arm);
		placar.fazerComentario(luis);
		placar.darCurtida(luis);
		assertEquals(placar.get_armazenamentoArquivo().quantidadeTipoPontos("Luis", "moeda"), 15);
	}
	
	@Test
	public void testRetornarUsuarioComPontos() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento arm = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(arm);
		placar.criarTopico(luis);
		List<String> usuariosQReceberamPontos = Arrays.asList("Luis");
		assertTrue(placar.get_armazenamentoArquivo().retornarUsuariosComPontos().equals(usuariosQReceberamPontos));
	}
	
	@Test
	public void testRetornarUsuarioComPontosDoisUsuarios() throws IOException {
		Usuario luis = new Usuario("Luis");
		Usuario mila = new Usuario("Mila");
		Placar placar = new Placar();
		Armazenamento arm = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(arm);
		placar.criarTopico(luis);
		placar.criarTopico(mila);
		List<String> usuariosQReceberamPontos = Arrays.asList("Luis", "Mila");
		assertTrue(placar.get_armazenamentoArquivo().retornarUsuariosComPontos().equals(usuariosQReceberamPontos));
	}
	
	@Test
	public void testTipoDePontosUsuarioRecebeu() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento arm = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(arm);
		placar.criarTopico(luis);
		List<String> tipoDePontoUsuarioRecebeu = Arrays.asList("estrela");
		assertTrue(placar.get_armazenamentoArquivo().retornarTipoDePontosUmUsuario("Luis").equals(tipoDePontoUsuarioRecebeu));
	}
	
	@Test
	public void testTipoDePontosUsuarioRecebeuDoisUsuarios() throws IOException {
		Usuario luis = new Usuario("Luis");
		Usuario jorge = new Usuario("Jorge");
		Placar placar = new Placar();
		Armazenamento arm = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(arm);
		placar.criarTopico(luis);
		placar.criarTopico(jorge);
		placar.darCurtida(jorge);
		List<String> tipoDePontoLuisRecebeu = Arrays.asList("estrela");
		List<String> tipoDePontoJorgeRecebeu = Arrays.asList("estrela", "moeda");
		assertTrue(placar.get_armazenamentoArquivo().retornarTipoDePontosUmUsuario("Luis").equals(tipoDePontoLuisRecebeu));
		assertTrue(placar.get_armazenamentoArquivo().retornarTipoDePontosUmUsuario("Jorge").equals(tipoDePontoJorgeRecebeu));
	}
	
	@Test
	public void testRankingEstrela() throws IOException{
		Armazenamento arm = new Armazenamento();
		Placar placar = new Placar();
		placar.adicionaArmazenamentoArquivo(arm);
		Usuario luis = new Usuario("Luis");
		Usuario pedro = new Usuario("Pedro");
		placar.criarTopico(luis);
		placar.criarTopico(pedro);
		placar.criarTopico(luis);
		placar.darCurtida(luis);
		placar.darCurtida(pedro);
		placar.fazerComentario(luis);
		placar.get_armazenamentoArquivo().adicionaUsuarioAListaAPartirDeArquivoEstrela("Pedro");
		placar.get_armazenamentoArquivo().adicionaUsuarioAListaAPartirDeArquivoEstrela("Luis");
		List<String> RankingEstrela = Arrays.asList("Luis 35", "Pedro 20");
		assertTrue(placar.verRankingEstrelaArquivo().equals(RankingEstrela));
	}
	
	@Test
	public void testRankingMoeda() throws IOException{
		Armazenamento arm = new Armazenamento();
		Placar placar = new Placar();
		placar.adicionaArmazenamentoArquivo(arm);
		Usuario luis = new Usuario("Luis");
		Usuario pedro = new Usuario("Pedro");
		placar.criarTopico(luis);
		placar.criarTopico(pedro);
		placar.criarTopico(luis);
		placar.darCurtida(luis);
		placar.darCurtida(pedro);
		placar.fazerComentario(luis);
		placar.get_armazenamentoArquivo().adicionaUsuarioAListaAPartirDeArquivoMoeda("Pedro");
		placar.get_armazenamentoArquivo().adicionaUsuarioAListaAPartirDeArquivoMoeda("Luis");
		List<String> RankingMoeda = Arrays.asList("Luis 15", "Pedro 5");
		assertTrue(placar.verRankingMoedaArquivo().equals(RankingMoeda));
	}

}
