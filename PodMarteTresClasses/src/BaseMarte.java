
public class BaseMarte {

	private Pod pod;
	private Pod pod2;
	
	public void conectarPodUm(Pod pod){
		this.pod = pod;
	}
	
	public void conectarPodDois(Pod pod2){
		this.pod2 = pod2;
	}
	
	public void moverPodNorte(int distanciaPes, Pod pod){
		try{
			oPodEstaConectadoABaseMarte(pod);
			distanciaMaximaPorComando(distanciaPes, pod);
			alcanceRadar(pod);
			pod.setPrevisaoDistNorteSul(pod.getPrevisaoDistNorteSul() + distanciaPes);
			if(this.pod != null && this.pod2 != null)
				verificaPodNoMesmoLocal();
			pod.moverPodNorte(distanciaPes);
			pod.getRelatorioTrechoPercorrido().add("O " + pod.getNome() + " se moveu " + distanciaPes + " p�s na dire��o Norte");
			alcanceRadar(pod);
			avisoLimiteRadar(pod);
		} catch (ForaDoAlcanceDoRadarException e){
			e.printStackTrace();
		} catch (MaximaDistanciaPorComandoPermitidaException e){
			e.printStackTrace();
		} catch (AvisoLimiteRadarException e) {
			e.printStackTrace();
		} catch (PodMesmoLugarException e) {
			pod.setPrevisaoDistNorteSul(pod.getPrevisaoDistNorteSul() - distanciaPes);
			e.printStackTrace();
		} catch (PodNaoConectadoABaseMarteException e) {
			e.printStackTrace();
		}
	}
	
	public void moverPodSul(int distanciaPes, Pod pod){
		try{
			oPodEstaConectadoABaseMarte(pod);
			distanciaMaximaPorComando(distanciaPes, pod);
			alcanceRadar(pod);
			pod.setPrevisaoDistNorteSul(pod.getPrevisaoDistNorteSul() - distanciaPes);
			if(this.pod != null && this.pod2 != null)
				verificaPodNoMesmoLocal();
			pod.moverPodSul(distanciaPes);
			pod.getRelatorioTrechoPercorrido().add("O " + pod.getNome() + " se moveu " + distanciaPes + " p�s na dire��o Sul");
			alcanceRadar(pod);
			avisoLimiteRadar(pod);
		} catch (ForaDoAlcanceDoRadarException e){
			e.printStackTrace();
		} catch (MaximaDistanciaPorComandoPermitidaException e){
			e.printStackTrace();
		} catch (AvisoLimiteRadarException e) {
			e.printStackTrace();
		} catch (PodMesmoLugarException e) {
			pod.setPrevisaoDistNorteSul(pod.getPrevisaoDistNorteSul() + distanciaPes);
			e.printStackTrace();
		} catch (PodNaoConectadoABaseMarteException e) {
			e.printStackTrace();
		}
	}
	
	public void moverPodLeste(int distanciaPes, Pod pod){
		try{
			oPodEstaConectadoABaseMarte(pod);
			distanciaMaximaPorComando(distanciaPes, pod);
			alcanceRadar(pod);
			pod.setPrevisaoDistLesteOeste(pod.getPrevisaoDistLesteOeste() + distanciaPes);
			if(this.pod != null && this.pod2 != null)	
				verificaPodNoMesmoLocal();
			pod.moverPodLeste(distanciaPes);
			pod.getRelatorioTrechoPercorrido().add("O " + pod.getNome() + " se moveu " + distanciaPes + " p�s na dire��o Leste");
			alcanceRadar(pod);
			avisoLimiteRadar(pod);
		} catch (ForaDoAlcanceDoRadarException e){
			e.printStackTrace();
		} catch (MaximaDistanciaPorComandoPermitidaException e){
			e.printStackTrace();
		} catch (AvisoLimiteRadarException e) {
			e.printStackTrace();
		} catch (PodMesmoLugarException e) {
			pod.setPrevisaoDistLesteOeste(pod.getPrevisaoDistLesteOeste() - distanciaPes);
			e.printStackTrace();
		} catch (PodNaoConectadoABaseMarteException e) {
			e.printStackTrace();
		}
	}
	
	public void moverPodOeste(int distanciaPes, Pod pod){
		try{
			oPodEstaConectadoABaseMarte(pod);
			distanciaMaximaPorComando(distanciaPes, pod);
			alcanceRadar(pod);
			pod.setPrevisaoDistLesteOeste(pod.getPrevisaoDistLesteOeste() - distanciaPes);
			if(this.pod != null && this.pod2 != null)
				verificaPodNoMesmoLocal();
			pod.moverPodOeste(distanciaPes);
			pod.getRelatorioTrechoPercorrido().add("O " + pod.getNome() + " se moveu " + distanciaPes + " p�s na dire��o Oeste");
			alcanceRadar(pod);
			avisoLimiteRadar(pod);
		} catch (ForaDoAlcanceDoRadarException e){
			e.printStackTrace();
		} catch (MaximaDistanciaPorComandoPermitidaException e){
			e.printStackTrace();
		} catch (AvisoLimiteRadarException e) {
			e.printStackTrace();
		} catch (PodMesmoLugarException e) {
			pod.setPrevisaoDistLesteOeste(pod.getPrevisaoDistLesteOeste() + distanciaPes);
			e.printStackTrace();
		} catch (PodNaoConectadoABaseMarteException e) {
			e.printStackTrace();
		}
	}
	
