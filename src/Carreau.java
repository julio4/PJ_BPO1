public class Carreau {

    private char lettre;
    private Position pos;
    private boolean EstPos�e;

    public Carreau(char lettre, int x, int y){
        this.lettre = lettre;
        pos = new Position(x, y);
        EstPos�e = false;
    }
}
