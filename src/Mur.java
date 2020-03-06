import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Mur.java Définit le mur sur lesquels les carreaux sont posés
 * 
 * @author Jules Doumèche, Martin Gwénolé
 */
public class Mur {
	
	private static final int LARGEUR = 5;
	private static final char LIBRE = ' ';
	private ArrayList<char[]> grille;
	private int nx;
	private int ny;

	/*
	 * Constructeur: Mur et initialisation sans carreau neutre(pour les tests)
	 * 
	 * @return le Mur initialisé
	 * @see Mur(boolean pNeutre) pour pouvoir poser le carreau neutre dès l'initialisation du Mur
	 */
	public Mur() {
		this.grille = new ArrayList<>();
	}
	
	/*
	 * Constructeur: Mur et initialisation sans carreau neutre(pour les tests)
	 * 
	 * @param pNeutre : si vrai le carreau neutre est posé
	 * @return le Mur initialisé
	 * @see Mur() pour pouvoir initialiser le Mur sans paramètre d'entrée si aucun carreau neutre
	 */
	public Mur(boolean pNeutre) {
		this();
		if(pNeutre) {
			this.poserNeutre();
		}
	}

	/*
	 * Pose le carreau neutre à l'une des 4 positions possibles aléatoirement
	 * 
	 * @see Mur(boolean pNeutre) pour pouvoir poser le carreau neutre dès l'initialisation du Mur
	 */
	public void poserNeutre() {
		SecureRandom r = new SecureRandom();
		boolean x = r.nextBoolean();
		boolean y = r.nextBoolean();
		Carreau neutre = new Carreau(x);
		this.nx = neutre.getLargeur();
		this.ny = neutre.getHauteur();
		if(y) {
			poser(neutre, grille.size() + 1, LARGEUR + 1 - neutre.getLargeur());
		}
		else {
			poser(neutre, grille.size() + 1, 1);
		}
	}

	/**
	 * Pose le Carreau dans la grille aux coordonées validées
	 * 
	 * @param c : le carreau à poser
	 * @param x : coordonée x où placer le carreau(le plus à gauche)
	 * @param y : coordonée y où placer le carreau(le plus en bas)
	 * @see poser(char lettre, int y, int x) pour pouvoir poser le Carreau en ne spécifiant que sa lettre et les coordonées
	 * @see verifier(char lettre, int y, int x) pour vérifier la validité du placement du carreau aux coordonnées indiquées
	 */
	public void poser(Carreau c, int y, int x) {

		while(grille.size() - y < c.getHauteur()) {
			char[] ligne = new char[LARGEUR];
			Arrays.fill(ligne, LIBRE);
			grille.add(ligne);
		}

		for(int i = x; i < x + c.getLargeur(); ++i) {
			for(int j = y; j < y + c.getHauteur(); ++j) {
				grille.get(j - 1)[i - 1] = c.getLettre();
			}
		}
	}

	/**
	 * Pose le Carreau dans la grille aux coordonées validées
	 * 
	 * @param lettre : la lettre correspondant au carreau à poser
	 * @param x : coordonée x où placer le carreau(le plus à gauche)
	 * @param y : coordonée y où placer le carreau(le plus en bas)
	 * @see poser(Carreau c, int y, int x) pour pouvoir poser le Carreau en spécifiant le Carreau et les coordonées
	 * @see verifier(char lettre, int y, int x) pour vérifier la validité du placement du carreau aux coordonnées indiquées
	 */
	public void poser(char lettre, int y, int x) {
		Carreau c = new Carreau(lettre);
		poser(c, y, x);
	}

