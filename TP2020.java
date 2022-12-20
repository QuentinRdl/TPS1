public class TP2020{
	public static void main(String args[]){
		Main mainTest = new Main();
		Coup leCoup = new Coup();
		mainTest = tirageMain();
		affichageMain(mainTest);
		assignerTapis(mainTest, leCoup);
		afficherTapis(leCoup);
		if(mainTest.carte1.carteVal > leCoup.tapis.carteVal){
			Ecran.afficher("\nCarte reponse : (");
			afficherVal(mainTest.carte1);
			Ecran.afficher(" ");
			afficherCoul(mainTest.carte1);
			Ecran.afficher(")");
			Ecran.afficher("\n*** Gagne\n");
		}
		else if(mainTest.carte2.carteVal > leCoup.tapis.carteVal){
			Ecran.afficher("\nCarte reponse : (");
			afficherVal(mainTest.carte2);
			Ecran.afficher(" ");
			afficherCoul(mainTest.carte2);
			Ecran.afficher(")");
			Ecran.afficher("\n*** Gagne\n");
		}
		else{
			Ecran.afficher("\nCarte reponse : (");
			afficherVal(mainTest.carte2);
			Ecran.afficher(" ");
			afficherCoul(mainTest.carte2);
			Ecran.afficher(")");
			Ecran.afficher("\n*** Perdu\n");
		}
	}
	//Declaration de la classe Carte qui contient les informations sur les 2 tirages
	static class Carte{
		int carteVal = 0;
		int carteCoul = 0;
	}

	static class Main{
		Carte carte1 = new Carte();
		Carte carte2 = new Carte();
	}

	static class Coup{
		Carte tapis = new Carte();
	}
	static void afficherTapis(Coup leCoup){
		Ecran.afficher("\nCarte tapis : (");
		afficherVal(leCoup.tapis);
		Ecran.afficher(" ");
		afficherCoul(leCoup.tapis);
		Ecran.afficher(")");
	}
	// Sert a assigner une valeur a la carte du tapis
	// Cette valeur sera differente des deux autres cartes de la main
	static Carte assignerTapis(Main laMain, Coup leCoup){

		do{
			leCoup.tapis = tirageCarte(leCoup.tapis);
			Ecran.afficher("\nTapis affectee\n");
		}while(((leCoup.tapis.carteVal == laMain.carte1.carteVal) && (leCoup.tapis.carteCoul == laMain.carte1.carteCoul)) || ((leCoup.tapis.carteVal == laMain.carte2.carteVal) && (leCoup.tapis.carteCoul == laMain.carte2.carteCoul)));
	return leCoup.tapis;
	}
	/**
	 * @param Une main
	 * @return Aucun
	 * Sert a afficher les 2 cartes presentes dans une main,
	 * est affiche : la couleur et la valeur de chaque carte.
	 */
	static void affichageMain(Main laMain){
		Ecran.afficher("Cartes : [(");
		affichageCarte(laMain.carte1);
		Ecran.afficher(") (");
		affichageCarte(laMain.carte2);
		Ecran.afficher(")]");

	}
	/**
	 * @param Aucun
	 * @return Une main avec deux cartes associes qui sont differentes
	 */
	static Main tirageMain(){
		Main laMain = new Main();

		laMain.carte1 = tirageCarte(laMain.carte1);
		// On assigne une valeur a la carte2 et cela tant que carte1 == carte2
		// on aura donc pas de duplicata 	
	
		do{
			laMain.carte2 = tirageCarte(laMain.carte2);
		}while((laMain.carte1.carteVal == laMain.carte2.carteVal) && (laMain.carte1.carteCoul == laMain.carte2.carteCoul));
		Ecran.afficher("\nLe tirage de la main a ete effectuee\n");
		return laMain;
	}
	/**
	 * @param Une Carte
	 * @return Aucun
	 * Est affiche la valeur et la couleur de la carte
	 */
	static void affichageCarte(Carte laCarte){
		afficherVal(laCarte);
		Ecran.afficher(" ");
		afficherCoul(laCarte);
	}
	/**
	 * @param
	 * @param
	 * @return Vrai si des cartes sont deja affectee, faux sinon
	 */
	static boolean dejaAffectee(Carte laCarte){
		boolean condition = false;
		return condition;
	}

	/** Generation d'un nombre au "hasard"
	 * @param un entier qui sert de borne inferieur
	 * @param un entier qui sert de borne superieur
	 * @return un entier compris entre la borne inf et la borne sup comprise
	 */
	static int randomInt(int borneInf, int borneSup){
		//On genere un double compris entre 0 et 1
		double randomDouble = Math.random();
		// Calcul du nombre au hasard compris entre borneInf et borneMax
		int randomInt = (int)(randomDouble * (borneSup - borneInf + 1) + borneInf);
		return randomInt;
	}

	static Carte tirageCarte(Carte laCarte){
		laCarte.carteCoul = randomInt(1, 4);
		laCarte.carteVal = randomInt(7, 14);
		// DEBUG Ecran.afficher("Carte affectee est de ", laCarte.carteVal , laCarte.carteCoul);
		return laCarte; 

	}
	static void afficherCoul(Carte laCarte){
		switch(laCarte.carteCoul){
			case 1:{
					   Ecran.afficher("pique");
			}break;
			case 2:{
					   Ecran.afficher("coeur");
			}break;
			case 3:{
					   Ecran.afficher("carreau");
			}break;
			case 4:{
					   Ecran.afficher("trefle");
			}break;
		}
		
		

	}
	static void afficherVal(Carte laCarte){
		switch(laCarte.carteVal){
			case 7:{
					   Ecran.afficher("sept");
			}break;
			case 8:{
					   Ecran.afficher("huit");
			}break;
			case 9:{
					   Ecran.afficher("neuf");
			}break;
			case 10:{
					   Ecran.afficher("dix");
			}break;
			case 11:{
					   Ecran.afficher("valet");
			}break;
			case 12:{
					   Ecran.afficher("dame");
			}break;
			case 13:{
						Ecran.afficher("roi");
			}break;
			case 14:{
					   Ecran.afficher("as");
			}break;
			
		}

	}
}

