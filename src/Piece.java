public class Piece {

    private char lettre;
    private Position position;
    private boolean EstPos�e;

    public Piece(){
        lettre = ' ';
        position = new Position();
        EstPos�e = false;
    }

    public char getLettre() { return lettre; }

    public boolean getEstPos�e() {
        return EstPos�e;
    }

    public Position getPosition() {
        return position;
    }

    public void setLettre(char pLettre) { lettre = pLettre; }

    public void setEstPos�e(boolean pEstPos�e) {
        EstPos�e = pEstPos�e;
    }

    public void setPostion(Position pPosition) { position = pPosition; }
}
