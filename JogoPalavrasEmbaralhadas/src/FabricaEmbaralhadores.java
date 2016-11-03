
public class FabricaEmbaralhadores {

	
	public Embaralhador getEmbaralhadorAleatorio(){
		double qualDosDois = Math.random() * 2;
		if(qualDosDois <= 1){
			return new EmbaralhadorFacil();
		} else{
			return new EmbaralhadorDificil();
		}
		
	}
}
