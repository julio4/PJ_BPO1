public class Carte{
    public static int NB_CARTES = 33;

    private String typeCarte;
    private boolean EstPiochée;

    public Carte(){
        typeCarte = "Inconnu";
        EstPiochée = false;
    }

    // Eviter si possible les get et set et utiliser directement dans les méthods nécessaires
    //Valable pour toutes les classes
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
    //
}
