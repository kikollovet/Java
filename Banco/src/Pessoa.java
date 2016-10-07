
public class Pessoa {

	private String _nome;
	private String _CPF;
	private Conta _tipoConta;
	
	public Pessoa(String nome, String CPF, Conta tipoConta){
		this._nome = nome;
		this._CPF = CPF;
		this._tipoConta = tipoConta;
	}
	
	public Pessoa(){
		
	}
	
	public String get_nome() {
		return _nome;
	}
	public void set_nome(String nome) {
		_nome = nome;
	}
	public String get_CPF() {
		return _CPF;
	}
	public void set_CPF(String cPF) {
		_CPF = cPF;
	}

	public Conta get_tipoConta() {
		return _tipoConta;
	}

	public void set_tipoConta(Conta _tipoConta) {
		this._tipoConta = _tipoConta;
	}
}
