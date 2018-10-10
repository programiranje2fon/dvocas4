package zadatak1;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TezineClanovaEkipeTest {
	
	TezineClanovaEkipe instance;

	@Before
	public void setUp() throws Exception {
		instance = new TezineClanovaEkipe(5);
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test(timeout = 2000)
	public void konstruktor_TezineClanovaEkipe() {
		instance = new TezineClanovaEkipe();
		
		assertEquals("Kapacitet niza nije 20", 20, instance.nizTezina.length);
		
		for(double tezina: instance.nizTezina)
			assertEquals("Element niza nije inicijalizovan na -1", -1, tezina, 0.001);
	}

	@Test(timeout = 2000)
	public void konstruktor_TezineClanovaEkipeInt() {
		instance = new TezineClanovaEkipe(5);
		
		assertEquals("Ako se unese kapacitet 5, kapacitet niza nije 5", 5, instance.nizTezina.length);
		
		for(double tezina: instance.nizTezina)
			assertEquals("Element niza nije inicijalizovan na -1", -1, tezina, 0.001);
	}

	@Test(timeout = 2000)
	public void metoda_unesi() {
		instance.unesi(100.5);
		instance.unesi(52.3);
		
		assertEquals("Ako se unesu dva elementa, metoda u niz ne ubaci oba kako treba, brojac nije 2", 2, instance.brojac);
		assertEquals("Unet je prvi element 100.5, ali nije postavljen na prvo mesto u nizu", 100.5, instance.nizTezina[0], 0.001);
		assertEquals("Unet je drugi element 52.3, ali nije postavljen na drugo mesto u nizu", 52.3, instance.nizTezina[1], 0.001);
		assertEquals("Unet je i treci element, a trebalo je da ostane -1", -1, instance.nizTezina[2], 0.001);
		assertEquals("Unet je i cetvrti element, a trebalo je da ostane -1", -1, instance.nizTezina[3], 0.001);
		assertEquals("Unet je i peti element, a trebalo je da ostane -1", -1, instance.nizTezina[4], 0.001);

	}
	
	@Test(timeout = 2000)
	public void metoda_ispisi() {
		instance.unesi(110.5);
		instance.unesi(82.3);

		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance.ispisi();

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			String s = "110.5" + System.lineSeparator() + "82.3" + System.lineSeparator();

			assertEquals("Za unete tezine 110.5 i 82.3 NE ispisuju se te tezine na ekranu", s.trim(), ispis.trim());
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}

	@Test(timeout = 2000)
	public void metoda_pronadjiNajlakseg() {
		instance.unesi(110.5);
		instance.unesi(82.3);
		instance.unesi(50.0);
		instance.unesi(182.3);
		
		assertEquals("Za uneti niz tezina {110.5, 82.3, 50.0, 182.3}, metoda kao minimum ne vraca 50.0",50.0, instance.pronadjiNajlakseg(), 0.001);
	}
	
	@Test(timeout = 2000)
	public void metoda_pronadjiTezinuTrue() {
		instance.unesi(110.5);
		instance.unesi(82.3);
		instance.unesi(50.0);
		instance.unesi(182.3);
		
		assertEquals("Za uneti niz tezina {110.5, 82.3, 50.0, 182.3}, metoda ne pronalazi 50.0 u nizu",true, instance.pronadjiTezinu(50.0));
	}
	
	@Test(timeout = 2000)
	public void metoda_pronadjiTezinuFalse() {
		instance.unesi(110.5);
		instance.unesi(82.3);
		instance.unesi(50.0);
		instance.unesi(182.3);
		
		assertEquals("Za uneti niz tezina {110.5, 82.3, 50.0, 182.3}, metoda pronalazi 112.3 u nizu a ne bi trebalo",false, instance.pronadjiTezinu(112.3));
	}

	@Test(timeout = 2000)
	public void metoda_ispisiProcente() {
		instance.unesi(110.5);
		instance.unesi(82.3);
		instance.unesi(50.0);
		instance.unesi(182.3);
		
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance.ispisiKategorije();

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			String s = "Laka:1" + System.lineSeparator() + "Srednja:1" + System.lineSeparator() + "Teska:2" + System.lineSeparator();

			assertEquals("Za unete tezine 110.5 i 82.3 NE ispisuju se te tezine na ekranu", s.trim(), ispis.trim());
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
		
	}

}
