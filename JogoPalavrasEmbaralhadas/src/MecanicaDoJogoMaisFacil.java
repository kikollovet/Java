
public class MecanicaDoJogoMaisFacil implements MecanicaDoJogo {

	private int pontos = 0;
	private int vidas = 5;
	private int tentativas = 1;
	private FabricaEmbaralhadores embaralhador;

	@Override
	public String getDescricaoDoJogo() {
		return "Vc tem uma tentativas para acertar cada palavra embaralhada.\n"
				+ "Se vc errar, perde uma vida. Atenção, o seu número de vidas\n"
				+ "influência na pontuação! Mais vidas, mais pontos vc ganha por\n"
				+ "palavra! Boa sorte!\n"
				+ "================================================================";
	}

	@Override
	public String getPontos() {
		return "Seu score foi de " + pontos + " pontos!";
	}

	@Override
	public int getTentativas() {
		return tentativas;
	}

	@Override
	public void setEmbaralhador(FabricaEmbaralhadores embaralhador){
		this.embaralhador = embaralhador;
	}

	@Override
	public FabricaEmbaralhadores getEmbaralhador() {
		return this.embaralhador;
	}
	
	@Override
	public boolean fimDoJogo() {
		boolean fim = false;
		if(vidas == 0 && tentativas <=30)
			fim = true;
		return fim;
	}
	
	@Override
	public String acertou(String palavra, String resposta) {
		if(palavra.equals(resposta)){
			pontos = pontos + (10 * vidas);
			tentativas++;
			return "Acertou!\n========";
		} else {
			vidas--;
			return "Errou!";
		}
		
	}
	
}
