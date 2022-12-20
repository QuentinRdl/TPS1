public class tableMulti{

	public static void main(String args[]){
		afficherTableMulti(4);

	}
	static void afficherTableMulti(int table){
		for(int i = 0; i <= 10; i++){
			Ecran.afficherln(i, " * ", table, " = ", table * i);
		}
	}
}
