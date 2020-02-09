public class Piece {

    private char letter;
    private Position position;
    private boolean EstPosée;

    public Piece(){
        letter = ' ';
        position = new Position();
        EstPosée = false;
    }

    public char getLetter() { return letter; }

    public boolean getEstPosée() {
        return EstPosée;
    }

    public Position getPosition() {
        return position;
    }

    public void setLetter(char pLetter) { letter = pLetter; }

    public void setEstPosée(boolean pEstPosée) {
        EstPosée = pEstPosée;
    }

    public void setPostion(Position pPosition) { position = pPosition; }
}
