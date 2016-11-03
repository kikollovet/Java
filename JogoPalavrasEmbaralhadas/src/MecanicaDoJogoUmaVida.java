
public class MecanicaDoJogoUmaVida implements MecanicaDoJogo {
	
	private int pontos = 0;
	private int vidas = 1;
	private int tentativas = 1;
	private FabricaEmbaralhadores embaralhador;
	
	@Override
	public String getDescricaoDoJogo() {
		return "Vc só tem uma chance nesse jogo! A medida que for acertando uma nova\n"
				+ "palavra embaralhada aparece para vc tentar adivinhar. A primeira\n"
				+ "palavra vale 10 pontos, a segunda 20, a terceira 30 e assim sucetivamente.\n"
				+ "Errou, fim do jogo!\n"
				+ "==========================================================================";
		
		
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
	public void setEmbaralhador(FabricaEmbaralhadores embaralhador) {
		this.embaralhador = embaralhador;
		
	}

	@Override
	public FabricaEmbaralhadores getEmbaralhador() {
		return this.embaralhador;
	}

	@Override
	public boolean fimDoJogo() {
		boolean fim = false;
		if(vidas != 1 && tentativas <=30)
			fim = true;
		return fim;
	}

	@Override
	public String acertou(String palavra, String resposta) {
		if(palavra.equals(resposta)){
			pontos = pontos + (10 * tentativas);
			tentativas++;
			return "Acertou!\n========";
		} else {
			vidas--;
			return "Errou!";
		}
		
	}

	

}
