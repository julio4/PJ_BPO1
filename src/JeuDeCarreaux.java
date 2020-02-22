import java.util.ArrayList;

public class JeuDeCarreaux {
	
	private ArrayList<Carreau> jdc;
	Type type;
	
	public JeuDeCarreaux(Type type) {
		switch(type) {
		case NEUTRE:
			jdc.add(new Carreau('x', 1, 3));
		case BLEU:
			jdc.add(new Carreau('a', 1, 1));
			jdc.add(new Carreau('b', 1, 2));
			jdc.add(new Carreau('c', 2, 1));
			jdc.add(new Carreau('d', 2, 2));
			jdc.add(new Carreau('e', 1, 3));
			jdc.add(new Carreau('f', 3, 1));
			jdc.add(new Carreau('g', 2, 3));
			jdc.add(new Carreau('h', 3, 2));
			jdc.add(new Carreau('i', 3, 3));
			break;
		case ROUGE:
			jdc.add(new Carreau('A', 1, 1));
			jdc.add(new Carreau('B', 1, 2));
			jdc.add(new Carreau('C', 2, 1));
			jdc.add(new Carreau('D', 2, 2));
			jdc.add(new Carreau('E', 1, 3));
			jdc.add(new Carreau('F', 3, 1));
			jdc.add(new Carreau('G', 2, 3));
			jdc.add(new Carreau('H', 3, 2));
			jdc.add(new Carreau('I', 3, 3));
			break;
		}
	}
	
}
