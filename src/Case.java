public class Case {
    public static int x_MAX = 6;
    public static int y_MAX = 15;

    private char valeur;
    private boolean EstOccup�e;

    public Case(){
        valeur = ' ';
        EstOccup�e = false;
    }

    public char getValeur() {
        return valeur;
    }

    public boolean EstOccup�e() {
        return EstOccup�e;
    }

    public void setValeur(char pCase) {
        valeur = pCase;
    }

    public void setEstOccup�e(boolean pEstOccup�e) {
        EstOccup�e = pEstOccup�e;
    }
}
