import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Mur.java D�finit le mur sur lesquels les carreaux sont pos�s
 * 
 * @author Jules Doum�che, Martin Gw�nol�
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
	 * @return le Mur initialis�
	 * @see Mur(boolean pNeutre) pour pouvoir poser le carreau neutre d�s l'initialisation du Mur
	 */
	public Mur() {
		this.grille = new ArrayList<>();
	}
	
	/*
	 * Constructeur: Mur et initialisation sans carreau neutre(pour les tests)
	 * 
	 * @param pNeutre : si vrai le carreau neutre est pos�
	 * @return le Mur initialis�
	 * @see Mur() pour pouvoir initialiser le Mur sans param�tre d'entr�e si aucun carreau neutre
	 */
	public Mur(boolean pNeutre) {
		this();
		if(pNeutre) {
			this.poserNeutre();
		}
	}

	/*
	 * Pose le carreau neutre � l'une des 4 positions possibles al�atoirement
	 * 
	 * @see Mur(boolean pNeutre) pour pouvoir poser le carreau neutre d�s l'initialisation du Mur
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
	 * Pose le Carreau dans la grille aux coordon�es valid�es
	 * 
	 * @param c : le carreau � poser
	 * @param x : coordon�e x o� placer le carreau(le plus � gauche)
	 * @param y : coordon�e y o� placer le carreau(le plus en bas)
	 * @see poser(char lettre, int y, int x) pour pouvoir poser le Carreau en ne sp�cifiant que sa lettre et les coordon�es
	 * @see verifier(char lettre, int y, int x) pour v�rifier la validit� du placement du carreau aux coordonn�es indiqu�es
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
	 * Pose le Carreau dans la grille aux coordon�es valid�es
	 * 
	 * @param lettre : la lettre correspondant au carreau � poser
	 * @param x : coordon�e x o� placer le carreau(le plus � gauche)
	 * @param y : coordon�e y o� placer le carreau(le plus en bas)
	 * @see poser(Carreau c, int y, int x) pour pouvoir poser le Carreau en sp�cifiant le Carreau et les coordon�es
	 * @see verifier(char lettre, int y, int x) pour v�rifier la validit� du placement du carreau aux coordonn�es indiqu�es
	 */
	public void poser(char lettre, int y, int x) {
		Carreau c = new Carreau(lettre);
		poser(c, y, x);
	}

	/*
	 * V�rifie si le carreau correspondant � la lettre indiqu�e peut-�tre poser aux coordon�es sp�cifi�es
	 * 
	 * @param lettre : la lettre correspondant au carreau � v�rifier
	 * @param x : coordon�e x du carreau(le plus � gauche)
	 * @param y : coordon�e y du carreau(le plus en bas)
	 * @return "Valide" si valide, sinon description de l'erreur
	 * @see poser pour pouvoir poser le Carreau apr�s v�rification
	 * @see fonctions de r�gles : rD�passement, rVide, rSuperpos�, rClon� et rIsol�
	 */
	public String verifier(char lettre, int y, int x) {
		Carreau c = new Carreau(lettre);

		if(rD�passement(c, x)) {
			return "Le carreau d�passe la zone";
		}
		
		if(rVide(c, y, x)) {
			return "Le carreau repose sur une case vide";
		}
		
		if(rSuperpos�(c, y, x)) {
			return "Le carreau est superpos� � un autre";
		}
		
		switch(rClon�(c, y, x)) {
		case 0:
			break;
		case 1:
			return "La base du carreau clone la face sup�rieur du carreau inf�rieur";
		case 2:
			return "La face droite du carreau clone la face gauche du carreau � droite";
		case 3:
			return "La face gauche du carreau clone la face droite du carreau � gauche";
		default:
			break;
		}

		if(rIsol�(c, y ,x)) {
			return "Le carreau ne touche aucun autre carreau";
		}
		
		return "valide";
	}
	
	/*
	 * V�rifie si le carreau correspondant � la lettre indiqu�e peut-�tre poser aux coordon�es sp�cifi�es
	 * (Pour test unitaires)
	 * 
	 * @param x : coordon�e x du carreau(le plus � gauche)
	 * @param y : coordon�e y du carreau(le plus en bas)
	 * @param lettre : la lettre correspondant au carreau � v�rifier
	 * @return true si valide, false sinon
	 * @see poser pour pouvoir poser le Carreau apr�s v�rification
	 * @see fonctions de r�gles : rD�passement, rVide, rSuperpos�, rClon� et rIsol�
	 */
	public boolean verifier(int y, int x, char lettre) {
		Carreau c = new Carreau(lettre);
		return !(rD�passement(c, x) || rVide(c, y, x) 
				|| rSuperpos�(c, y, x) || rClon�(c, y, x) > 0 || rIsol�(c, y ,x));
	}
	
	/*
	 * Compte le nombre de niveau compl�t�s
	 * 
	 * @return le nombre de niveau complets
	 */
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
	 * Permet d'afficher le mur de bas en haut avec les num�rotations
	 * 
	 * @return la cha�ne de caract�re correspondant � l'affichage du mur
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
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
		sb.append("\n");
		return sb.toString();
	}
	
	/*
	 * V�rifie si le carreau d�passe les bordures � l'abscisse x
	 * 
	 * @param c : le Carreau
	 * @param x : l'abscisse
	 * @return true si le carreau d�passe les bordures du mur, false sinon
	 */
	private boolean rD�passement(Carreau c, int x) {
		return (x + c.getLargeur() - 1 > LARGEUR || x < 1);
	}
	
	/*
	 * V�rifie si le carreau ne repose pas enti�rement sur des carreaux d�j� pos� aux positions x, y
	 * 
	 * @param c : le Carreau
	 * @param y : l'ordonn�e
	 * @param x : l'abscisse
	 * @return true si le carreau repose sur au moins une case vide, false sinon
	 */
	private boolean rVide(Carreau c, int y, int x) {
		if( y > 1) {
			for(int i = x; i < x + c.getLargeur(); ++i) {
				if( this.grille.get(y - 2)[i - 1] == LIBRE) {
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * V�rifie si le carreau est superpos� � un autre carreau aux positions x, y
	 * 
	 * @param c : le Carreau
	 * @param y : l'ordonn�e
	 * @param x : l'abscisse
	 * @return true si le carreau superpose au moins une case pleine, false sinon
	 */
	private boolean rSuperpos�(Carreau c, int y, int x) {
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
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * V�rifie si le carreau ne clone aucune faces adjacentes aux positions x, y
	 * 
	 * @param c : le Carreau
	 * @param y : l'ordonn�e
	 * @param x : l'abscisse
	 * @return 1 si la base du carreau est clon�e, 2 si la face droite du carreau est clon�e, 
	 * 3 si la face gauche du carreau est clon�e, 0 si aucune faces du carreau n'est clon�es
	 */
	private int rClon�(Carreau c, int y, int x) {
		if( y > 1) {
			char cTest = this.grille.get(y - 2)[x - 1];
			if(cTest == this.grille.get(y - 2)[x + c.getLargeur() - 2]) {
				if(cTest == 'x' && nx == c.getLargeur()) {
					return 1;
				}
				else {
					Carreau carInf = new Carreau(this.grille.get(y - 2)[x + c.getLargeur() - 2]);
					if(carInf.getLargeur() == c.getLargeur()) {
						return 1;
					}
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
					return 2;
				}
				else {
					Carreau carInf = new Carreau(this.grille.get(y + c.getHauteur() - 2)[x]);
					if( carInf.getHauteur() == c.getHauteur()) {
						while(grille.size() - y < c.getHauteur()) {
							grille.remove(grille.size());
						}
						return 2;
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
					return 3;
				}
				else {
					Carreau carInf = new Carreau(this.grille.get(y + c.getHauteur() - 2)[x - 2]);
					if( carInf.getHauteur() == c.getHauteur()) {
						while(grille.size() - y < c.getHauteur()) {
							grille.remove(grille.size());
						}
						return 3;
					}
				}
			}
		}
		return 0;
	}
	
	/*
	 * V�rifie si le carreau ne touche aucune carreaux adjacents aux positions x, y
	 * 
	 * @param c : le Carreau
	 * @param y : l'ordonn�e
	 * @param x : l'abscisse
	 * @return true si le carreau est isol� et ne touche aucun carreaux, false sinon
	 */
	private boolean rIsol�(Carreau c, int y, int x) {
		return (y == 1 
				&& 
				(x == 1 || this.grille.get(y - 1)[x - 2] == LIBRE)
				&& 
				( x == LARGEUR || this.grille.get(y - 1)[x + c.getLargeur() - 1] == LIBRE));
	}
}
