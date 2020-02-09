public class Piece {

    private char lettre;
    private Position position;
    private boolean EstPosée;

    public Piece(){
        lettre = ' ';
        position = new Position();
        EstPosée = false;
    }

    public char getLettre() { return lettre; }

    public boolean getEstPosée() {
        return EstPosée;
    }

    public Position getPosition() {
        return position;
    }

    public void setLettre(char pLettre) { lettre = pLettre; }

    public void setEstPosée(boolean pEstPosée) {
        EstPosée = pEstPosée;
    }

    public void setPostion(Position pPosition) { position = pPosition; }
}
