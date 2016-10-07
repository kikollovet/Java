import java.util.ArrayList;
import java.util.List;

public class Pizzaria {

	private List<Cliente> _listaClientes = new ArrayList<>();
	private String _nome;
	private CarrinhoDeCompra _cp;
	
	public Pizzaria(String nome){
		this._nome = nome;
	}

	public String get_nome() {
		return _nome;
	}

	
	public CarrinhoDeCompra get_cp() {
		return _cp;
	}

	public void set_cp(CarrinhoDeCompra _cp) {
		this._cp = _cp;
	}

	public List<Cliente> get_listaClientes() {
		return _listaClientes;
	}
	
	public void adicionaCliente(Cliente cliente){
		_listaClientes.add(cliente);
	}
}
