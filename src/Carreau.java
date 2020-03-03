public class Carreau {

    private char lettre;
    private int hauteur;
    private int largeur;
    //private boolean EstPosée;
    
    public Carreau(char l){
    	assert l >= 'a' || l <= 'i';
    	this.lettre = l;
    	l = Character.toLowerCase(l);
    	switch(l) {
    	case 'a':
        	this.largeur = 1;
        	this.hauteur = 1;
        	break;
    	case 'b':
        	this.largeur = 1;
        	this.hauteur = 2;
        	break;
    	case 'c':
        	this.largeur = 2;
        	this.hauteur = 1;
        	break;
    	case 'd':
        	this.largeur = 2;
        	this.hauteur = 2;
        	break;
    	case 'e':
        	this.largeur = 1;
        	this.hauteur = 3;
        	break;
    	case 'f':
        	this.largeur = 3;
        	this.hauteur = 1;
        	break;
    	case 'g':
        	this.largeur = 2;
        	this.hauteur = 3;
        	break;
    	case 'h':
        	this.largeur = 3;
        	this.hauteur = 2;
        	break;
    	case 'i':
        	this.largeur = 3;
        	this.hauteur = 3;
        	break;
    	}
    }
    
    /*
     * Pour crée le Carreau neutre uniquement
     */
    public Carreau(boolean estVert) {
    	this.lettre = 'x';
    	if(estVert) {
    		this.hauteur = 3;
    		this.largeur = 1;
    	}
    	else {
    		this.hauteur = 1;
    		this.largeur = 3;
    	}
    }
    
    public boolean est(Type t) {
    	switch(t) {
		case BLEU:
			return Character.isLowerCase(this.lettre);
		case ROUGE:
			return Character.isUpperCase(this.lettre);
		case T1:
			return (this.largeur == 1 || this.hauteur == 1);
		case T2:
			return (this.largeur == 2 || this.hauteur == 2);
		case T3:
			return (this.largeur == 3 || this.hauteur == 3);
		}
		return false;
    }
    
    
    public int getHauteur() {
    	return this.hauteur;
    }

	public char getLettre() {
		return this.lettre;
	}

	public int getLargeur() {
		return this.largeur;
	}
}
