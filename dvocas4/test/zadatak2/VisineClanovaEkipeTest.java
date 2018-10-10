package zadatak2;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VisineClanovaEkipeTest {
	
	VisineClanovaEkipe instance;

	@Before
	public void setUp() throws Exception {
		instance = new VisineClanovaEkipe(5);
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test (timeout = 2000)
	public void konstruktor_VisineClanovaEkipe() {
		assertEquals("Kad se pozove sa brojem 5, ne inicijalizuje niz na 5 elemenata", 5, instance.nizVisina.length);
		
		for(int visina: instance.nizVisina)
			assertEquals("Element niza nije inicijalizovan na 0", 0, visina);

	}

	@Test (timeout = 2000)
	public void konstruktor_VisineClanovaEkipe_NegativanParametar() {
		instance = new VisineClanovaEkipe(-10);
		
		assertEquals("Kad se pozove sa brojem -10, ne inicijalizuje niz na 20 elemenata", 20, instance.nizVisina.length);
		
		for(int visina: instance.nizVisina)
			assertEquals("Element niza nije inicijalizovan na 0", 0, visina);
	}
	
	@Test (timeout = 2000)
	public void testUnesi() {
		instance.unesi(180);
		instance.unesi(169);
		
		assertEquals("Ako se unesu dva elementa, metoda u niz ne ubaci oba kako treba, brojac nije 2", 2, instance.brojac);
		assertEquals("Unet je prvi element 180, ali nije postavljen na prvo mesto u nizu", 180, instance.nizVisina[0]);
		assertEquals("Unet je drugi element 169, ali nije postavljen na drugo mesto u nizu", 169, instance.nizVisina[1]);
		assertEquals("Unet je i treci element, a trebalo je da ostane 0", 0, instance.nizVisina[2]);
		assertEquals("Unet je i cetvrti element, a trebalo je da ostane 0", 0, instance.nizVisina[3]);
		assertEquals("Unet je i peti element, a trebalo je da ostane 0", 0, instance.nizVisina[4]);
	}
	
	@Test(timeout = 2000)
	public void metoda_unesiVisinaPremala() {
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance.unesi(159);

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("Za unetu visinu 159 koja je premala NE ispisuje se rec GRESKA na ekranu", ispis.trim().equalsIgnoreCase("GRESKA"));
			assertEquals("Ipak je povecan brojac iako nije trebalo jer je visina premala", 0, instance.brojac);
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}

	@Test(timeout = 2000)
	public void metoda_unesiVisinaPrevelika() {
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance.unesi(251);

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("Za unetu visinu 251 koja je prevelika NE ispisuje se rec GRESKA na ekranu", ispis.trim().equalsIgnoreCase("GRESKA"));
			assertEquals("Ipak je povecan brojac iako nije trebalo jer je visina prevelika", 0, instance.brojac);
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}

	@Test(timeout = 2000)
	public void metoda_unesiNizPun() {
		instance.unesi(180);
		instance.unesi(190);
		instance.unesi(210);
		instance.unesi(182);
		instance.unesi(195);

		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance.unesi(199);

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("Za pokusaj unosa kad je niz vec pun NE ispisuje se rec GRESKA na ekranu", ispis.trim().equalsIgnoreCase("GRESKA"));
			assertEquals("Ipak je povecan brojac iako nije trebalo jer je niz pun", 5, instance.brojac);
			assertNotEquals("Ipak je uneta tezina iako je niz pun", 199, instance.nizVisina[4]);
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}

	@Test (timeout = 2000)
	public void testVratiProsek() {
		instance.unesi(180);
		instance.unesi(169);
		instance.unesi(190);
		
		assertEquals("Za visine 180, 169 i 190, prosek bi trebalo da bude 179", 179, instance.vratiProsek());
	}

	@Test (timeout = 2000)
	public void testVratiNajvecuRazliku() {
		instance.unesi(180);
		instance.unesi(169);
		instance.unesi(190);
		instance.unesi(160);

		assertEquals("Za visine 180, 169, 190 i 160, razlika izmedju najviseg (190) i najnizeg (160) bi trebalo da bude 30 cm", 30, instance.vratiNajvecuRazliku());
	}

}
