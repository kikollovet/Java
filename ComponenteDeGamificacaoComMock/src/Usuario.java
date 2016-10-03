
public class Usuario implements Comparable<Usuario>{

	private String _nome;
	private int _pontosEstrela;
	private int _pontosMoeda;

	
	public Usuario(String nome){
		this._nome = nome;
	}

	public String get_nome() {
		return _nome;
	}

	public int get_pontosEstrela() {
		return _pontosEstrela;
	}

	public int get_pontosMoeda() {
		return _pontosMoeda;
	}

	public void set_pontosEstrela(int _pontosEstrela) {
		this._pontosEstrela = _pontosEstrela;
	}

	public void set_pontosMoeda(int _pontosMoeda) {
		this._pontosMoeda = _pontosMoeda;
	}
	
	@Override
	public int compareTo(Usuario u) {
		if (this._pontosEstrela > u._pontosEstrela) {
            return -1;
        }
        if (this._pontosEstrela < u._pontosEstrela) {
            return 1;
        }
        return 0;
		
	}
	
	
	
}
