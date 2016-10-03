import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestIntegracaoPlacarMock {

	@Test
	public void testRegistraPontosEstrelaCriarTopico() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		placar.criarTopico(luis);
		mock.conferirTotalPontosEstrelaMock(luis, 15);
	}
	
	@Test
	public void testRegistraPontosEstrelaCriarTopicoDoisUsuarios() throws IOException {
		Usuario luis = new Usuario("Luis");
		Usuario joao = new Usuario("Joao");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		mock.adicionaUsuarioAListaMock(luis);
		mock.adicionaUsuarioAListaMock(joao);
		placar.ligarMock();
		placar.criarTopico(luis);
		placar.criarTopico(joao);
		placar.criarTopico(joao);
		mock.conferirTotalPontosEstrelaMock(luis, 15);
		mock.conferirTotalPontosEstrelaMock(joao, 30);
	}

	@Test
	public void testRegistraPontosMoeda() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		placar.fazerComentario(luis);
		mock.conferirTotalPontosMoedaMock(luis, 10);
	}
	
	@Test
	public void testRegistraPontosMoedaDoisUsuarios() throws IOException {
		Usuario luis = new Usuario("Luis");
		Usuario joao = new Usuario("Joao");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		mock.adicionaUsuarioAListaMock(joao);
		placar.darCurtida(luis);
		placar.fazerComentario(joao);
		placar.darCurtida(joao);
		mock.conferirTotalPontosMoedaMock(luis, 5);
		mock.conferirTotalPontosMoedaMock(joao, 15);
	}

	@Test
	public void testRegistraPontosMoedaFazerComentario() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		placar.fazerComentario(luis);
		placar.fazerComentario(luis);
		placar.darCurtida(luis);
		mock.conferirTotalPontosMoedaMock(luis, 25);
	}
	
	@Test
	public void testRecuperarPontosEstrelaDeUmUsuario() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		placar.criarTopico(luis);
		assertEquals(mock.recuperarPontosMock(luis, "estrela"), "Luis 15 estrela");
	}
	
	@Test
	public void testRecuperarPontosMoedaDeUmUsuario() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		placar.darCurtida(luis);
		placar.darCurtida(luis);
		assertEquals(mock.recuperarPontosMock(luis, "moeda"), "Luis 10 moeda");
	}
	
	@Test
	public void testRetornarUmUsuarioComPontos() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		placar.darCurtida(luis);
		placar.darCurtida(luis);
		assertEquals(mock.retornarUsuarioComPontosMock(), "Luis");
	}
	
	@Test
	public void testRetornarDoisUsuariosComPontos() throws IOException {
		Usuario luis = new Usuario("Luis");
		Usuario gabi = new Usuario("Gabi");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		mock.adicionaUsuarioAListaMock(gabi);
		placar.darCurtida(luis);
		placar.darCurtida(luis);
		placar.criarTopico(gabi);
		assertEquals(mock.retornarUsuarioComPontosMock(), "Luis, Gabi");
	}
	
	@Test
	public void testRetornarDoisUsuariosComPontosENaoIncluirUsuarioSemPontos() throws IOException {
		Usuario luis = new Usuario("Luis");
		Usuario gabi = new Usuario("Gabi");
		Usuario joana = new Usuario("Joana");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		mock.adicionaUsuarioAListaMock(gabi);
		mock.adicionaUsuarioAListaMock(joana);
		placar.darCurtida(luis);
		placar.darCurtida(luis);
		placar.criarTopico(gabi);
		assertEquals(mock.retornarUsuarioComPontosMock(), "Luis, Gabi");
	}
	
	@Test
	public void testRetornarTipoPontos() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		placar.darCurtida(luis);
		placar.darCurtida(luis);
		assertEquals(mock.retornarTipoPontosMock(luis), "estrela, moeda");
	}
	
	@Test
	public void testRetornarTipoPontosSoEstrela() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		placar.criarTopico(luis);
		assertEquals(mock.retornarTipoPontosMock(luis), "estrela");
	}
	
	@Test
	public void testRetornarTipoPontosSoMoeda() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		placar.fazerComentario(luis);
		assertEquals(mock.retornarTipoPontosMock(luis), "moeda");
	}
	
	@Test
	public void testRankingEstrela() throws IOException {
		Usuario luis = new Usuario("Luis");
		Usuario joao = new Usuario("Joao");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		mock.adicionaUsuarioAListaMock(joao);
		placar.criarTopico(luis);
		placar.criarTopico(joao);
		placar.criarTopico(joao);
		List<String> rankingEstrela = Arrays.asList("Joao 30", "Luis 15");
		assertTrue(placar.verRankingEstrela().equals(rankingEstrela));
	}
	
	@Test
	public void testRankingMoeda() throws IOException {
		Usuario luis = new Usuario("Luis");
		Usuario joao = new Usuario("Joao");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		mock.adicionaUsuarioAListaMock(joao);
		placar.darCurtida(luis);
		placar.darCurtida(luis);
		placar.darCurtida(joao);
		List<String> rankingMoeda = Arrays.asList("Luis 10", "Joao 5");
		assertTrue(placar.verRankingEstrela().equals(rankingMoeda));
	}
	
	@Test
	public void testRankingMoedaTresUsuarios() throws IOException {
		Usuario luis = new Usuario("Luis");
		Usuario pedro = new Usuario("Pedro");
		Usuario joca = new Usuario("Joca");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		mock.adicionaUsuarioAListaMock(pedro);
		mock.adicionaUsuarioAListaMock(joca);
		placar.fazerComentario(luis);
		placar.fazerComentario(pedro);
		placar.fazerComentario(joca);
		placar.fazerComentario(joca);
		placar.fazerComentario(joca);
		placar.fazerComentario(pedro);
		placar.criarTopico(luis);
		List<String> rankingMoeda = Arrays.asList("Joca 30", "Pedro 20", "Luis 10");
		assertTrue(placar.verRankingMoeda().equals(rankingMoeda));
	}
	
	@Test
	public void testRetornarPontuaçãoTotalDeUsuario() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		Armazenamento mock = new Armazenamento();
		placar.adicionaArmazenamentoArquivo(mock);
		placar.ligarMock();
		mock.adicionaUsuarioAListaMock(luis);
		placar.darCurtida(luis);
		placar.darCurtida(luis);
		assertEquals(placar.retornarPontuacaoTotalUsuarioUsandoMock(luis), "10 estrela, 10 moeda");
	}
}
