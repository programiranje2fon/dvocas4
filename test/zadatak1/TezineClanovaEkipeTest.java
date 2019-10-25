package zadatak1;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TezineClanovaEkipeTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	TezineClanovaEkipe instance;

	@Before
	public void setUp() throws Exception {
		instance = new TezineClanovaEkipe(5);
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@Test(timeout = 2000)
	public void konstruktor_TezineClanovaEkipe() {
		instance = new TezineClanovaEkipe();

		assertEquals("Kapacitet niza nije 20", 20, instance.nizTezina.length);

		for (double tezina : instance.nizTezina)
			assertEquals("Element niza nije inicijalizovan na -1", -1, tezina, 0.001);
	}

	@Test(timeout = 2000)
	public void konstruktor_TezineClanovaEkipe_Int() {
		instance = new TezineClanovaEkipe(5);

		assertEquals("Ako se unese kapacitet 5, kapacitet niza nije 5", 5, instance.nizTezina.length);

		for (double tezina : instance.nizTezina)
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
	public void metoda_unesi_kilazaPremala() {
		instance.unesi(40.0);

		assertTrue("Za unetu tezinu 40.0 koja je premala NE ispisuje se rec GRESKA na ekranu", outContent.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		assertEquals("Ipak je povecan brojac iako nije trebalo jer je tezina premala", 0, instance.brojac);
	}

	@Test(timeout = 2000)
	public void metoda_unesi_nizPun() {
		instance.unesi(110.5);
		instance.unesi(82.3);
		instance.unesi(110.5);
		instance.unesi(82.3);
		instance.unesi(110.5);

		instance.unesi(99.9);

		assertTrue("Za pokusaj unosa kad je niz vec pun NE ispisuje se rec GRESKA na ekranu", outContent.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		assertEquals("Ipak je povecan brojac iako nije trebalo jer je niz pun", 5, instance.brojac);
		assertNotEquals("Ipak je uneta tezina iako je niz pun", 99.9, instance.nizTezina[4], 0.001);
	}

	@Test(timeout = 2000)
	public void metoda_ispisi() {
		instance.unesi(110.5);
		instance.unesi(82.3);

		instance.ispisi();

		String ocekivaniIspis = "110.5" + System.lineSeparator() + "82.3" + System.lineSeparator();
		ocekivaniIspis = ocekivaniIspis.replaceAll("\\s", "");

		String ispis = outContent.toString();
		ispis = ispis.replaceAll("\\s", "");

		assertTrue("Za unete tezine 110.5 i 82.3 NE ispisuju se te tezine na ekranu", ispis.equalsIgnoreCase(ocekivaniIspis));
	}

	@Test(timeout = 2000)
	public void metoda_pronadjiNajlakseg() {
		instance.unesi(110.5);
		instance.unesi(82.3);
		instance.unesi(50.0);
		instance.unesi(182.3);

		assertEquals("Za uneti niz tezina {110.5, 82.3, 50.0, 182.3}, metoda kao minimum ne vraca 50.0", 50.0, instance.pronadjiNajlakseg(), 0.001);
	}

	@Test(timeout = 2000)
	public void metoda_pronadjiTezinu_true() {
		instance.unesi(110.5);
		instance.unesi(82.3);
		instance.unesi(50.0);
		instance.unesi(182.3);

		assertEquals("Za uneti niz tezina {110.5, 82.3, 50.0, 182.3}, metoda ne pronalazi 50.0 u nizu", true, instance.pronadjiTezinu(50.0));
	}

	@Test(timeout = 2000)
	public void metoda_pronadjiTezinu_false() {
		instance.unesi(110.5);
		instance.unesi(82.3);
		instance.unesi(50.0);
		instance.unesi(182.3);

		assertEquals("Za uneti niz tezina {110.5, 82.3, 50.0, 182.3}, metoda pronalazi 112.3 u nizu a ne bi trebalo", false, instance.pronadjiTezinu(112.3));
	}

	@Test(timeout = 2000)
	public void metoda_ispisiKategorije() {
		instance.unesi(110.5);
		instance.unesi(82.3);
		instance.unesi(50.0);
		instance.unesi(182.3);

		instance.ispisiKategorije();

		String ocekivaniIspis = "Laka:1" + System.lineSeparator() + "Srednja:1 " + System.lineSeparator() + "Teska:2" + System.lineSeparator();
		ocekivaniIspis = ocekivaniIspis.replaceAll("\\s", "");

		String ispis = outContent.toString();
		ispis = ispis.replaceAll("\\s", "");

		assertTrue("Za unete tezine 110.5, 82.3, 50.0 i 182.3, NE ispisuju se te tezine na ekranu", ocekivaniIspis.equalsIgnoreCase(ispis));
	}

}
