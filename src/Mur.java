import java.util.ArrayList;
import java.util.Random;


public class Mur {
	private final int LARGEUR = 5;
    private ArrayList<char[]> grille;
    
    public Mur() {
    	this.grille = new ArrayList<char[]>();
    	
    	
    	Random r = new Random();
    	boolean x = r.nextBoolean();
    	boolean y = r.nextBoolean();
    	if(x) {
    		Carreau neutre = new Carreau('x', 3, 1);
    		if(y) {
    			poser(neutre, 1, 1);
    		}
    		else {
    			poser(neutre, 3, 1);
    		}
    	}
    	else {
    		Carreau neutre = new Carreau('x', 1, 3);
    		if(y) {
    			poser(neutre, 1, 1);
    		}
    		else {
    			poser(neutre, 5, 1);
    		}
    	}
    	
    }
    
    public void poser(Carreau c, int x, int y) {
    	for(int i = 0; i < c.getHauteur(); ++i) {
    		if(grille.get(y - 1)[x] == ' ' || grille.size() == 0 ) {
    			char[] ligne = {' ', ' ', ' ', ' ', ' '};
    		}
    	}
    }
    
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
    	sb.append("   1 2 3 4 5");
    	return sb.toString();
    }
}
