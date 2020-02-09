public class Case {
    public static int x_MAX = 5+1;
    public static int y_MAX = 15;

    private char value;
    private boolean EstOccupée;

    public Case(){
        value = ' ';
        EstOccupée = false;
    }

    public char getValue() {
        return value;
    }

    public boolean getEstOccupée() {
        return EstOccupée;
    }

    public void setValue(char pCase) {
        value = pCase;
    }

    public void setEstOccupée(boolean pEstOccupée) {
        EstOccupée = pEstOccupée;
    }
}
