
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException {

		Scanner ler = new Scanner(System.in);
		int opcaoDeJogo;
		System.out.println("Qual a opção de jogo? Digite abaixo 1 para fácil e 2 para survival!");
		System.out.println("============================================================");
		opcaoDeJogo = ler.nextInt();

		while (opcaoDeJogo != 1 && opcaoDeJogo != 2) {
			System.out.println("Opção inválida! Digite novamente! 1 para fácil e 2 para survival!");
			System.out.println("==================================================================");
			opcaoDeJogo = ler.nextInt();
			if (opcaoDeJogo == 1 || opcaoDeJogo == 2) {
				break;
			}
		}
		MecanicaDoJogo mj = FabricaMecanicaDoJogo.selecionaMecanicaDoJogo(1);
		if (opcaoDeJogo == 1) {
			mj = FabricaMecanicaDoJogo.selecionaMecanicaDoJogo(1);
		}
		if (opcaoDeJogo == 2) {
			mj = FabricaMecanicaDoJogo.selecionaMecanicaDoJogo(2);
		}
		System.out.println(mj.getDescricaoDoJogo());
		while (!mj.fimDoJogo()) {
			String palavra = BancoDePalavra.getPalavraAleatoria();
			mj.setEmbaralhador(new FabricaEmbaralhadores());
			String desafio = mj.getEmbaralhador().getEmbaralhadorAleatorio().getPalavraEmbaralhada(palavra);
			System.out.println("A palavra embaralhada é: " + desafio);
			System.out.println("Escreva ela na ordem correta abaixo");
			Scanner in = new Scanner(System.in);
			System.out.println("====================================");
			String resposta = in.nextLine();
			System.out.println(mj.acertou(palavra, resposta));
		}
		System.out.println("Fim de jogo!");
		if (opcaoDeJogo == 2) {
			System.out.println("Vc conseguiu acertar " + (mj.getTentativas() - 1) + " palavras na sequência");
		}
		System.out.println(mj.getPontos());
	}

}
