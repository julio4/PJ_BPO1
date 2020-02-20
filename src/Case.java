public class Case {

    char valeur;
    private boolean EstOccupée;

    public Case(){
        valeur = ' ';
        EstOccupée = false;
    }

    public boolean EstOccupée() {
        return EstOccupée;
    }
    
    public String toString() {
    	return this.valeur + "  ";
    }
}
