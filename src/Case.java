public class Case {

    String valeur;
    private boolean EstOccupée;

    public Case(){
        valeur = " ";
        EstOccupée = false;
    }

    public boolean EstOccupée() {
        return EstOccupée;
    }
    
    public String toString() {
    	if (this.valeur.length() > 1) {
    		return this.valeur + " ";
    	}
    	return " " + this.valeur + " ";
    }
}
