import java.util.ArrayList;
import java.util.List;

public class Pizza {

	private List<Ingrediente> _ingredientes = new ArrayList<>();
	private int _qtdIngrediente;
	private String _nome;
	
	public Pizza(String nome){
		this._nome = nome;
	}
	
	public String get_nome(){
		return this._nome;
	}
	public void adicionaIngrediente(Ingrediente ingrediente){
		_ingredientes.add(ingrediente);
		_qtdIngrediente++;
	}
	
	public void ingredientesUsados(){
		System.out.println("Foram usados " + _qtdIngrediente + " ingredientes na pizza"
				+ ", são eles:");
		for(Ingrediente i: _ingredientes){
			System.out.println(i.get_nome());
		}
	}

	public int get_qtdIngrediente() {
		return _qtdIngrediente;
	}
	
	public int get_preco(){
		if(_qtdIngrediente <= 2)
			return 17;
		if(_qtdIngrediente >= 3 && _qtdIngrediente <= 5)
			return 21;
		return 25;
	}
	
}
