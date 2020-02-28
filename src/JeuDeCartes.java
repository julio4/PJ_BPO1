import java.util.Collections;
import java.util.Stack;

public class JeuDeCartes {
	
	private static final int NB_CARTES = 33;
	private Stack<Type> pile;
	int CartesRestantes;
	
	public JeuDeCartes() {
		this.pile = new Stack<Type>();
		CartesRestantes = NB_CARTES;

		//Ajout des cartes de différents types
        for(int i = 0; i < 9; ++i) {
        	this.pile.add(Type.BLEU);
        	this.pile.add(Type.ROUGE);
        }
        for(int i = 0; i < 5; ++i) {
        	this.pile.add(Type.T1);
    		this.pile.add(Type.T2);
        	this.pile.add(Type.T3);
        }

        //Mélange du jeu de cartes
        Collections.shuffle(pile);
	}
	
	/**
	 * Permet d'afficher le jeu de carte
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < pile.size() - 1; ++i) {
			sb.append(pile.get(i) + "\n");
		}
		return sb.toString();
	}
	
	/**
	 * Tire une carte et renvoie son type
	 * @return
	 */
	public Type tirer() {
		assert(CartesRestantes > 0);
		CartesRestantes--;
		return pile.pop();
	}
	
}
