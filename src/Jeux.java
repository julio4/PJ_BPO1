public class Jeux {
    public static void main(String[] args) {
    	
    	//Initialisation
    	Mur mur = new Mur();
    	JeuDeCartes pile = new JeuDeCartes();
    	mur.afficher();
        

        //Tirer une carte
        /*Carte cartePioch�e = new Carte();
        cartePiochée = tirerUneCarte(JeuDeCarte)*/
    }

    /*
    public static Carte tirerUneCarte(Carte[] JeuDeCarte){

        int temp = (int) (Math.random() * Carte.NB_CARTES);
        while (JeuDeCarte[temp].getEstPioch�e()){
            temp = (int) (Math.random() * Carte.NB_CARTES);
        }
        JeuDeCarte[temp].setEstPioch�e(true);
        return JeuDeCarte[temp];
    }
    */
}