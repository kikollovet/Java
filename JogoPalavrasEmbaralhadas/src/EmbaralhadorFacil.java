import java.io.FileNotFoundException;

public class EmbaralhadorFacil implements Embaralhador {

	@Override
	public String getPalavraEmbaralhada(String palavra) throws FileNotFoundException {
		int len = palavra.length();
	    char[] tempCharArray = new char[len];
	    char[] charArray = new char[len];
	    // put original string in an array of chars
	    for (int i = 0; i < len; i++) {
	      tempCharArray[i] = palavra.charAt(i);
	    }
	    // reverse array of chars
	    for (int j = 0; j < len; j++) {
	      charArray[j] = tempCharArray[len - 1 - j];
	    }
	    String reversePalavra = new String(charArray);
		
		return reversePalavra;
	}

}
