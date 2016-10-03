
public class Produto {

	protected String nome;
	protected int codigo;
	protected int preco;
	
	public Produto(String nome, int codigo, int preco) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
}
