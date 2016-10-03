import java.util.Comparator;

public class ComparadorEstrela implements Comparator<Usuario> {

	@Override
	public int compare(Usuario um, Usuario dois) {
		if (um.get_pontosEstrela() > dois.get_pontosEstrela()) {
            return -1;
        }
        if (um.get_pontosEstrela() < dois.get_pontosEstrela()) {
            return 1;
        }
		return 0;
	}

}
