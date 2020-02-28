import java.util.ArrayList;

public class JeuDeCarreaux {
	private static final int TMAX = 3;
	private ArrayList<Carreau> jdc;
	
	public JeuDeCarreaux() {
		jdc = new ArrayList<>();
		
		for(char i = 'a'; i <= ( 'a' + TMAX*TMAX ); ++i) {
			jdc.add(new Carreau(i));
			jdc.add(new Carreau(Character.toUpperCase(i)));
		}
	}
	
	public String toString(Type type) {
		StringBuilder sb = new StringBuilder();
		ArrayList<Carreau> afficher = new ArrayList<>();
		int y_max = 0;
		for(int i = 0; i < jdc.size() - 1; ++i) {
			if(jdc.get(i).est(type)) {
				afficher.add(jdc.get(i));
				//sb.append(jdc.get(i));
				if(jdc.get(i).getHauteur() > y_max) {
					y_max = jdc.get(i).getHauteur();
				}
			}
		}
		
		for(int i = y_max; i > 0; --i) {
			for(int j = 0; j < afficher.size(); ++j) {
				for(int h = 0; h < afficher.get(j).getLargeur(); ++h) {
					if(afficher.get(j).getHauteur() < i) {
						sb.append("  ");
					}
					else {
						sb.append(" " + afficher.get(j).getLettre());
					}
				}
				sb.append("  ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
