public class randomValues{
	public static void main(String args[]){
		for(int i = 0; i <= 20; i++){
			int a = randomInt(1, 4);
			Ecran.afficher(a);
		}
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
}
