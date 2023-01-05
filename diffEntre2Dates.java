public class diffEntre2Dates {
    public static void main(String args[]) {
        Date a = new Date();
        Date b = new Date();
        a.annee = 2020;
        a.mois = 2;
        a.jour = 4;

        b.annee = 2022;
        b.mois = 10;
        b.jour = 14;

        afficherDifference(a, b);
    }
    static class Date{
        int annee;
        int mois;
        int jour;
    }
    static void afficherDifference(Date date1, Date date2) {
        int nbJours = 0, nbMois = 0, nbAnnees = 0;

        // On calcule d'abord la différence en années
        nbAnnees = date2.annee - date1.annee;
        // Si le mois de la date2 est avant le mois de la date1, on retire 1 année
        if (date2.mois < date1.mois) {
            nbAnnees--;
        }
        // Si le mois de la date2 est le même que le mois de la date1, on vérifie le jour
        else if (date2.mois == date1.mois) {
            if (date2.jour < date1.jour) {
                nbAnnees--;
            }
        }

        // On calcule maintenant la différence en mois, en prenant en compte la déduction d'années précédemment effectuée
        nbMois = date2.mois - date1.mois;
        if (date2.jour < date1.jour) {
            nbMois--;
        }
        if (nbMois < 0) {
            nbMois += 12;
            nbAnnees--;
        }

        // On calcule enfin la différence en jours
        nbJours = date2.jour - date1.jour;
        if (nbJours < 0) {
            // On ajuste le nombre de jours en fonction du nombre de jours dans le mois précédent
            int nbJoursMoisPrecedent = getNombreJoursMois(date1.mois - 1, date1.annee);
            nbJours += nbJoursMoisPrecedent;
            nbMois--;
            if (nbMois < 0) {
                nbMois += 12;
                nbAnnees--;
            }
        }

        System.out.println(nbAnnees + " ans, " + nbMois + " mois, " + nbJours + " jours");
    }

    // Fonction qui retourne le nombre de jours dans un mois donné (en prenant en compte les années bissextiles)
    static int getNombreJoursMois(int mois, int annee) {
        switch (mois) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            return 31;
            case 4: case 6: case 9: case 11:
            return 30;
            case 2:
            // On vérifie si l'année est bissextile
            if (estAnneebissextile(annee)) {
                return 29;
            }
            else {
                return 28;
            }
            default:
            System.out.println("erreur !");
            return 0;
        }
    }

	static boolean estAnneebissextile(int annee){
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