	/*
	 * Vérifie si le carreau correspondant à la lettre indiquée peut-être poser aux coordonées spécifiées
	 * 
	 * @param lettre : la lettre correspondant au carreau à vérifier
	 * @param x : coordonée x du carreau(le plus à gauche)
	 * @param y : coordonée y du carreau(le plus en bas)
	 * @return "Valide" si valide, sinon description de l'erreur
	 * @see poser pour pouvoir poser le Carreau après vérification
	 */
	public String verifier(char lettre, int y, int x) {
		Carreau c = new Carreau(lettre);

		if(x + c.getLargeur() - 1 > LARGEUR || x < 1) {
			return "Dépassement zone";
		}
		Character libre = ' ';
		if( y > 1) {
			for(int i = x; i < x + c.getLargeur(); ++i) {

				if( libre.equals(this.grille.get(y - 2)[i - 1])) {
					return "Carreau dans le vide";
				}

				/*
				tests base clone inferieur
				 */
			}
			char cTest = this.grille.get(y - 2)[x - 1];
			if(cTest == this.grille.get(y - 2)[x + c.getLargeur() - 2]) {
				if(cTest == 'x' && nx == c.getLargeur()) {
					return "Base du carreau clonée";
				}
				else {
					Carreau carInf = new Carreau(this.grille.get(y - 2)[x + c.getLargeur() - 2]);
					if(carInf.getLargeur() == c.getLargeur()) {
						return "Base du carreau clonée";
					}
				}
			}
		}

		while(grille.size() - y < c.getHauteur()) {
			char[] ligne = new char[LARGEUR];
			Arrays.fill(ligne, LIBRE);
			grille.add(ligne);
		}
		
		for(int j = y; j < y + c.getHauteur(); ++j) {
			for(int i = x; i < x + c.getLargeur(); ++i) {

				if( this.grille.get(j - 1)[i - 1] != LIBRE) {
					while(grille.size() - y < c.getHauteur()) {
						grille.remove(grille.size());
					}
					return "Carreau superposé";
				}

			}
		}

		if( x != LARGEUR ) {
			char cTest = this.grille.get(y - 1)[x];
			if(cTest == this.grille.get(y + c.getHauteur() - 2)[x]) {
				if(cTest == 'x' && ny == c.getHauteur()) {
					while(grille.size() - y < c.getHauteur()) {
						grille.remove(grille.size());
					}
					return "Face droite du carreau clonée";
				}
				else {
					Carreau carInf = new Carreau(this.grille.get(y + c.getHauteur() - 2)[x]);
					if( carInf.getHauteur() == c.getHauteur()) {
						while(grille.size() - y < c.getHauteur()) {
							grille.remove(grille.size());
						}
						return "Face droite du carreau clonée";
					}
				}
			}
		}
		if ( x != 1 ) {
			char cTest = this.grille.get(y - 1)[x - 2];
			if(cTest == this.grille.get(y + c.getHauteur() - 2)[x - 2]) {
				if(cTest == 'x' && ny == c.getHauteur()) {
					while(grille.size() - y < c.getHauteur()) {
						grille.remove(grille.size());
					}
					return "Face gauche du carreau clonée";
				}
				else {
					Carreau carInf = new Carreau(this.grille.get(y + c.getHauteur() - 2)[x - 2]);
					if( carInf.getHauteur() == c.getHauteur()) {
						while(grille.size() - y < c.getHauteur()) {
							grille.remove(grille.size());
						}
						return "Face gauche du carreau clonée";
					}
				}
			}
		}

		if(y == 1 && (x == 1 || this.grille.get(y - 1)[x - 2] == LIBRE)
				&& ( x == LARGEUR || this.grille.get(y - 1)[x + c.getLargeur() - 1] == LIBRE)) {
			return "Carreau isolé";
		}

		return "valide";
	}
	
	public int niveauComplets() {
		
		int i = grille.size() - 1;
		
		while(i >= 0) {
			for(int j = 0; j < LARGEUR; ++j) {
				if(grille.get(i)[j] == LIBRE) {
					--i;
					break;
				}
				else if(j == LARGEUR - 1) {
					return i + 1;
				}
			}
		}
		return 0;
	}
	
	/**
	 * Permet d'afficher la grille de jeu de bas en haut
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = grille.size(); i > 0; --i) {
			if(i < 10)
				sb.append(i + " ");
			else
				sb.append(i);
			for(int j = 0; j < LARGEUR; ++j) {
				sb.append(" " + grille.get(i - 1)[j]);
			}
			sb.append("\n");
		}
		sb.append("  ");
		for(int j = 1; j <= LARGEUR; ++j) {
			sb.append(" " + j);
		}

		return sb.toString();
	}
	
}
