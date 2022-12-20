public class bissextile{
	public static void main(String args[]){
		int a = saisieBiss();
		Ecran.afficher("L'annee ", a, " est bissextile\n");
	}
	/** Renvoie une annee bissextile saisie par l'utilisateur
	 * @param Aucun
	 * @return Une annee bissextile saisie par l'utilisateur
	 */
	static int saisieBiss(){
		int saisie;
		Ecran.afficherln("Veuillez saisir une annee bissextile : ");
		saisie = Clavier.saisirInt();
		while(estBiss(saisie) == false){
			Ecran.afficher("Erreur, l'annee saisie n'est pas bissextile !\nVeillez re iterer votre saisie : ");
		Ecran.afficherln("Veuillez saisir une annee bissextile : ");
		saisie = Clavier.saisirInt();

		}
		return saisie;
		}
	/**
	 * @param Un entier annee
	 * @return Vrai si l'annee est bissextile, faux sinon
	 */
	static boolean estBiss(int annee){
		boolean biss = false;
		if (annee % 4 == 0){
			biss = true;
			if(annee % 100 == 0){
				biss = false;
				if(annee % 400 == 0){
					biss = true;
				}
			}
		}
		return biss;
	}
}
