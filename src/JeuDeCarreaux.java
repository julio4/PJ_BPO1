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
	
	public JeuDeCarreaux créerListe(Type type) {
		JeuDeCarreaux retour = new JeuDeCarreaux();
		retour.jdc = new ArrayList<>();
		
		for(int i = 0; i < this.jdc.size() - 1; ++i) {
			if(this.jdc.get(i).est(type)) {
				retour.jdc.add(this.jdc.get(i));
			}
		}
		return retour;
	}
	
	public String toString(//ArrayList<Carreau> afficher
			) {
		StringBuilder sb = new StringBuilder();
		
		//Recupère y max
		int y_max = 0;
		for(int i = 0; i < jdc.size() - 1; ++i) {
			if(jdc.get(i).getHauteur() > y_max) {
				y_max = jdc.get(i).getHauteur();
			}
		}
		
		//Affiche les carreaux dans l'ordre
		for(int i = y_max; i > 0; --i) {
			for(int j = 0; j < jdc.size(); ++j) {
				for(int h = 0; h < jdc.get(j).getLargeur(); ++h) {
					if(jdc.get(j).getHauteur() < i) {
						sb.append("  ");
					}
					else {
						sb.append(" " + jdc.get(j).getLettre());
					}
				}
				sb.append("  ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public boolean estVide() {
		return this.jdc.isEmpty();
	}

	public boolean contient(char lettre) {
		for(int i = 0; i < jdc.size(); ++i) {
			if(lettre == jdc.get(i).getLettre()) {
				return true;
			}
		}
		return false;
	}
}
