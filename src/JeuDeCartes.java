import java.util.ArrayList;
import java.util.Random;

public class JeuDeCartes {
	
	private final int NB_CARTES = 33;
	private ArrayList<Type> pile;
	int CartesRestantes;
	
	public JeuDeCartes() {
		this.pile = new ArrayList<Type>();
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
        Random r = new Random();
        for(int i = 0; i < NB_CARTES - 1; ++i) {
        	int b = i + r.nextInt(NB_CARTES - 1 - i);
        	Type temp = this.pile.get(i);
        	this.pile.set(i, this.pile.get(b));
        	this.pile.set(b, temp);
        }
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < pile.size() - 1; ++i) {
			sb.append(pile.get(i) + "\n");
		}
		return sb.toString();
	}
	/*
	public Type tirer() {
		CartesRestantes--;
		System.out.println(pile.get(CartesRestantes));
		return pile.get(CartesRestantes).lire();
	}
	*/
}
