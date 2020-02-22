import java.util.ArrayList;

public class Jeux {
	private Mur mur;
	private JeuDeCartes pile;
	private JeuDeCarreaux jdc;
	
	public Jeux() {
		mur = new Mur();
    	pile = new JeuDeCartes();
    	jdc= new JeuDeCarreaux();
	}
	
    public static void main(String[] args) {
    	
    	//Initialisation
    	Jeux j = new Jeux();
    	
    	//Partie
    	
    	//TANT QUE: PAS FINI:
    	j.jouerTour();
    }

	private void jouerTour() {
		mur.afficher();
		jdc.afficher(pile.tirer());
	}
}