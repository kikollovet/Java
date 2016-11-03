
public class FabricaMecanicaDoJogo {

	
	
	public static MecanicaDoJogo selecionaMecanicaDoJogo(int i){
		if(i == 1){
			return new MecanicaDoJogoMaisFacil();
		} else {
			return new MecanicaDoJogoUmaVida();
		}
		
	}
}
