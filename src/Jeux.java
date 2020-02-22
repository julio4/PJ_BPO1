public class Jeux {
	private static Mur mur;
	private static JeuDeCartes pile;
	private static JeuDeCarreaux jdc;
	
	public Jeux() {
		mur = new Mur();
    	pile = new JeuDeCartes();
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
	}
}