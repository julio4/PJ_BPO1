public class Jeux {
	
	/**
	 * Fonction main permettant l'exécution du jeux
	 */
    public static void main(String[] args) {
    	Mur mur = new Mur();
    	
    	System.out.println(mur);
    	
    	JeuDeCartes pile = new JeuDeCartes();
    	JeuDeCarreaux jdc = new JeuDeCarreaux();
    	
    	Type carte = pile.tirer();
    	System.out.println(carte);
    	System.out.println(jdc.toString(carte));
    }
}