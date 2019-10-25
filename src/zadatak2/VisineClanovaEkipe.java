package zadatak2;

class VisineClanovaEkipe {
	
	int[] nizVisina;
	int brojac = 0;
	
	public VisineClanovaEkipe(int kapacitet) {
		if (kapacitet > 0)
			nizVisina = new int[kapacitet];
		else
			nizVisina = new int[20];
		
		for(int i=0; i<nizVisina.length; i++)
			nizVisina[i] = 0;
	}
	
	void unesi(int novaVisina) {
		if (brojac < nizVisina.length && novaVisina >= 160 && novaVisina <= 250) {
			nizVisina[brojac] = novaVisina;
			brojac++;
		}
		else
			System.out.println("GRESKA");
	}
	
	int vratiProsek() {
		int suma = 0;
		
		for(int i=0; i < brojac; i++)
			suma = suma + nizVisina[i];
		
		return suma / brojac;
	}
	
	int vratiNajvecuRazliku() {
		int min = nizVisina[0];
		int max = nizVisina[0];
		
		for (int i = 0; i < brojac; i++) {
			if (nizVisina[i] < min) min = nizVisina[i];
			if (nizVisina[i] > max) max = nizVisina[i];
		}
		
		return (max - min);
	}

}
