import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Placar {

	private List<Usuario> _listaDeUsuarios = new ArrayList<>();
	private List<String> _rankingEstrela = new ArrayList<>();
	private List<String> _rankingMoeda = new ArrayList<>();
	private List<String> _rankingEstrelaArquivo = new ArrayList<>();
	private List<String> _rankingMoedaArquivo = new ArrayList<>();
	private Armazenamento _armazenamentoArquivo;
	private boolean _mockLigado = false;

	protected void ligarMock(){
		_mockLigado = true;
	}
	
	public List<Usuario> get_listaDeUsuarios() {
		return _listaDeUsuarios;
	}

	
	public Armazenamento get_armazenamentoArquivo() {
		return _armazenamentoArquivo;
	}


	protected void adicionaUsuarioALista(Usuario u) {
		_listaDeUsuarios.add(u);
	}

	protected Usuario retornaUsuario(Usuario u) {
		if (_listaDeUsuarios.contains(u))
			return u;
		throw new RuntimeException("Usuário não existe");
	}

	protected void criarTopico(Usuario u) throws IOException {
		int pontosEstrela = 0;
		if (_armazenamentoArquivo != null  && !_mockLigado) {
			_armazenamentoArquivo.armazenaPontos(u.get_nome(), "estrela", 15);
		}
		if (_mockLigado && _armazenamentoArquivo != null) {
			_armazenamentoArquivo.registroTotalPontosEstrelaMock(u, 15);
		}

		if (_armazenamentoArquivo == null && _listaDeUsuarios.contains(u)) {
			pontosEstrela = u.get_pontosEstrela() + 15;
			u.set_pontosEstrela(pontosEstrela);
		}
	}

	protected void fazerComentario(Usuario u) throws IOException {
		int pontosMoeda = 0;
		if (_armazenamentoArquivo != null && !_mockLigado) {
			_armazenamentoArquivo.armazenaPontos(u.get_nome(), "moeda", 10);
		}
		if (_mockLigado && _armazenamentoArquivo != null) {
			_armazenamentoArquivo.registroTotalPontosMoedaMock(u, 10);
		}

		if (_listaDeUsuarios.contains(u) && _armazenamentoArquivo == null) {
			pontosMoeda = u.get_pontosMoeda() + 10;
			u.set_pontosMoeda(pontosMoeda);
		}
	}

	protected void darCurtida(Usuario u) throws IOException {
		int pontosEstrela = 0;
		int pontosMoeda = 0;
		if (_armazenamentoArquivo != null && !_mockLigado) {
			_armazenamentoArquivo.armazenaPontos(u.get_nome(), "moeda", 5);
			_armazenamentoArquivo.armazenaPontos(u.get_nome(), "estrela", 5);

		}
		if (_mockLigado && _armazenamentoArquivo != null) {
			_armazenamentoArquivo.registroTotalPontosEstrelaMock(u, 5);
			_armazenamentoArquivo.registroTotalPontosMoedaMock(u, 5);
		}
		if (_listaDeUsuarios.contains(u) && _armazenamentoArquivo == null) {
			pontosMoeda = u.get_pontosMoeda() + 5;
			u.set_pontosMoeda(pontosMoeda);
			pontosEstrela = u.get_pontosEstrela() + 5;
			u.set_pontosEstrela(pontosEstrela);
		}
	}

	protected String retornarPontuacaoTotalUsuario(Usuario u) {
		if (_listaDeUsuarios.contains(u))
			if (u.get_pontosEstrela() > 0 && u.get_pontosMoeda() > 0)
				return u.get_pontosEstrela() + " estrela, " + u.get_pontosMoeda() + " moeda";
		if (u.get_pontosEstrela() == 0 && u.get_pontosMoeda() > 0)
			return u.get_pontosMoeda() + " moeda";
		if (u.get_pontosEstrela() > 0 && u.get_pontosMoeda() == 0)
			return u.get_pontosEstrela() + " estrela";
		throw new RuntimeException("Usuário não existe");
	}
	
	protected String retornarPontuacaoTotalUsuarioUsandoMock(Usuario u) {
		if (_armazenamentoArquivo.get_listaUsuariosMock().contains(u))
			if (u.get_pontosEstrela() > 0 && u.get_pontosMoeda() > 0)
				return u.get_pontosEstrela() + " estrela, " + u.get_pontosMoeda() + " moeda";
		if (u.get_pontosEstrela() == 0 && u.get_pontosMoeda() > 0)
			return u.get_pontosMoeda() + " moeda";
		if (u.get_pontosEstrela() > 0 && u.get_pontosMoeda() == 0)
			return u.get_pontosEstrela() + " estrela";
		throw new RuntimeException("Usuário não existe");
	}

	protected List<String> verRankingEstrela() {
		_rankingEstrela.clear();
		if (_armazenamentoArquivo != null) {
			Collections.sort(_armazenamentoArquivo.get_listaUsuariosMock(), new ComparadorEstrela());
			for (Usuario u : _armazenamentoArquivo.get_listaUsuariosMock()) {
				if (u.get_pontosEstrela() > 0)
					_rankingEstrela.add(u.get_nome() + " " + u.get_pontosEstrela());
			}
		} else {
			Collections.sort(_listaDeUsuarios, new ComparadorEstrela());
			for (Usuario u : _listaDeUsuarios) {
				if (u.get_pontosEstrela() > 0)
					_rankingEstrela.add(u.get_nome() + " " + u.get_pontosEstrela());
			}
		}
		return _rankingEstrela;
	}

	protected List<String> verRankingMoeda() {
		_rankingMoeda.clear();
		if (_armazenamentoArquivo != null) {
			Collections.sort(_armazenamentoArquivo.get_listaUsuariosMock(), new ComparadorMoeda());
			for (Usuario u : _armazenamentoArquivo.get_listaUsuariosMock()) {
				if (u.get_pontosMoeda() > 0)
					_rankingMoeda.add(u.get_nome() + " " + u.get_pontosMoeda());
			}
		} else {
			Collections.sort(_listaDeUsuarios, new ComparadorMoeda());
			for (Usuario u : _listaDeUsuarios) {
				if (u.get_pontosMoeda() > 0)
					_rankingMoeda.add(u.get_nome() + " " + u.get_pontosMoeda());
			}
		}
		return _rankingMoeda;
	}
	
	protected List<String> verRankingEstrelaArquivo() {
		_rankingEstrelaArquivo.clear();
			Collections.sort(_armazenamentoArquivo.get_listaDeUsuariosPontosEstrela(), new ComparadorEstrela());
			for (Usuario u : _armazenamentoArquivo.get_listaDeUsuariosPontosEstrela()) {
				if (u.get_pontosEstrela() > 0)
					_rankingEstrelaArquivo.add(u.get_nome() + " " + u.get_pontosEstrela());
			}
		 
		return _rankingEstrelaArquivo;
	}
	
	protected List<String> verRankingMoedaArquivo() {
		_rankingMoedaArquivo.clear();
			Collections.sort(_armazenamentoArquivo.get_listaDeUsuariosPontosMoeda(), new ComparadorMoeda());
			for (Usuario u : _armazenamentoArquivo.get_listaDeUsuariosPontosMoeda()) {
				if (u.get_pontosMoeda() > 0)
					_rankingMoedaArquivo.add(u.get_nome() + " " + u.get_pontosMoeda());
			}
		 
		return _rankingMoedaArquivo;
	}



	protected void adicionaArmazenamentoArquivo(Armazenamento arm) {
		this._armazenamentoArquivo = arm;
	}

}
