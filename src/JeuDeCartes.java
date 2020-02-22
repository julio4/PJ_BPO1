import java.util.ArrayList;
import java.util.Random;

public class JeuDeCartes {
	
	private static int NB_CARTES = 33;
	private ArrayList<Carte> pile;
	int CartesRestantes;
	
	public JeuDeCartes() {
		this.pile = new ArrayList<Carte>();
		CartesRestantes = NB_CARTES;
		
        for(int i = 0; i < NB_CARTES; ++i) {
        	if(i < 9)
        		this.pile.add(new Carte(Type.BLEU));
	        	else if(i < 18)
	        		this.pile.add(new Carte(Type.ROUGE));
		        	else if(i < 23)
		        		this.pile.add(new Carte(Type.T1));
			        	else if(i < 28)
			        		this.pile.add(new Carte(Type.T2));
				        	else
				        		this.pile.add(new Carte(Type.T3));
        }

        //Mélange du jeu de cartes
        Random r = new Random();
        for(int i = 0; i < NB_CARTES - 1; ++i) {
        	int b = i + r.nextInt(NB_CARTES - 1 - i);
        	Carte temp = this.pile.get(i);
        	this.pile.set(i, this.pile.get(b));
        	this.pile.set(b, temp);
        }
	}
	
	public Type tirer() {
		CartesRestantes--;
		System.out.println(pile.get(CartesRestantes));
		return pile.get(CartesRestantes).lire();
	}
}
