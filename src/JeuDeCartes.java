import java.util.Collections;
import java.util.Stack;

/**
 * JeuDeCartes.java D�finit une pile de 33 Cartes avec une instruction sp�cifi�e par Type
 * 
 * @author Jules Doum�che, Gw�nol� Martin
 */
public class JeuDeCartes {

	private static final int NB_CARTES = 33;
	private Stack<Type> pile;
	private int CartesRestantes;

	/*
	 * Constructeur: JeuDeCartes
	 * 
	 * @return JeuDeCartes de 33 cartes, 9 rouges, 9 bleues, 5 "taille 1", 5 "taille 2" et 5 "taille 3"
	 */
	public JeuDeCartes() {
		this.pile = new Stack<>();
		this.CartesRestantes = NB_CARTES;

		//Ajouts des cartes des diff�rents types
		for(int i = 0; i < 9; ++i) {
			this.pile.add(Type.BLEU);
			this.pile.add(Type.ROUGE);
		}
		for(int i = 0; i < 5; ++i) {
			this.pile.add(Type.T1);
			this.pile.add(Type.T2);
			this.pile.add(Type.T3);
		}

		//M�lange du jeu de cartes
		Collections.shuffle(pile);
	}

	/**
	 * Tire une carte et renvoie son type
	 * 
	 * @return le type de la carte permettant de conna�tre l'instruction de la carte
	 * @see Type.java
	 */
	public Type tirer() {
		if(CartesRestantes == 0) {
			return null;
		}
		this.CartesRestantes--;
		return pile.pop();
	}

	/*
	 * V�rifie si toutes les cartes ont �t� tir�es
	 * 
	 * @return true s'il ne reste plus aucune carte false sinon
	 */
	public boolean estVide() {
		return pile.isEmpty();
	}

	/*
	 * Retourne le nombre de cartes restantes dans la pile
	 * (pour les tests unitaires)
	 * 
	 * @return le nombre de cartes restantes
	 */
	public int getCartesRestantes() {
		return this.CartesRestantes;
	}
}
