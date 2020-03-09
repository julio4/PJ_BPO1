import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Jeux.java Permet de jouer au jeu "The Tiler Team"
 * 
 * @author Jules Doum�che, Gw�nol� Martin
 */
public class Jeux {

	/*
	 * V�rifie si le jeu est fini
	 * 
	 * @return true si le jeu est fini, false sinon
	 */
	private static boolean estFini(boolean status, JeuDeCartes pile, JeuDeCarreaux jdc) {
		return jdc.estVide() || pile.estVide() || !status;
	}

	/**
	 * Fonction principale (main) permettant l'ex�cution d'une partie du jeu
	 * 
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {

		JeuDeCartes pile = new JeuDeCartes();
		JeuDeCarreaux jdc = new JeuDeCarreaux();
		Scanner sc = new Scanner(System.in);
		Mur mur = new Mur(true);
		int cartesEc = 0;
		boolean status = true;

		while(!estFini(status, pile, jdc)) {

			//Tirer la carte
			Type carte = pile.tirer();

			//Liste des carreaux pouvant �tre pos�s
			JeuDeCarreaux listeCarreaux = jdc.cr�erListe(carte);
			if(!listeCarreaux.estVide()) {

				//Affichage des instructions d'entr�es et initialisation
				boolean saisieValide = false;
				while(!saisieValide) {

					//Affichage du mur et de l'instruction de la carte tir�e
					System.out.println(mur);
					System.out.println(carte);

					//Affichage de la liste de Carreaux
					System.out.println(listeCarreaux);

					System.out.println("Veuillez entrer la lettre correspondant au carreau choisi suivit du num�ro de la ligne(y) et de la colonne(x).\n"
							+ "Par exemple 'h 2 1' pour poser le carreau h � la 2�me ligne et � la premi�re colonne.\n"
							+ "Vous pouvez de plus �crire 'next' pour �carter la carte et passer au prochain tour ou 'stop' pour mettre fin � la partie.\n");
					String input = sc.next();


					if(input.equalsIgnoreCase("next")) {
						++cartesEc;
						break;
					}
					else if(input.equalsIgnoreCase("stop")) {
						status = false;
						break;
					}
					else {

						// Initialisation des variables d'entr�es
						// Pour inverser le sens de saisie (qui est de base y puis x, vous pouvez inverser x et y ici (instructions l.76 et l.78))
						char lettre = input.charAt(0);
						int x = 0;
						int y = 0;
						if(sc.hasNextInt()) {
							y = sc.nextInt();
							if(sc.hasNextInt()) {
								x = sc.nextInt();
								if(listeCarreaux.contient(lettre)) {
									String codeInput = mur.verifier(lettre, y, x);
									if(codeInput.equals("valide")) {
										mur.poser(lettre, y, x);
										jdc.enlever(lettre);
										saisieValide = true;
									}
									else {
										System.out.println("Erreur! Impossible de poser le carreau " + lettre 
												+ " au positions " + y + " " + x +"\n Erreur: " + codeInput + ".\n");
									}
								}
								else {
									System.out.println("Erreur! Veuillez entrez un carreau affich� dans la liste pr�cedente.\n");
								}
							}
						}
					}
				}
			}
			else {
				++cartesEc;
				System.out.println("Aucun carreau restant ne correspond � la carte tir�e");
				//passage au tour suivant automatiquement
			}
		}
		//Fin de la partie et calcul du score
		int points = mur.niveauComplets() * 5 - jdc.carreauxRestants() - cartesEc;
		if (points < 0) {
			points = 0;
		}
		System.out.println(points + " points (" + mur.niveauComplets() + " niveaux complets, "
				+ jdc.carreauxRestants() + " carreaux non pos�s, " + cartesEc +" cartes �cart�es)");
		

		sc.close();
	}
}