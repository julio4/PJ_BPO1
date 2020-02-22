public class Piece {

    private char lettre;
    private Position pos;
    private boolean EstPosée;

    public Piece(){
        lettre = ' ';
        pos = new Position();
        EstPosée = false;
    }
}
