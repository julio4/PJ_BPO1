public class Case {
    public static int x_MAX = 6;
    public static int y_MAX = 15;

    private char valeur;
    private boolean EstOccupée;

    public Case(){
        valeur = ' ';
        EstOccupée = false;
    }

    public char getValeur() {
        return valeur;
    }

    public boolean EstOccupée() {
        return EstOccupée;
    }

    public void setValeur(char pCase) {
        valeur = pCase;
    }

    public void setEstOccupée(boolean pEstOccupée) {
        EstOccupée = pEstOccupée;
    }
}
