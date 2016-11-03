import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class TesteEmbaralhadores {

	@Test
	public void testEmbaralhadorFacil() throws FileNotFoundException {
		EmbaralhadorFacil ef = new EmbaralhadorFacil();
		assertEquals(ef.getPalavraEmbaralhada("tudo"), "odut");
		}
	
	@Test
	public void testEmbaralhadorFacilDois() throws FileNotFoundException {
		EmbaralhadorFacil ef = new EmbaralhadorFacil();
		assertNotEquals(ef.getPalavraEmbaralhada("imagem"), "imagem");
		}
	
	@Test
	public void testEmbaralhadorDificil() throws FileNotFoundException {
		EmbaralhadorDificil ed = new EmbaralhadorDificil();
		assertNotEquals(ed.getPalavraEmbaralhada("antes"), "antes");
		}

}
