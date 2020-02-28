import java.util.Scanner;

public class Jeux {
	
	/**
	 * Fonction main permettant l'exécution du jeux
	 */
    public static void main(String[] args) {
    	Mur mur = new Mur();
    	boolean partie = true;
    	
    	// MAIN NON ORDONNEE
    	
    	JeuDeCartes pile = new JeuDeCartes();
    	JeuDeCarreaux jdc = new JeuDeCarreaux();
    	
    	while(partie) {
	    	System.out.println(mur);
	    	Type carte = pile.tirer();
	    	System.out.println(carte);
	    	System.out.println(jdc.toString(carte));

	    	//CHECK SI CARREAU POSABLE POSSIBLE
	    	//SINON PASSE AU TOUR SUIVANT AVEC CONTINUE;
	    	
	    	{
    		Scanner sc = new Scanner(System.in);
    		//String input = sc.nextLine();
    		//System.out.println(input);
    		while(true) {
    			String input = sc.next();
	    		if(input.equals("next")) {
	    			break;
	    		}
	    		else if(input.equals("stop")) {
	    			partie = false;
	    			break;
	    		}
	    		char lettre = input.charAt(0);
	    		
	    		int x = 0, y = 0;
	    		while(!sc.hasNextInt()) {
		    		sc.hasNext();
	    		}
	    		x = sc.nextInt();
	    		y = sc.nextInt();
	    		
	    		if(/* FAIRE ICI CONDITION DE VALIDATION, 
	    		CAD LA LETRRE ENTREE ET LES COORDONEE VERIFIABLE 
	    		AVEC UNE LISTE DES CARREAUX POSSIBLE FAITPLUS HAUT */ 
	    			/*valider(lettre, x, y) && lettre dans list valide*/ true) {
	    			
	    			//poser(l, x, y);
	    			//SCORE
	    			
	    			break;
	    		}
	    		sc.next();
	    		//System.out.println(lettre + " " + x + " " + y);
	    	}
	    	sc.close();
	    	}
	    	
    	}
    	
    }
}