public class estMultiple{
	public static void main(String args[]){
		Ecran.afficherln(estMult(12, 4));
	}

	/**
	 * @param Un entier a
	 * @param Un entier b
	 * @return Vrai si a est divisible par b, faux sinon
	 */
	static boolean estMult(int a, int b){
		boolean resultat = false;
		if(b % a == 0){
			resultat = true;
		}

		return resultat;
		
	}
}
