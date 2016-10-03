import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Armazenamento {
	
	private List<String> _listaUsuarioPontos = new ArrayList<>();
	private List<String> _listaTipoPontosUsuario = new ArrayList<>();
	private List<Usuario> _listaDeUsuariosPontosEstrela = new ArrayList<>();
	private List<Usuario> _listaDeUsuariosPontosMoeda = new ArrayList<>();
	private List<Usuario> _listaUsuariosMock = new ArrayList<>();

	public List<Usuario> get_listaDeUsuariosPontosEstrela() {
		return _listaDeUsuariosPontosEstrela;
	}

	public List<Usuario> get_listaDeUsuariosPontosMoeda() {
		return _listaDeUsuariosPontosMoeda;
	}


	protected void armazenaPontos(String nome, String tipoPonto, int pontos) throws IOException{
		File pontuacao = new File("pontos.txt");
		FileWriter arq = new FileWriter(pontuacao, true);
	    PrintWriter gravarArq = new PrintWriter(arq);
	    gravarArq.printf(nome+"|"+tipoPonto+"|"+pontos+"%n");
	    arq.close();
	}

	protected int quantidadeTipoPontos(String nome, String tipoDePonto) throws IOException {
		FileInputStream stream = new FileInputStream("pontos.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String linha = br.readLine();
		int total = 0;
		while(linha != null) {
		   String nomeDoUsuario = linha.substring(0, linha.indexOf('|'));
		   String tipoPontoASerContado = linha.substring(linha.indexOf('|') + 1, linha.lastIndexOf('|'));
		   String pontos = (linha.substring(linha.lastIndexOf('|') + 1, linha.length()));
		   int i = Integer.parseInt(pontos);
		   if(nome.equals(nomeDoUsuario) && tipoDePonto.equals(tipoPontoASerContado))
			  total += i;
		   
		   linha = br.readLine();
		}
		br.close();
		return total;
	}

	protected List<String> retornarUsuariosComPontos() throws IOException {
		FileInputStream stream = new FileInputStream("pontos.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String linha = br.readLine();
		_listaUsuarioPontos.clear();
		while(linha != null) {
		   String nomeDoUsuario = linha.substring(0, linha.indexOf('|'));
		   String pontos = (linha.substring(linha.lastIndexOf('|') + 1, linha.length()));
		   int pontosInteiro = Integer.parseInt(pontos);
		   if(!_listaUsuarioPontos.contains(nomeDoUsuario) && pontosInteiro != 0)
			   _listaUsuarioPontos.add(nomeDoUsuario);
		   linha = br.readLine();
		}
		br.close();
		return _listaUsuarioPontos;
	}

	protected List<String> retornarTipoDePontosUmUsuario(String nome) throws IOException {
		FileInputStream stream = new FileInputStream("pontos.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String linha = br.readLine();
		_listaTipoPontosUsuario.clear();
		while(linha != null) {
		   String nomeDoUsuario = linha.substring(0, linha.indexOf('|'));
		   String tipoPontoASerContado = linha.substring(linha.indexOf('|') + 1, linha.lastIndexOf('|'));
		   String pontos = (linha.substring(linha.lastIndexOf('|') + 1, linha.length()));
		   int pontosInt = Integer.parseInt(pontos);
		   if(!_listaTipoPontosUsuario.contains(tipoPontoASerContado) && pontosInt != 0 && nome.equals(nomeDoUsuario))
			   _listaTipoPontosUsuario.add(tipoPontoASerContado);
		   linha = br.readLine();
		}
		br.close();
		return _listaTipoPontosUsuario;
	}
	
	
	protected List<Usuario> adicionaUsuarioAListaAPartirDeArquivoEstrela(String nome) throws IOException {
		FileInputStream stream = new FileInputStream("pontos.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String linha = br.readLine();
		int totalEstrela = 0;
		String nomeDoUsuario = "";
		String tipoPontoASerContado = "";
		while(linha != null) {
		   nomeDoUsuario = linha.substring(0, linha.indexOf('|'));
		   tipoPontoASerContado = linha.substring(linha.indexOf('|') + 1, linha.lastIndexOf('|'));
		   String pontos = (linha.substring(linha.lastIndexOf('|') + 1, linha.length()));
		   int i = Integer.parseInt(pontos);
		   if(nome.equals(nomeDoUsuario) && "estrela".equals(tipoPontoASerContado)){
			  totalEstrela += i;
		   }
		   
		   linha = br.readLine();
		}
		Usuario usuario = new Usuario(nome);
			usuario.set_pontosEstrela(totalEstrela);

		_listaDeUsuariosPontosEstrela.add(usuario);
		br.close();
		return _listaDeUsuariosPontosEstrela;
	
	}
	
	protected List<Usuario> adicionaUsuarioAListaAPartirDeArquivoMoeda(String nome) throws IOException {
		FileInputStream stream = new FileInputStream("pontos.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String linha = br.readLine();
		int totalMoeda = 0;
		String nomeDoUsuario = "";
		String tipoPontoASerContado = "";
		while(linha != null) {
		   nomeDoUsuario = linha.substring(0, linha.indexOf('|'));
		   tipoPontoASerContado = linha.substring(linha.indexOf('|') + 1, linha.lastIndexOf('|'));
		   String pontos = (linha.substring(linha.lastIndexOf('|') + 1, linha.length()));
		   int i = Integer.parseInt(pontos);
		   if(nome.equals(nomeDoUsuario) && "moeda".equals(tipoPontoASerContado)){
			   totalMoeda += i;
		   }
		   
		   linha = br.readLine();
		}
		Usuario usuario = new Usuario(nome);
		usuario.set_pontosMoeda(totalMoeda);
		_listaDeUsuariosPontosMoeda.add(usuario);
		br.close();
		return _listaDeUsuariosPontosMoeda;
	
	}
	
	public List<Usuario> get_listaUsuariosMock() {
		return _listaUsuariosMock;
	}

	protected void adicionaUsuarioAListaMock(Usuario u){
		_listaUsuariosMock.add(u);
	}
	
	protected void registroTotalPontosEstrelaMock(Usuario u, int valor){
		if(_listaUsuariosMock.contains(u));{
			int pontos = u.get_pontosEstrela() + valor;
			u.set_pontosEstrela(pontos);
		}
	}
	
	protected void conferirTotalPontosEstrelaMock(Usuario u, int valor) {
		if(_listaUsuariosMock.contains(u));{
			assertEquals(valor, u.get_pontosEstrela());
		}
	}
	
	protected void registroTotalPontosMoedaMock(Usuario u, int valor){
		if(_listaUsuariosMock.contains(u));{
			int pontos = u.get_pontosMoeda() + valor;
			u.set_pontosMoeda(pontos);
		}
	}
	
	protected void conferirTotalPontosMoedaMock(Usuario u, int valor) {
		if(_listaUsuariosMock.contains(u));{
			assertEquals(valor, u.get_pontosMoeda());
		}
	}

	protected String recuperarPontosMock(Usuario u, String tipoPonto) {
		if(_listaUsuariosMock.contains(u));{
			if(tipoPonto.equals("estrela"))
				return u.get_nome() + " " + u.get_pontosEstrela() + " estrela";
			if(tipoPonto.equals("moeda"))
				return u.get_nome() + " " + u.get_pontosMoeda() + " moeda";
		}
		throw new RuntimeException("Nome de usuário ou tipo de ponto inválido");
	}

	protected String retornarUsuarioComPontosMock() {
		String nomeUsuariosComPontos = "";
		for(Usuario u: _listaUsuariosMock)
		if(u.get_pontosEstrela() > 0 || u.get_pontosMoeda() > 0)
			nomeUsuariosComPontos += u.get_nome() + ", ";
		nomeUsuariosComPontos = nomeUsuariosComPontos.substring(0, nomeUsuariosComPontos.length() - 2);
		return nomeUsuariosComPontos;
	}

	protected String retornarTipoPontosMock(Usuario u) {
		if(_listaUsuariosMock.contains(u)){
		if(u.get_pontosEstrela() > 0 && u.get_pontosMoeda() > 0)
			return "estrela, moeda";
		if(u.get_pontosEstrela() > 0 && u.get_pontosMoeda() == 0)
			return "estrela";
		if(u.get_pontosEstrela() == 0 && u.get_pontosMoeda() > 0)
			return "moeda";
		}
		throw new RuntimeException("Usuario inexistente ou sem pontos");
	}
}
