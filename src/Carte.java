public class Carte{

    private Type type;
    
    public Carte(Type type){
        this.type = type;
    }

    public Type lire() {
    	return this.type;
    }
    
    public String toString() {
    	switch(this.type) {
    	case BLEU:
    		return "Bleu";
    	case ROUGE:
    		return "Rouge";
    	case T1:
    		return "Taille 1";
    	case T2:
    		return "Taille 2";
    	case T3:
    		return "Taille 3";
    	}
		return null;
    }
}
