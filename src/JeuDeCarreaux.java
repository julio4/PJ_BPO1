import java.util.ArrayList;

/**
 * JeuDeCarreaux.java D�finit une liste de Carreau
 * 
 * @author Jules Doum�che, Martin Gw�nol�
 */
public class JeuDeCarreaux {

	private static final int TMAX = 3;
	private ArrayList<Carreau> jdc;

	/*
	 * Constructeur: JeuDeCarreaux
	 * 
	 * @return le jeu de carreaux initialis� avec les 18 carreaux bleus et rouges
	 */
	public JeuDeCarreaux() {
		jdc = new ArrayList<>();
		for(char i = 'a'; i < ( 'a' + TMAX*TMAX ); ++i) {
			jdc.add(new Carreau(i));
			jdc.add(new Carreau(Character.toUpperCase(i)));
		}
	}

	/*
	 * Cr�er et initialise un jeu de carreaux contenant tout les carreaux restants du type indiqu�
	 * 
	 * @param type : le type du jeu de carreaux � cr�er
	 * @return le jeu de carreaux cr�e
	 */
	public JeuDeCarreaux cr�erListe(Type type) {
		JeuDeCarreaux retour = new JeuDeCarreaux();
		retour.jdc = new ArrayList<>();

		for(int i = 0; i < this.jdc.size() - 1; ++i) {
			if(this.jdc.get(i).est(type)) {
				retour.jdc.add(this.jdc.get(i));
			}
		}
		return retour;
	}

	/*
	 * V�rifie si tout les carreaux ont �t� pos�s
	 * 
	 * @return true s'il ne reste plus aucun carreaux, false sinon
	 */
	public boolean estVide() {
		return this.jdc.isEmpty();
	}

	/*
	 * V�rifie si le jeu de carreau contient le carreaux correspondant � la lettre indiqu�e
	 * 
	 * @param lettre : la lettre correspondant au carreau � v�rifier
	 * @return true si le jeu de carreaux contient le carreaux de la lettre indiqu�, false sinon
	 */
	public boolean contient(char lettre) {
		for(int i = 0; i < jdc.size(); ++i) {
			if(lettre == jdc.get(i).getLettre()) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Enl�ve du jeu de carreaux le carreaux correspondant � la lettre indiqu�e
	 * 
	 * @param lettre : la lettre correspondant au carreau � enlever
	 * @return true si la suppression a �t� effectu�e, false sinon
	 * @see contient(char lettre) pour v�rifier la pr�sence du Carreaux avant de l'enlever
	 */
	public boolean enlever(char lettre) {
		if(this.contient(lettre)) {
			for(int i = 0; i < jdc.size(); ++i) {
				if(lettre == jdc.get(i).getLettre()) {
					jdc.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * Retourne le nombre de carreaux non pos�s
	 * 
	 * @return nombres de carreaux non pos�s
	 */
	public int carreauxRestants() {
		return jdc.size();
	}

	/*
	 * Obtient l'affichage des carreaux dans l'ordre alphab�tique et des carreaux bleus � rouges
	 * 
	 * @return la cha�ne avec les carreaux c�te � c�te sur une ligne
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		//R�cup�re y max
		int yMax = 0;
		for(int i = 0; i < jdc.size() - 1; ++i) {
			if(jdc.get(i).getHauteur() > yMax) {
				yMax = jdc.get(i).getHauteur();
			}
		}

		//Affiche les carreaux dans l'ordre
		for(int i = yMax; i > 0; --i) {
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
}
