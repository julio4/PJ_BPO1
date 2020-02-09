public class Main {
    public static void main(String[] args) {
    	//ARRAYLIST ?
        Carte[] JeuDeCarte = new Carte[Carte.NB_CARTES];
        initCartes(JeuDeCarte);

        Case[][] Mur = new Case[Case.x_MAX][Case.y_MAX];
        initMur(Mur);
        afficherMur(Mur);

        //Tirer une carte
        /*Carte cartePiochée = new Carte();
        cartePiochÃ©e = tirerUneCarte(JeuDeCarte)*/
    }


    // A optimiser et clean
    public static void initCartes(Carte[] JeuDeCarte){
    	
        for (int i = 0; i < Carte.NB_CARTES; i++){
            JeuDeCarte[i] = new Carte();
        }

        for (int i=0; i<18; i++){
            if(i<9){
                JeuDeCarte[i].setType("Bleu");
            } else {
                JeuDeCarte[i].setType("Rouge");
            }
        }
        for (int i=18; i<33; i++){
            if(i<23){
                JeuDeCarte[i].setType("Taille 1");
            } else if(i<28) {
                JeuDeCarte[i].setType("Taille 2");
            } else {
                JeuDeCarte[i].setType("Taille 3");
            }
        }
    }

    public static void afficherCartes(Carte[] JeuDeCarte){
        for (int i = 0; i<Carte.NB_CARTES; i++){
            System.out.println(JeuDeCarte[i].getType());
        }
    }

    public static Carte tirerUneCarte(Carte[] JeuDeCarte){

        int temp = (int) (Math.random() * Carte.NB_CARTES);
        while (JeuDeCarte[temp].getEstPiochée()){
            temp = (int) (Math.random() * Carte.NB_CARTES);
        }
        JeuDeCarte[temp].setEstPiochée(true);
        return JeuDeCarte[temp];
    }

    public static void afficherMur(Case[][] Mur){
        for (int j = 0; j < Case.y_MAX; j++){
            for (int i = 0; i < Case.x_MAX; i++){
                System.out.print(Mur[i][(Case.y_MAX-1)-j].getValeur()+"  ");
            }
            System.out.println();
        }
    }

    public static void initMur (Case [][] Mur){
        for (int i = 0; i<Case.x_MAX; i++){
            for (int j = 0; j<Case.y_MAX; j++){
                Mur[i][j] = new Case();
            }
        }
        for (int i = 0; i < Case.x_MAX; i++) {
            char tempchar = (char) (i + '0');
            Mur[i][0].setValeur(tempchar);
        }
        for (int i = 0; i < Case.y_MAX; i++){
            int tempint = i;
            char tempchar = (char) (tempint + '0');
            Mur[0][i].setValeur(tempchar);
        }
        Mur[0][0].setValeur(' ');
    }
}