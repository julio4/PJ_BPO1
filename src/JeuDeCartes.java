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
        		this.pile.add(new Carte("Bleu"));
	        	else if(i < 18)
	        		this.pile.add(new Carte("Rouge"));
		        	else if(i < 23)
		        		this.pile.add(new Carte("Taille 1"));
			        	else if(i < 28)
			        		this.pile.add(new Carte("Taille 2"));
				        	else
				        		this.pile.add(new Carte("Taille 3"));
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
	
}
