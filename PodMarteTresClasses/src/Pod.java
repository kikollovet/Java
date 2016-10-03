import java.util.ArrayList;
import java.util.List;

public class Pod {

	private String nome;
	private int trechoNorteSul;
	private int trechoLesteOeste;
	private List<String> relatorioTrechoPercorrido = new ArrayList<>();
	private int previsaoDistNorteSul;
	private int previsaoDistLesteOeste;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTrechoNorteSul() {
		return trechoNorteSul;
	}
	
	public void setTrechoNorteSul(int trechoNorteSul) {
		this.trechoNorteSul = trechoNorteSul;
	}
	
	public int getTrechoLesteOeste() {
		return trechoLesteOeste;
	}
	
	public void setTrechoLesteOeste(int trechoLesteOeste) {
		this.trechoLesteOeste = trechoLesteOeste;
	}
	
	public List<String> getRelatorioTrechoPercorrido() {
		return relatorioTrechoPercorrido;
	}
	
	

	public int getPrevisaoDistNorteSul() {
		return previsaoDistNorteSul;
	}

	public void setPrevisaoDistNorteSul(int previsaoDistNorteSul) {
		this.previsaoDistNorteSul = previsaoDistNorteSul;
	}

	public int getPrevisaoDistLesteOeste() {
		return previsaoDistLesteOeste;
	}

	public void setPrevisaoDistLesteOeste(int previsaoDistLesteOeste) {
		this.previsaoDistLesteOeste = previsaoDistLesteOeste;
	}

	public void moverPodNorte(int distanciaPes){
		int distancia = this.trechoNorteSul + distanciaPes;
		setTrechoNorteSul(distancia);
		System.out.println("O " + nome + " se moveu " + distanciaPes + " pés na direção norte.");
	}
	
	public void moverPodSul(int distanciaPes){
		int distancia = this.trechoNorteSul - distanciaPes;
		setTrechoNorteSul(distancia);
		System.out.println("O " + nome + " se moveu " + distanciaPes + " pés na direção sul.");
	}
	
	public void moverPodLeste(int distanciaPes){
		int distancia = this.trechoLesteOeste + distanciaPes;
		setTrechoLesteOeste(distancia);
		System.out.println("O " + nome + " se moveu " + distanciaPes + " pés na direção Leste.");
	}
	
	public void moverPodOeste(int distanciaPes){
		int distancia = this.trechoLesteOeste - distanciaPes;
		setTrechoLesteOeste(distancia);
		System.out.println("O " + nome + " se moveu " + distanciaPes + " pés na direção Oeste.");
	}
	
	

}
