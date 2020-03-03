import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Mur {
	private final int LARGEUR = 5;
    private ArrayList<char[]> grille;
    private int niveau;
    
    public Mur() {
    	this.grille = new ArrayList<>();
    	this.niveau = 1;
    }
    
    public void poserNeutre() {
    	Random r = new Random();
    	boolean x = r.nextBoolean();
    	boolean y = r.nextBoolean();
		Carreau neutre = new Carreau(x);
		if(y) {
			poser(neutre, niveau, LARGEUR + 1 - neutre.getLargeur());
		}
		else {
			poser(neutre, niveau, 1);
		}
    }
    
    /**
     * Pose le Carreau dans la grille aux coordonées validées
     * @param c (Carreau): le carreau à poser
     * @param x (int): coordonée x où placer le carreau(le plus à gauche)
     * @param y (int): coordonée y où placer le carreau(le plus en bas)
     */
    public void poser(Carreau c, int y, int x) {
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
    
    public void poser(char lettre, int y, int x) {
    	Carreau c = new Carreau(lettre);
    	poser(c, y, x);
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

	public boolean verifier(char lettre, int y, int x) {
		Carreau c = new Carreau(lettre);
		
		if(x + c.getLargeur() - 1 > LARGEUR || y < niveau || x < 1) {
			return false;
		}
		
		//parcours des lignes en partant du bas
		for(int i = y; i < c.getHauteur(); ++i) {
			//parcours des colonnes en partant de la gauche
			for(int j = x; j < c.getLargeur(); ++j) {
				if( this.grille.get(i)[j] != ' ') {
					return false;
				}
			}
		}
		return true;
	}
}
