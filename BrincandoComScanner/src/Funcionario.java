
public class Funcionario extends Pessoa {

	private int _salario;
	private String _cargo;
	
	public Funcionario(String _nome, String _cpf, int _salario, String _cargo) {
		super(_nome, _cpf);
		this._salario = _salario;
		this._cargo = _cargo;
	}

	public int get_salario() {
		return _salario;
	}

	public void set_salario(int _salario) {
		this._salario = _salario;
	}

	public String get_cargo() {
		return _cargo;
	}

	public void set_cargo(String _cargo) {
		this._cargo = _cargo;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.get_nome() + "\nCPF: " + this.get_cpf() +
				"\nSalário: R$" + this.get_salario() + ",00\nCargo: " + this.get_cargo();
	}
	
}
