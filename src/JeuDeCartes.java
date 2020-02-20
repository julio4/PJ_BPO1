import java.util.ArrayList;
import java.util.Random;

public class JeuDeCartes {
	private static int NB_CARTES = 33;
	private ArrayList<Carte> jdc;
	int CartesRestantes;
	
	public JeuDeCartes() {
		this.jdc = new ArrayList<Carte>();
		CartesRestantes = NB_CARTES;
		
        for(int i = 0; i < NB_CARTES; ++i) {
        	if(i < 9)
        		this.jdc.add(new Carte("Bleu"));
	        	else if(i < 18)
	        		this.jdc.add(new Carte("Rouge"));
		        	else if(i < 23)
		        		this.jdc.add(new Carte("Taille 1"));
			        	else if(i < 28)
			        		this.jdc.add(new Carte("Taille 2"));
				        	else
				        		this.jdc.add(new Carte("Taille 3"));
        }

        //Mélange du jeu de cartes
        Random r = new Random();
        for(int i = 0; i < NB_CARTES - 1; ++i) {
        	int b = i + r.nextInt(NB_CARTES - 1 - i);
        	Carte temp = this.jdc.get(i);
        	this.jdc.set(i, this.jdc.get(b));
        	this.jdc.set(b, temp);
        }
	}
	
}
