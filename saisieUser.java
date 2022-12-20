public class saisieUser{

	public static void main(String args[]){
		saisieInt(1, 5);
	}
	/**
	 * Renvoie une valeur comprise entre borneInf et borneSup compris 
	 * @param un entier borneInf
	 * @param un entier borneSup
	 * @return un entier compris ou egal a borneInf et borneSup
	 */
	static int saisieInt(int borneInf, int borneSup){
		int saisie;
		System.out.printf("Entrez un int compris entre ", borneInf, " et ", borneSup, " ");
		saisie = Clavier.saisirInt();
		while((saisie < borneInf) || (saisie > borneSup)){

			System.out.print("Erreur de saisie, merci de recommencer : ");
			saisie = Clavier.saisirInt();

		}

		return saisie;
	}
}
