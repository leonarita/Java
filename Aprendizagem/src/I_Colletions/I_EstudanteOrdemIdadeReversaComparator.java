package I_Colletions;

import java.util.Comparator;

public class I_EstudanteOrdemIdadeReversaComparator implements Comparator<I_Estudante> {

	@Override
	public int compare(I_Estudante o1, I_Estudante o2) {
		return o2.getIdade() - o1.getIdade();
	}
}
