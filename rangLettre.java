/**Coder un programme ayant cet effet : une lettre de l’alphabet est saisie. Si l’utilisateur saisit
autre chose qu’une lettre alors le programme affiche un message signalant le problème de saisie.
Si l’utilisateur saisit une lettre, le programme permet d’afficher si cette lettre est minuscule ou
majuscule et le rang de cette lettre dans l’alphabet.
On ne demande pas une solution structurée en sous-algorithmes.
*/

public class rangLettre{
		
		public static void main(String args[]){

            leRang('a');
            leRang('A');
            leRang('z');
            leRang('Z');
            leRang('?');
        //A = 65
        //Z = 90
        //a = 97
        //z = 122
    }

    /** Renvoie le rang de la lettre 
    * @param La lettre
    * @return rien
    * Le rang de la lettre est affiche
    */
    static void leRang(char laLettre){

        //On verifie la saisie
       
        int entierLettre = (int) laLettre;
        String majOuNon;

        if(((entierLettre < 65) || ((entierLettre > 90) && (entierLettre <97)) || entierLettre > 122)){
            Ecran.afficher("\nSaisie incorrecte !");
            return;
        }

        if(entierLettre <= 90){
            majOuNon = "majuscule";
            entierLettre -= 64;
        }

        else{
            majOuNon = "minscule";
            entierLettre -= 96;
        }

        //Affichage du resultat
        Ecran.afficher("\nLa lettre ", laLettre, " est une lettre ", majOuNon , " de rang : ", entierLettre);
    }

}
