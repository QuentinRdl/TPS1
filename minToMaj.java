public class minToMaj{

	public static void main(String args[]){
		char a = 'q';
		Ecran.afficher(a);
		a = minVersMaj(a);
		Ecran.afficher(a);
		a = majVersMin(a);			
		Ecran.afficher(a);
	}
	/**
	 * Sert a changer une minusucle en majucule
	 * @param un char de lettre minuscule
	 * @return le meme char en majuscule
	 */
	static char minVersMaj(char min){
		
		int entiermin = (int) min;
		entiermin = entiermin-32;
		return (char)entiermin;
	}
	/**
	 * Sert a changer une lettre majuscule en minuscule
	 * @param un char de lettre majuscule
	 * @return le meme char en minuscule
	 */
	static char majVersMin(char maj){	
		int entiermaj = (int) maj;
		if (entiermaj < 65){
			Ecran.afficher("\nErreur le char saisie n'est pas une lettre\n");
			return maj;
		}
		entiermaj = entiermaj + 32;
		return (char)entiermaj;
	}
}
