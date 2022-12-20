public class fibonacci{
	public static void main(String args[]){
	
		printFibo(9);	
	}

	static int returnFibo(int fn1, int fn2){
		int fib;
		fib = fn1 + fn2;
		return fib;
	}

	static void printFibo(int limite){
		int fn1; int fn2; int fn;
		limite = limite - 2; 
		fn1 = 0;
		fn2 = 1;
		fn = fn1 + fn2;
		Ecran.afficherln(fn1);
		Ecran.afficherln(fn2);
		for(int i = 1; i <= limite; i++){
			fn = returnFibo(fn1, fn2);
			fn1 = fn2;
			fn2 = fn;
			Ecran.afficherln(fn);

		}
	}
}
