import java.util.Random;

public class ContaCorrente implements Conta {

	private int _senha;
	private int _numeroConta;
	private int _saldo;
	
	public ContaCorrente(){
		Random gerador = new Random();
		this._senha = gerador.nextInt(25);
	}
	
	
	@Override
	public void saca(int valor){
		try {
			limiteSaquePorVez(valor);
			valorSaquePermitido(valor);
			this._saldo -= valor;
		} catch (SaldoInsuficienteException e) {
			System.out.println("Saldo Insuficiente, você está ultrapassando os R$1000,00 de crédito.\n"
					+ "Você só pode retirar R$" + (this._saldo + 1000) + ",00");
		} catch (LimiteSaquePorVezException e) {
			System.out.println("Você só pode sacar R$1000,00 por vez.");
		}
	}

	@Override
	public void deposita(int valor){
		this._saldo += valor;
	}

	@Override
	public int get_saldo() {
		return _saldo;
	}

	@Override
	public int get_numeroConta(){
		return _numeroConta;
	}


	@Override
	public boolean valorSaquePermitido(int valor) throws SaldoInsuficienteException {
		if(valor > this._saldo + 1000) 
			throw new SaldoInsuficienteException("Saldo Insuficiente");
		return true;

	}


	@Override
	public boolean limiteSaquePorVez(int valor) throws LimiteSaquePorVezException {
		if(valor > 1000)
			throw new LimiteSaquePorVezException("O seu limite de saque por vez é R$1000,00");
		return true;
	}


	@Override
	public int get_senha() {
		return _senha;
	}


	@Override
	public void set_senha(int senha) {
		this._senha = senha;
	}
}
