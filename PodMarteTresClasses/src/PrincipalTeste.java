
public class PrincipalTeste {

	public static void main(String[] args) {
		Pod pod = new Pod();
		Pod pod2 = new Pod();
		pod.setNome("Pod Um");
		pod2.setNome("Pod dois");
		BaseMarte bm = new BaseMarte();
		EstacaoEspacialBrasil eeb = new EstacaoEspacialBrasil();
		eeb.conectarBaseMarte(bm);
		eeb.conectarPodUm(pod);
		eeb.conectarPodDois(pod2);
		eeb.comandoMoverPodLeste(1, pod);
		eeb.comandoMoverPodNorte(1, pod);
		eeb.comandoMoverPodOeste(1, pod);
		eeb.comandoMoverPodOeste(1, pod2);
		eeb.comandoMoverPodNorte(1, pod2);
		eeb.comandoMoverPodLeste(1, pod2);
		eeb.comandoMoverPodLeste(1, pod2);
		eeb.mostraCaminhoPercorridoPod(pod);
		eeb.mostraCaminhoPercorridoPod(pod2);
		System.out.println(pod.getPrevisaoDistNorteSul() + " " + pod.getPrevisaoDistLesteOeste());
		System.out.println(pod2.getPrevisaoDistNorteSul() + " " + pod2.getPrevisaoDistLesteOeste());
		
	}

}
