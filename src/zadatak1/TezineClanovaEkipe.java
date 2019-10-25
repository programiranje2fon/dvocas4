package zadatak1;

class TezineClanovaEkipe {
	
	double[] nizTezina;
	int brojac = 0;
	
	TezineClanovaEkipe(){
		nizTezina = new double[20];
		
		for(int i=0; i<nizTezina.length; i++)
			nizTezina[i] = -1;
	}
	
	TezineClanovaEkipe(int kapacitet){
		nizTezina = new double[kapacitet];
		
		for(int i=0; i<nizTezina.length; i++)
			nizTezina[i] = -1;
	}
	
	void unesi(double novaTezina) {
		if (brojac < nizTezina.length && novaTezina >= 40.5) {
			nizTezina[brojac] = novaTezina;
			brojac++;
		}
		else
			System.out.println("GRESKA");
	}
	
	void ispisi() {
		for(int i=0; i<brojac; i++)
			System.out.println(nizTezina[i]);
	}
	
	double pronadjiNajlakseg() {
		if (brojac == 0)
			return -1;
		
		double min = nizTezina[0];
		
		// ne moze forEach jer se ide do brojaca a ne do length
		for(int i=0; i<brojac; i++)
			if (nizTezina[i] < min) min = nizTezina[i];
		
		return min;
	}
	
	boolean pronadjiTezinu(double trazenaTezina) {
		for(int i=0; i<brojac; i++)
			if (nizTezina[i] == trazenaTezina)
				return true;
		
		return false;
	}
	
	void ispisiKategorije() {
		int brojLakih = 0;
		int brojSrednjih = 0;
		int brojTeskih = 0;
		
		// ne moze forEach jer se ide do brojaca a ne do length
		for(int i=0; i<brojac; i++)
			if (nizTezina[i] < 65) brojLakih++;
			else if (nizTezina[i] < 85) brojSrednjih++;
			else brojTeskih++;
			
		System.out.println("Laka:" + brojLakih);
		System.out.println("Srednja:" + brojSrednjih);
		System.out.println("Teska:" + brojTeskih);
	}

}
