public class retourneAnnee{

    public static void main(String args[]){
        Date laDate = new Date();
        laDate = saisirDate();
        affichageDate(laDate);
    }

    
    //Declaration du type date
    static class Date{
        int annee;
        int mois;
        int jour;
    }
    /** Affiche la date sous le format jour mois annee, avec mois ecrit
     * @param Une date 
     * @return Rien
     */
    static void affichageDate(Date laDate){
        String leMois = "";
        switch(laDate.mois){
            case 1:
                leMois = "janvier";
                break;

            case 2:
                leMois = "fevrier";
                break;

            case 3:
                leMois = "mars";
                break;

            case 4:
                leMois = "avril";
                break;

            case 5:
                leMois = "mai";
                break;

            case 6: 
                leMois = "juin";
                break;

            case 7:
                leMois = "juillet";
                break;

            case 8:
                leMois = "aout";
                break;

            case 9:
                leMois = "septembre";
                break;

            case 10:
                leMois = "octobre";
                break;

            case 11:
                leMois = "novembre";
                break;

            case 12:
                leMois = "decembre";
                break;

        }
        Ecran.afficher(laDate.jour," ", leMois," ", laDate.annee);
    }
    /**
     * @param Rien
     * @return Une date correcte saisie par l'utilisateur
     */
    static Date saisirDate(){

        //Declaration des variables
        Date saisieDate = new Date();
        int limite;
        boolean correct = false;
        boolean bissextile = false;

        do{
            // On demande a l'utilisateur de saisir sa date
            Ecran.afficher("\nVeuillez saisir l'annee : ");
            saisieDate.annee = Clavier.saisirInt();

            Ecran.afficher("\nVeuillez saisir le mois : ");
            saisieDate.mois = Clavier.saisirInt();

            Ecran.afficher("\nVeuillez saisir le jour : ");
            saisieDate.jour = Clavier.saisirInt();

            // On regarde si la date est bissextile ou non
            bissextile = estBiss(saisieDate.annee); 

            if(bissextile && saisieDate.mois == 2){
                limite = 29;
            }

            else if(saisieDate.mois == 2){
                limite = 28;
            }

            else if(saisieDate.mois == 1 || saisieDate.mois == 3 || saisieDate.mois == 5 || saisieDate.mois == 7 || saisieDate.mois == 8 || saisieDate.mois == 10 || saisieDate.mois == 12){
                limite = 31;
            }

            else{
                limite = 30;
            }

            //On regarde si la mois saisi est correct :
            if(saisieDate.jour > limite){
                Ecran.afficher("\nErreur, le jour entre n'est pas correct");
            }

            else if(saisieDate.annee < 1){
                Ecran.afficher("\nSaisie de l'annee invalide");
            }

            else if(saisieDate.jour < 1){
                Ecran.afficher("\nSaisie du jour invalide");
            }

            else if(saisieDate.mois > 12 || saisieDate.mois < 1){
                Ecran.afficher("\nSaisie mois invalide");
            }

            else{
                Ecran.afficher("\nSaisie correcte !");
                correct = true;
            }
        }while(!correct);

        // On retourne le resultat :
        return saisieDate;

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
