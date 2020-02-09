public class Carte{
    public static int NB_CARTES = 33;

    private String typeCarte;
    private boolean EstPioch�e;

    public Carte(){
        typeCarte = "Inconnu";
        EstPioch�e = false;
    }

    // Eviter si possible les get et set et utiliser directement dans les m�thods n�cessaires
    //Valable pour toutes les classes
    public String getType() {
        return typeCarte;
    }

    public boolean getEstPioch�e() {
        return EstPioch�e;
    }

    public void setType(String pType) {
        typeCarte = pType;
    }

    public void setEstPioch�e(boolean pEstPioch�e) {
        EstPioch�e = pEstPioch�e;
    }
    //
}
