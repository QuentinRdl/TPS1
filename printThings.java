public class printThings{
	public static void main(String args[]){
		printLadder(15, 10);
	}
	/**
	 * @param Un entier qui correspond a la longeur de l'echelle
	 * @param Un entier qui correspond a la taille de l'echelle
	 * @return Rien, seulement une echelle sera affichee
	 */
	static void printLadder(int lenght, int height){
		for(int i = 1; i <= height; i++){
			Ecran.afficher("*");
			for(int j = 1; j <= lenght; j++){
				Ecran.afficher(".");
			}
			Ecran.afficher("*\n");
		}
		
	}
}
