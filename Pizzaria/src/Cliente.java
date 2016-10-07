
public class Cliente {

	private String _nome;
	private String _telefone;
	private String _endereco;
	
	public Cliente(String nome, String telefone, String endereco){
		this._nome = nome;
		this._telefone = telefone;
		this._endereco = endereco;
	}
	
	public Cliente(){
		
	}

	public String get_nome() {
		return _nome;
	}

	public void set_nome(String _nome) {
		this._nome = _nome;
	}

	public String get_telefone() {
		return _telefone;
	}

	public void set_telefone(String _telefone) {
		this._telefone = _telefone;
	}

	public String get_endereco() {
		return _endereco;
	}

	public void set_endereco(String _endereco) {
		this._endereco = _endereco;
	}
	
	public String toString(){
		return "Nome: " + _nome + "\nEndereço: " + _endereco;
	}
}
