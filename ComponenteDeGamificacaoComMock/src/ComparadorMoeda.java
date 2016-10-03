import java.util.Comparator;

public class ComparadorMoeda implements Comparator<Usuario> {


	@Override
	public int compare(Usuario um, Usuario dois) {
		if (um.get_pontosMoeda() > dois.get_pontosMoeda()) {
            return -1;
        }
        if (um.get_pontosMoeda() < dois.get_pontosMoeda()) {
            return 1;
        }
		return 0;
	}

}
