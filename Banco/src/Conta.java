
public interface Conta {

	public void saca(int valor);
	
	public void deposita(int valor);
	
	public int get_saldo();
	
	public int get_numeroConta();
	
	public boolean valorSaquePermitido(int valor) throws SaldoInsuficienteException;
	
	public boolean limiteSaquePorVez(int valor) throws LimiteSaquePorVezException;
	
	public int get_senha();
	
	public void set_senha(int senha);
}
