
public class Mur {
	private static int x_MAX = 6;
    private static int y_MAX = 16;
    private int y_top;
    private Case[][] grille;
    
    public Mur() {
    	this.grille = new Case[x_MAX][y_MAX];
    	y_top = 2;
    	
        for (int i = 0; i < x_MAX; ++i){
            for (int j = 0; j < y_MAX; ++j){
                this.grille[i][j] = new Case();
            }
        }
        
        //NUMEROTATION GRILLE
        
        this.grille[0][0].valeur = " ";
        for (int i = 1; i < x_MAX; i++) {
            this.grille[i][0].valeur = Integer.toString(i);
        }
        for (int i = 1; i <= y_top; i++){
            this.grille[0][i].valeur = Integer.toString(i);
        }
    }
    
    public void afficher() {
    	for(int j = y_top; j >= 0; --j) {
	    	for (int i = 0; i < x_MAX; ++i){
	    		System.out.print(this.grille[i][j]);
	    	}
	    	System.out.println();
    	}
    }
}