	public void alcanceRadar(Pod pod) throws ForaDoAlcanceDoRadarException{
		if(calcularDistanciaPodDoPontoZero(pod) > 5)
			throw new ForaDoAlcanceDoRadarException(pod.getNome() + " fora do alcance do radar");
	}
	
	public void distanciaMaximaPorComando(int distanciaPes, Pod pod) throws MaximaDistanciaPorComandoPermitidaException{
		if(distanciaPes > 1 || distanciaPes < 0)
			throw new MaximaDistanciaPorComandoPermitidaException(pod.getNome() + " s� pode receber comandos de 1 p� por vez");
	}
	
	public void avisoLimiteRadar(Pod pod) throws AvisoLimiteRadarException{
		if(calcularDistanciaPodDoPontoZero(pod) <= 5 && calcularDistanciaPodDoPontoZero(pod) >= 4)
			throw new AvisoLimiteRadarException(pod.getNome() + " est� a dist�ncia de " + calcularDistanciaPodDoPontoZero(pod)  + 
					" p�s da base. O limite de alcance do radar � 5 p�s!");
	}
	
	public double calcularDistanciaPodDoPontoZero(Pod pod){
		return Math.sqrt((pod.getTrechoNorteSul()*pod.getTrechoNorteSul()+pod.getTrechoLesteOeste()*pod.getTrechoLesteOeste()));
	}
	
	public void verificaPodNoMesmoLocal() throws PodMesmoLugarException{
		if(this.pod.getPrevisaoDistNorteSul() != 0 || this.pod.getPrevisaoDistLesteOeste()!= 0 || this.pod2.getPrevisaoDistNorteSul() != 0 || this.pod2.getPrevisaoDistLesteOeste() != 0){
			if(this.pod.getPrevisaoDistNorteSul() == this.pod2.getPrevisaoDistNorteSul() && this.pod.getPrevisaoDistLesteOeste() == this.pod2.getPrevisaoDistLesteOeste())
				throw new PodMesmoLugarException("Dois pods n�o podem ocupar o mesmo espa�o");
		}
	}
	
	public void mostraLocalEDistanciaPod(Pod pod){
		try {
			oPodEstaConectadoABaseMarte(pod);
			alcanceRadar(pod);
			if(pod.getTrechoNorteSul() > 0 && pod.getTrechoLesteOeste() == 0)
				System.out.println("O " + pod.getNome() + " est� a " + calcularDistanciaPodDoPontoZero(pod) + " p�s ao norte da base.");
			if(pod.getTrechoNorteSul() > 0 && pod.getTrechoLesteOeste() > 0)
				System.out.println("O " + pod.getNome() + " est� a " + calcularDistanciaPodDoPontoZero(pod) + " p�s entre norte e leste da base.");
			if(pod.getTrechoNorteSul() == 0 && pod.getTrechoLesteOeste() > 0)
				System.out.println("O " + pod.getNome() + " est� a " + calcularDistanciaPodDoPontoZero(pod) + " p�s a leste da base.");
			if(pod.getTrechoNorteSul() < 0 && pod.getTrechoLesteOeste() > 0)
				System.out.println("O " + pod.getNome() + " est� a " + calcularDistanciaPodDoPontoZero(pod) + " p�s entre sul e leste da base.");
			if(pod.getTrechoNorteSul() < 0 && pod.getTrechoLesteOeste() == 0)
				System.out.println("O " + pod.getNome() + " est� a " + calcularDistanciaPodDoPontoZero(pod) + " p�s ao sul da base.");
			if(pod.getTrechoNorteSul() < 0 && pod.getTrechoLesteOeste() < 0)
				System.out.println("O " + pod.getNome() + " est� a " + calcularDistanciaPodDoPontoZero(pod) + " p�s entre sul e oeste da base.");
			if(pod.getTrechoNorteSul() == 0 && pod.getTrechoLesteOeste() < 0)
				System.out.println("O " + pod.getNome() + " est� a " + calcularDistanciaPodDoPontoZero(pod) + " p�s a oeste da base.");
			if(pod.getTrechoNorteSul() > 0 && pod.getTrechoLesteOeste() < 0)
				System.out.println("O " + pod.getNome() + " est� a " + calcularDistanciaPodDoPontoZero(pod) + " p�s entre entre norte e oeste da base.");
			if(pod.getTrechoNorteSul() == 0 && pod.getTrechoLesteOeste() == 0)
				System.out.println("O " + pod.getNome() + " se encontra na base.");
		} catch (ForaDoAlcanceDoRadarException e){
			System.err.println("Imposs�vel mostrar a dist�ncia exata do " + pod.getNome() + ""
					+ " pois ele est� fora do alcance do radar! O relat�rio mostra o registro do primeiro at�"
					+ " o �ltimo comando que o " + pod.getNome() + " recebeu antes de ficar fora do alcance do radar!");
			e.printStackTrace();
		} catch (PodNaoConectadoABaseMarteException e) {
			e.printStackTrace();
		}
	}
	
	public void mostraCaminhoPercorridoPod(Pod pod){
		
			System.out.println("Mostrando caminho percorrido do " + pod.getNome());
			for(String trecho: pod.getRelatorioTrechoPercorrido()){
			System.out.println(trecho);
			}
			mostraLocalEDistanciaPod(pod);
	}
	
	public boolean oPodEstaConectadoABaseMarte(Pod pod) throws PodNaoConectadoABaseMarteException{
		if(this.pod == pod || this.pod2 == pod)
			return true;
		throw new PodNaoConectadoABaseMarteException("O " + pod.getNome() + " n�o est� conectado a base em Marte.");
	}
}
