
public class EstacaoEspacialBrasil {

	BaseMarte baseMarte;
	
	public void conectarPodUm(Pod pod){
		try {
			haConexaoComBaseMarte();
			baseMarte.conectarPodUm(pod);
		} catch (SemConexaoComBaseMarteException e) {
			e.printStackTrace();
		}
	}
	
	public void conectarPodDois(Pod pod2){
		try {
			haConexaoComBaseMarte();
			baseMarte.conectarPodDois(pod2);
		} catch (SemConexaoComBaseMarteException e) {
			e.printStackTrace();
		}
	}
	
	public void conectarBaseMarte(BaseMarte baseMarte){
		this.baseMarte = baseMarte;
	}
	
	public void comandoMoverPodNorte(int distanciaPes, Pod pod){
		try {
			haConexaoComBaseMarte();
			baseMarte.moverPodNorte(distanciaPes, pod);
		} catch (SemConexaoComBaseMarteException e) {
			e.printStackTrace();
		}
	}
	
	public void comandoMoverPodSul(int distanciaPes, Pod pod){
		try {
			haConexaoComBaseMarte();
			baseMarte.moverPodSul(distanciaPes, pod);
		} catch (SemConexaoComBaseMarteException e) {
			e.printStackTrace();
		}
	}
	
	public void comandoMoverPodLeste(int distanciaPes, Pod pod){
		try {
			haConexaoComBaseMarte();
			baseMarte.moverPodLeste(distanciaPes, pod);
		} catch (SemConexaoComBaseMarteException e) {
			e.printStackTrace();
		}
	}
	
	public void comandoMoverPodOeste(int distanciaPes, Pod pod){
		try {
			haConexaoComBaseMarte();
			baseMarte.moverPodOeste(distanciaPes, pod);
		} catch (SemConexaoComBaseMarteException e) {
			e.printStackTrace();
		}
	}
	
	public void mostraLocalEDistanciaPod(Pod pod){
		try {
			haConexaoComBaseMarte();
			baseMarte.mostraLocalEDistanciaPod(pod);
		} catch (SemConexaoComBaseMarteException e) {
			e.printStackTrace();
		}
	}
	
	public void mostraCaminhoPercorridoPod(Pod pod){
		try {
			haConexaoComBaseMarte();
			baseMarte.mostraCaminhoPercorridoPod(pod);
		} catch (SemConexaoComBaseMarteException e) {
			e.printStackTrace();
		}
	}

	public void haConexaoComBaseMarte() throws SemConexaoComBaseMarteException{
		if(this.baseMarte == null)
			throw new SemConexaoComBaseMarteException("Sem conexão com a base em Marte");
	}
}
