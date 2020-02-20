
public class Mur {
	private static int x_MAX = 6;
    private static int y_MAX = 15;
    private Case[][] grille;
    
    public Mur() {
    	this.grille = new Case[x_MAX][y_MAX];
    	
        for (int i = 0; i < x_MAX; ++i){
            for (int j = 0; j < y_MAX; ++j){
                this.grille[i][j] = new Case();
            }
        }
        
        //NUMEROTATION GRILLE
        
        this.grille[0][0].valeur = ' ';
        for (int i = 1; i < x_MAX; i++) {
            this.grille[i][0].valeur = (char)(i + '0');
        }
        for (int i = 1; i < 2; i++){
            this.grille[0][i].valeur = (char)(i + '0');
        }
    }
    
    public void afficher() {
        for (int i = 0; i < 2; ++i){
            for (int j = 0; j < x_MAX; ++j){
                System.out.print(this.grille[j][i]);
            }
            System.out.println();
        }
    }
}
