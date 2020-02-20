public class Jeux {
    public static void main(String[] args) {
    	
    	//Initialisation
    	Mur mur = new Mur();
    	JeuDeCartes pile = new JeuDeCartes();
    	mur.afficher();
        

        //Tirer une carte
        /*Carte cartePiochée = new Carte();
        cartePiochÃ©e = tirerUneCarte(JeuDeCarte)*/
    }

    /*
    public static Carte tirerUneCarte(Carte[] JeuDeCarte){

        int temp = (int) (Math.random() * Carte.NB_CARTES);
        while (JeuDeCarte[temp].getEstPiochée()){
            temp = (int) (Math.random() * Carte.NB_CARTES);
        }
        JeuDeCarte[temp].setEstPiochée(true);
        return JeuDeCarte[temp];
    }
    */
}