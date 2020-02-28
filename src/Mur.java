import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Mur {
	private final int LARGEUR = 5;
    private ArrayList<char[]> grille;
    
    public Mur() {
    	this.grille = new ArrayList<char[]>();
    	
    	
    	Random r = new Random();
    	boolean x = r.nextBoolean();
    	boolean y = r.nextBoolean();
		Carreau neutre = new Carreau(x);
		if(x) {
			if(y) {
				poser(neutre, 1, 1);
			}
			else {
				poser(neutre, 5, 1);
			}
		}
		else {
			if(y) {
				poser(neutre, 1, 1);
			}
			else {
				poser(neutre, 3, 1);
			}
		}
    	
    }
    
    /**
     * Pose le Carreau dans la grille aux coordon�es valid�es
     * @param c (Carreau): le carreau � poser
     * @param x (int): coordon�e x o� placer le carreau(le plus � gauche)
     * @param y (int): coordon�e y o� placer le carreau(le plus en bas)
     */
    public void poser(Carreau c, int x, int y) {
    	
    	//valider(largeur, hauteur, x, y) ?
		while(grille.size() - y < c.getHauteur()) {
			char[] ligne = new char[LARGEUR];
			Arrays.fill(ligne, ' ');
			grille.add(ligne);
		}
    	for(int i = x; i < x + c.getLargeur(); ++i) {
    		for(int j = y; j < y + c.getHauteur(); ++j) {
    		grille.get(j - 1)[i - 1] = c.getLettre();
    		}
    	}
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
    	sb.append("   1 2 3 4 5");
    	return sb.toString();
    }
}
