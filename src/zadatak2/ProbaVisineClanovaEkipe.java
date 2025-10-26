package zadatak2;

public class ProbaVisineClanovaEkipe {

	public static void main(String[] args) {
		VisineClanovaEkipe vek1 = new VisineClanovaEkipe(20);
		VisineClanovaEkipe vek2 = new VisineClanovaEkipe(30);
		VisineClanovaEkipe vek3 = new VisineClanovaEkipe(40);

		vek2.unesi(186);
		vek2.unesi(169);
		vek2.unesi(224);
		
		System.out.println("Prosecna visina: " + vek2.vratiProsek());
	}

}
