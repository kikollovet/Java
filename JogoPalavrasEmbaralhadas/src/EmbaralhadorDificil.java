import java.io.FileNotFoundException;
import java.util.Random;

public class EmbaralhadorDificil implements Embaralhador {

	@Override
	public String getPalavraEmbaralhada(String palavra) throws FileNotFoundException {
		
		Random r = new Random();
    	StringBuilder org = new StringBuilder(palavra);
    	StringBuilder fim = new StringBuilder();    	
    	int tamanho = org.length();
    	for (int i=0;i<tamanho;i++) {
    		int rch = r.nextInt(org.length());
    		fim.append(org.charAt(rch));
    		org = org.deleteCharAt(rch);
    	}    	
    	return fim.toString();
		
	}

}
