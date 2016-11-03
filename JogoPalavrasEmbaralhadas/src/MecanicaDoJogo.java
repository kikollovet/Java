
public interface MecanicaDoJogo {
	
	public String getDescricaoDoJogo();
	
	public String getPontos();
	
	public int getTentativas();
	
	public void setEmbaralhador(FabricaEmbaralhadores embaralhador);
	
	public FabricaEmbaralhadores getEmbaralhador();
	
	public boolean fimDoJogo();
	
	public String acertou(String palavra, String resposta);
	
}
