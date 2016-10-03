import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestPlacar {

	@Test
	public void testRegistroPontosCriarTopico() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.criarTopico(luis);
		assertEquals(luis.get_pontosEstrela(), 15);
	}
	
	@Test
	public void testRegistroPontosCriarTopicoDoisUsuarios() throws IOException {
		Usuario luis = new Usuario("Luis");
		Usuario pedro = new Usuario("Pedro");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.adicionaUsuarioALista(pedro);
		placar.criarTopico(luis);
		placar.criarTopico(luis);
		placar.criarTopico(pedro);
		assertEquals(luis.get_pontosEstrela(), 30);
		assertEquals(pedro.get_pontosEstrela(), 15);
	}
	
	@Test
	public void testRegistroPontosFazerComentario() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.fazerComentario(luis);
		assertEquals(luis.get_pontosMoeda(), 10);
	}
	
	@Test
	public void testRegistroPontosFazerDoisComentario() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.fazerComentario(luis);
		placar.fazerComentario(luis);
		assertEquals(luis.get_pontosMoeda(), 20);
	}
	
	@Test
	public void testRegistroPontosFazerComentarioDoisUsuarios() throws IOException {
		Usuario luis = new Usuario("Luis");
		Usuario pedro = new Usuario("Pedro");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.adicionaUsuarioALista(pedro);
		placar.fazerComentario(luis);
		placar.fazerComentario(luis);
		placar.fazerComentario(pedro);
		assertEquals(luis.get_pontosMoeda(), 20);
		assertEquals(pedro.get_pontosMoeda(), 10);
	}
	
	@Test
	public void testRegistroPontosCurtida() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.darCurtida(luis);
		assertEquals(luis.get_pontosEstrela(), 5);
		assertEquals(luis.get_pontosMoeda(), 5);
	}
	
	@Test
	public void testRegistroPontosTresFuncoes() throws IOException {
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.darCurtida(luis);
		placar.fazerComentario(luis);
		placar.criarTopico(luis);
		assertEquals(luis.get_pontosEstrela(), 20);
		assertEquals(luis.get_pontosMoeda(), 15);
	}
	
	@Test
	public void retornarTodosPontosDeUmUsuário() throws IOException{
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.darCurtida(luis);
		placar.criarTopico(luis);
		placar.fazerComentario(luis);
		assertEquals(placar.retornarPontuacaoTotalUsuario(luis), "20 estrela, 15 moeda");
	}
	
	@Test
	public void retornarSoOTipoDePontoQueOUsuarioTem() throws IOException{
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.criarTopico(luis);
		assertEquals(placar.retornarPontuacaoTotalUsuario(luis), "15 estrela");
	}
	
	@Test
	public void retornarSoOTipoDePontoQueOUsuarioTemTesteDois() throws IOException{
		Usuario luis = new Usuario("Luis");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.fazerComentario(luis);
		assertEquals(placar.retornarPontuacaoTotalUsuario(luis), "10 moeda");
	}
	
	@Test
	public void retornarSoOTipoDePontoQueOUsuarioTemComDoisUsuarios() throws IOException{
		Usuario luis = new Usuario("Luis");
		Usuario pedro = new Usuario("Pedro");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.adicionaUsuarioALista(pedro);
		placar.fazerComentario(luis);
		placar.darCurtida(pedro);
		assertEquals(placar.retornarPontuacaoTotalUsuario(luis), "10 moeda");
		assertEquals(placar.retornarPontuacaoTotalUsuario(pedro), "5 estrela, 5 moeda");
	}
	
	@Test
	public void testeRankingEstrela() throws IOException{
		Usuario luis = new Usuario("Luis");
		Usuario pedro = new Usuario("Pedro");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.adicionaUsuarioALista(pedro);
		placar.criarTopico(luis);
		placar.criarTopico(pedro);
		placar.criarTopico(pedro);
		List<String> rankingEstrela = Arrays.asList("Pedro 30", "Luis 15");
		assertTrue(placar.verRankingEstrela().equals(rankingEstrela));
	}
	
	@Test
	public void testeRankingEstrelaUsuarioSemPontos() throws IOException{
		Usuario luis = new Usuario("Luis");
		Usuario pedro = new Usuario("Pedro");
		Usuario joca = new Usuario("Joca");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.adicionaUsuarioALista(pedro);
		placar.adicionaUsuarioALista(joca);
		placar.criarTopico(luis);
		placar.criarTopico(pedro);
		placar.criarTopico(pedro);
		List<String> rankingEstrela = Arrays.asList("Pedro 30", "Luis 15");
		assertTrue(placar.verRankingEstrela().equals(rankingEstrela));
	}
	
	@Test
	public void testeRankingEstrelaComTresUsuarios() throws IOException{
		Usuario luis = new Usuario("Luis");
		Usuario pedro = new Usuario("Pedro");
		Usuario joca = new Usuario("Joca");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.adicionaUsuarioALista(pedro);
		placar.adicionaUsuarioALista(joca);
		placar.criarTopico(luis);
		placar.criarTopico(pedro);
		placar.criarTopico(joca);
		placar.criarTopico(joca);
		placar.criarTopico(joca);
		placar.criarTopico(pedro);
		List<String> rankingEstrela = Arrays.asList("Joca 45", "Pedro 30", "Luis 15");
		assertTrue(placar.verRankingEstrela().equals(rankingEstrela));
	}
	
	@Test
	public void testeRankingMoedaComTresUsuarios() throws IOException{
		Usuario luis = new Usuario("Luis");
		Usuario pedro = new Usuario("Pedro");
		Usuario joca = new Usuario("Joca");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.adicionaUsuarioALista(pedro);
		placar.adicionaUsuarioALista(joca);
		placar.fazerComentario(luis);
		placar.fazerComentario(pedro);
		placar.fazerComentario(joca);
		placar.fazerComentario(joca);
		placar.fazerComentario(joca);
		placar.fazerComentario(pedro);
		List<String> rankingMoeda = Arrays.asList("Joca 30", "Pedro 20", "Luis 10");
		assertTrue(placar.verRankingMoeda().equals(rankingMoeda));
	}
	
	@Test
	public void testeRankingMoedaComTresUsuariosUmSemPontos() throws IOException{
		Usuario luis = new Usuario("Luis");
		Usuario pedro = new Usuario("Pedro");
		Usuario joca = new Usuario("Joca");
		Usuario luana = new Usuario("Luana");
		Placar placar = new Placar();
		placar.adicionaUsuarioALista(luis);
		placar.adicionaUsuarioALista(pedro);
		placar.adicionaUsuarioALista(joca);
		placar.adicionaUsuarioALista(luana);
		placar.darCurtida(luis);
		placar.fazerComentario(luis);
		placar.fazerComentario(luis);
		placar.fazerComentario(pedro);
		placar.fazerComentario(joca);
		placar.fazerComentario(joca);
		placar.fazerComentario(joca);
		placar.fazerComentario(pedro);
		List<String> rankingMoeda = Arrays.asList("Joca 30", "Luis 25", "Pedro 20");
		assertTrue(placar.verRankingMoeda().equals(rankingMoeda));
	}

}
