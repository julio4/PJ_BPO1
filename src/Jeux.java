import java.util.Scanner;

public class Jeux {

	private static boolean finie() {
		return false;
	}
	/**
	 * Fonction main permettant l'exécution du jeux
	 */
	public static void main(String[] args) {

		JeuDeCartes pile = new JeuDeCartes();
		JeuDeCarreaux jdc = new JeuDeCarreaux();
		Scanner sc = new Scanner(System.in);
		Mur mur = new Mur();
		int cartesPassées = 0;
		
		mur.poserNeutre();

		while(!finie()) {

			//Affichage du mur
			System.out.println(mur);

			//Tirer et afficher l'instruction de la carte
			Type carte = pile.tirer();
			System.out.println(carte);

			//Liste des carreaux possible
			JeuDeCarreaux listeCarreaux = jdc.créerListe(carte);
			if(!listeCarreaux.estVide()) {
				//Affichage de la liste de Carreaux;
				System.out.println(listeCarreaux);

				//Affichage des instructions d'entrées et initialisation
				System.out.println("Veuillez entrer la lettre correspondant au carreau choisi suivit du numéro de la ligne(y) et de la colonne(x).\n"
						+ "Par exemple 'h 2 1' pour poser le carreau h à la 2ème ligne et à la première colonne.\n"
						+ "Vous pouvez de plus écrire 'next' pour écarter la carte et passer au prochain tour ou 'stop' pour mettre fin à la partie.\n");
				String input = sc.next();


				if(input.toLowerCase().equals("next")) {
					++cartesPassées;
					continue;
				}
				else if(input.toLowerCase().equals("stop")) {
					break;
				}
				else {
					//TANT QUE SAISIE INVALIDE
					
					//Initialisations des variables d'entrées
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
									System.out.println("Erreur! Impossible de poser le carreau " + lettre + " au positions indiquées.\n");
								}
							}
							else {
								System.out.println("Erreur! Veuillez entrez un carreau affichée dans la liste précedente.\n");
							}
						}

					}
					
					//FIN TANT QUE
				}
			}
			else {
				++cartesPassées;
				System.out.println("Aucun carreau restant ne correspond à la carte tirée");
				//TOUR SUIVANT
			}
		}
		//Fin de la partie
		
		//CALCUL SCORE
		
		sc.close();
	}
}