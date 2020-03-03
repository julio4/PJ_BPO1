import java.util.Scanner;

public class Jeux {

	private static boolean finie() {
		return false;
	}
	/**
	 * Fonction main permettant l'ex�cution du jeux
	 */
	public static void main(String[] args) {

		JeuDeCartes pile = new JeuDeCartes();
		JeuDeCarreaux jdc = new JeuDeCarreaux();
		Scanner sc = new Scanner(System.in);
		Mur mur = new Mur();
		int cartesPass�es = 0;
		
		mur.poserNeutre();

		while(!finie()) {

			//Affichage du mur
			System.out.println(mur);

			//Tirer et afficher l'instruction de la carte
			Type carte = pile.tirer();
			System.out.println(carte);

			//Liste des carreaux possible
			JeuDeCarreaux listeCarreaux = jdc.cr�erListe(carte);
			if(!listeCarreaux.estVide()) {
				//Affichage de la liste de Carreaux;
				System.out.println(listeCarreaux);

				//Affichage des instructions d'entr�es et initialisation
				System.out.println("Veuillez entrer la lettre correspondant au carreau choisi suivit du num�ro de la ligne(y) et de la colonne(x).\n"
						+ "Par exemple 'h 2 1' pour poser le carreau h � la 2�me ligne et � la premi�re colonne.\n"
						+ "Vous pouvez de plus �crire 'next' pour �carter la carte et passer au prochain tour ou 'stop' pour mettre fin � la partie.\n");
				String input = sc.next();


				if(input.toLowerCase().equals("next")) {
					++cartesPass�es;
					continue;
				}
				else if(input.toLowerCase().equals("stop")) {
					break;
				}
				else {
					//TANT QUE SAISIE INVALIDE
					
					//Initialisations des variables d'entr�es
					char lettre = input.charAt(0);
					int x = 0;
					int y = 0;
					if(sc.hasNextInt()) {
						y = sc.nextInt();
						if(sc.hasNextInt()) {
							x = sc.nextInt();

							if(listeCarreaux.contient(lettre)) {
								if(mur.verifier(lettre, y, x)) {
									mur.poser(lettre, y, x);
									jdc.enlever(lettre);
								}
								else {
									System.out.println("Erreur! Impossible de poser le carreau " + lettre + " au positions indiqu�es.\n");
								}
							}
							else {
								System.out.println("Erreur! Veuillez entrez un carreau affich�e dans la liste pr�cedente.\n");
							}
						}

					}
					
					//FIN TANT QUE
				}
			}
			else {
				++cartesPass�es;
				System.out.println("Aucun carreau restant ne correspond � la carte tir�e");
				//TOUR SUIVANT
			}
		}
		//Fin de la partie
		
		//CALCUL SCORE
		
		sc.close();
	}
}