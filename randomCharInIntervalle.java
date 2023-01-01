public class randomCharInIntervalle{
    public static void main(String args[]){
       char test;
       test = randomChar('a', 'g'); 

    }
    /**
     * @param la borne inf
     * @param la borne sup 
     * @return un char au hasard compris entre la borne inf et max
     */
    static char randomChar(char inputa, char inputb){
        int a, b, rand;
        char randchar;
        a = (int) inputa;
        b = (int) inputb;

        //On genere un nb aleatoire
        rand = randomInt(a, b);

        //On transtype
        randchar = (char) rand;
        Ecran.afficher("Le char aleatoire est : ",randchar);
        return randchar;
    }

	static int randomInt(int borneInf, int borneSup){
		//On genere un double compris entre 0 et 1
		double randomDouble = Math.random();
		// Calcul du nombre au hasard compris entre borneInf et borneMax
		int randomInt = (int)(randomDouble * (borneSup - borneInf + 1) + borneInf);
		return randomInt;
	}
}

