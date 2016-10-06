import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private List<Funcionario> _listaFuncionarios = new ArrayList<>();

	public List<Funcionario> get_listaFuncionarios() {
		return _listaFuncionarios;
	}
	
	public boolean usuarioJaCadastrado(String nome){
		for(Funcionario funcionario: _listaFuncionarios){
			if(funcionario.get_nome().equals(nome)){
				return true;
			}
		}
		return false;
	}
}
