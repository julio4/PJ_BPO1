public class Carreau {

    private char lettre;
    private int hauteur;
    private int largeur;
    //private boolean EstPosée;

    public Carreau(char lettre, int x, int y){
        this.lettre = lettre;
        this.largeur = x;
        this.hauteur = y;
        //EstPosée = false;
    }
    
    public int getHauteur() {
    	return this.hauteur;
    }
}
