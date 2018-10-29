package zadatak1;

class ProbaTezineClanovaEkipe {

	public static void main(String[] args) {
		TezineClanovaEkipe ekipa1 = new TezineClanovaEkipe(3);
		
		ekipa1.unesi(100.0);
		ekipa1.unesi(55.5);
		ekipa1.unesi(44.5);
		
		TezineClanovaEkipe ekipa2 = new TezineClanovaEkipe();
		
		ekipa2.unesi(66.6);
		ekipa2.unesi(44.3);
		ekipa2.unesi(150.0);
		
		System.out.println( ekipa2.pronadjiNajlakseg());
	}

}
