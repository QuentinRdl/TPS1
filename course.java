/**Exercice 4 – Course à pied
Gestion d’une finale d’athlétisme avec 3 coureurs.
On considère une course à pied avec 3 coureurs à départager dans cette finale.
La course comprend une date et les trois coureurs.
Un coureur est défini par son numéro de dossard (un entier) et le temps (nombre entier égal au
nombre de minutes que le coureur a mis pour effectuer la course).
La course se déroule en 2020. La date comprend donc une année égale à 2020.
*/

public class course{

    public static void main(String args[]){ 
        Course notreCourse = new Course();
        Temps heureDepart = new Temps();
        heureDepart.heure = 14;
        heureDepart.minute = 45;
        initCourse(notreCourse, heureDepart);
    }
    static void initCourse(Course notreCourse, Temps heureDepart){
        Date dateCourse = new Date();

        notreCourse.c1.nbdossard = 1;
        notreCourse.c2.nbdossard = 2;
        notreCourse.c3.nbdossard = 3;

        dateCourse = saisirDate();
        
        //On genere un temps aleatoire differents pour chaque coureur
        tempsCoureurs(notreCourse, heureDepart);
        affichageCourse(dateCourse, notreCourse, heureDepart);

    } 

    static void calculTempsCourse(Temps heureDepart, Coureur leCoureur){
        leCoureur.arrive.heure = heureDepart.heure;

        leCoureur.arrive.minute = heureDepart.minute;
        leCoureur.arrive.minute += leCoureur.tempsDeCourse;

        while(leCoureur.arrive.minute > 60){
            leCoureur.arrive.minute -= 60;
            leCoureur.arrive.heure += 1;
        }
    } 
    // Declaration du type Coureur qui contient les informations les concernant
    static class Coureur{
        int nbdossard;
        int tempsDeCourse;
        Temps arrive = new Temps();
    }
    // Declaration du type course qui contient toutes les informations utiles
    static class Course{
        Coureur c1 = new Coureur();
        Coureur c2 = new Coureur();
        Coureur c3 = new Coureur();
    }

    // Declaration du type date
    static class Date{
        int annee;
        int mois;
        int jour;
    }
    // Declaration du type temps 
    static class Temps{
        int heure;
        int minute;
    }
    /** Genre un temps aleatoire different pour chaque coureur
     * @param Les coureurs avec le type Course
     * @return rien
     */
        static void tempsCoureurs(Course laCourse, Temps heureDepart){
            do{
                laCourse.c1.tempsDeCourse = randomInt(1, 100);
                laCourse.c2.tempsDeCourse = randomInt(1, 100);
                laCourse.c3.tempsDeCourse = randomInt(1, 100);
            }while(laCourse.c1.tempsDeCourse == laCourse.c2.tempsDeCourse || laCourse.c3.tempsDeCourse == laCourse.c2.tempsDeCourse ||laCourse.c1.tempsDeCourse == laCourse.c3.tempsDeCourse);
            calculTempsCourse(heureDepart, laCourse.c1);
            calculTempsCourse(heureDepart, laCourse.c2);
            calculTempsCourse(heureDepart, laCourse.c3);
        }
    /** Affichage des differentes informations de la course
     * @param La date du jour
     * @param Les informations de la course contenus dans le type Date
     * @return Rien
     */
    static void affichageCourse(Date laDate, Course laCourse, Temps heureDepart){
        // On affiche d'abord la date
        Ecran.afficher("\nDate : ", laDate.jour, "/", laDate.mois,"/", laDate.annee);

        // On affiche l'heure
        Ecran.afficher("\nHoraire de depart : ", heureDepart.heure, " h ", heureDepart.minute);
        // On affiche les informations qui concernent les coureurs
        Ecran.afficher("\nDossard ", laCourse.c1.nbdossard, " : ", laCourse.c1.tempsDeCourse, " minutes");
        Ecran.afficher(" --> arrive(e) a : ", laCourse.c1.arrive.heure, " h ", laCourse.c1.arrive.minute);
        Ecran.afficher("\nDossard ", laCourse.c2.nbdossard, " : ", laCourse.c2.tempsDeCourse, " minutes");
        Ecran.afficher(" --> arrive(e) a : ", laCourse.c2.arrive.heure, " h ", laCourse.c2.arrive.minute);
        Ecran.afficher("\nDossard ", laCourse.c3.nbdossard, " : ", laCourse.c3.tempsDeCourse, " minutes");
        Ecran.afficher(" --> arrive(e) a : ", laCourse.c3.arrive.heure, " h ", laCourse.c3.arrive.minute);
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
