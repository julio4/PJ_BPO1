public class Carreau {

    private char lettre;
    private int hauteur;
    private int largeur;
    //private boolean EstPos�e;

    public Carreau(char lettre, int x, int y){
        this.lettre = lettre;
        this.largeur = x;
        this.hauteur = y;
        //EstPos�e = false;
    }
    
    public int getHauteur() {
    	return this.hauteur;
    }
}
