public class Case {

    String valeur;
    private boolean EstOccup�e;

    public Case(){
        valeur = " ";
        EstOccup�e = false;
    }

    public boolean EstOccup�e() {
        return EstOccup�e;
    }
    
    public String toString() {
    	if (this.valeur.length() > 1) {
    		return this.valeur + " ";
    	}
    	return " " + this.valeur + " ";
    }
}
