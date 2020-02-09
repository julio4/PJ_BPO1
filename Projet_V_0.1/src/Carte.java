public class Carte{
    public static int NB_CARTES = 33;

    private String typeCarte;
    private boolean EstPiochée;

    public Carte(){
        typeCarte = "Inconnu";
        EstPiochée = false;
    }

    public String getType() {
        return typeCarte;
    }

    public boolean getEstPiochée() {
        return EstPiochée;
    }

    public void setType(String pType) {
        typeCarte = pType;
    }

    public void setEstPiochée(boolean pEstPiochée) {
        EstPiochée = pEstPiochée;
    }

}
