public class Case {

    char valeur;
    private boolean EstOccup�e;

    public Case(){
        valeur = ' ';
        EstOccup�e = false;
    }

    public boolean EstOccup�e() {
        return EstOccup�e;
    }
    
    public String toString() {
    	return this.valeur + "  ";
    }
}
