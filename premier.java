public class premier{
    public static void main(String args[]){
        boolean preums;
        int a = 14;
        int b = 13;
        int c = 4;
        int d = 5;
        preums = isPrime(a);
        Ecran.afficherln(a, " premier est : ", preums);
        preums = isPrime(b);
        Ecran.afficherln(b, " premier est : ", preums);
        preums = isPrime(c);
        Ecran.afficherln(c, " premier est : ", preums);
        preums = isPrime(d);
        Ecran.afficherln(d, " premier est : ", preums);
    }
    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
