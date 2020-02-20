import java.util.ArrayList;
import java.util.Random;

public class JeuDeCartes {
	private static int NB_CARTES = 33;
	ArrayList<Carte> jdc;
	int CartesRestantes;
	
	public JeuDeCartes() {
		jdc = new ArrayList<Carte>();
		CartesRestantes = NB_CARTES;
		
        for(int i = 0; i < NB_CARTES; ++i) {
	        switch(i) {
		        case 0:
		        	jdc.add(new Carte("Bleu"));
		        case 9:
		        	jdc.add(new Carte("Rouge"));
		        case 18:
		        	jdc.add(new Carte("Taille 1"));
		        case 23:
		        	jdc.add(new Carte("Taille 2"));
		        case 28:
		        	jdc.add(new Carte("Taille 3"));
	        }
        }

        Random r = new Random();
        for(int i = 0; i < NB_CARTES - 1; ++i) {
        	int b = i + r.nextInt(NB_CARTES - 1 - i);
        	Carte temp = jdc.get(i);
        	jdc.set(i, jdc.get(b));
        	jdc.set(b, temp);
        }
	}
	
}
