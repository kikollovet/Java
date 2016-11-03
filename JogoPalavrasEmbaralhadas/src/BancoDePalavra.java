import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class BancoDePalavra {


	public static String getPalavraAleatoria() throws FileNotFoundException{
		InputStream is = new FileInputStream("palavrasJogo.txt");
		Scanner entrada = new Scanner(is);
		double qualquer = Math.random() * 30;
		while(qualquer < 29){
		entrada.nextLine();
		qualquer++;
		}
		return entrada.nextLine();
		
	}
}
