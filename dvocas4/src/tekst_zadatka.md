# Laboratorijske vežbe – dvočas br. 4

## Zadatak 1
*(radi laborant u saradnji sa studentima)*


Napraviti klasu **TezineClanovaEkipe** u paketu **zadatak1** koja ima:

1. Atribut **nizTezina** koji predstavlja niz težina članova bokserske ekipe u kilogramima (npr. 89,5 kg)

2. Atribut **brojac** koji predstavlja stvarni, trenutni broj članova ekipe. Postaviti da početna vrednost bude nula.

3. Konstruktor koji inicijalizuje niz težina na kapacitet 20 i postavlja vrednosti svih 20 elemenata niza na -1.

3. Konstruktor koji kao parametar prima maksimalan broj članova ekipe (kapacitet niza), inicijalizuje niz na taj kapacitet i postavlja vrednosti svih elemenata niza na -1.

4. Metodu **unesi** koja prima kao parametar težinu novog člana ekipe i dodaje je u niz težina na prvo slobodno mesto. Dodavanje se radi samo ako niz nije popunjen do maksimuma i ako je uneta težina veća od 40.5 kg. Ako je niz popunjen ili ako težina nije u dozvoljenim granicama, potrebno je ispisati poruku "GRESKA" na ekranu.

5. Metodu **ispisi** za prikaz sadržaja niza na ekranu.

6. Metodu **pronadjiTezinu** koja kao parametar prima težinu nekog boksera i proverava da li se u nizu težina može naći bokser iste te težine. Ako može, metoda vraća true, a inače vraća false.

7. Metodu **pronadjiNajlakseg** koja pronalazi težinu najlakšeg boksera u nizu. Pronađeni broj se vraća kao povratna vrednost metode. Ako je niz prazan, metoda vraća -1.

8. Metodu **ispisiKategorije** koja ispisuje na ekranu koliko boksera iz ekipe pripada lakoj, koliko srednjoj i koliko teškoj kategoriji. Ako je težina boksera manja od 65kg on pripada lakoj kategoriji. Ako je težina 65kg ili više, ali manja od 85kg on pripada srednjoj kategoriji. Ako je težina 85kg ili više, on pripada teškoj kategoriji. Ispis bi trebalo da bude u tri reda u formatu: "Laka:4", "Srednja:1", "Teska:9"

Napraviti klasu **ProbaTezineClanovaEkipe** u paketu **zadatak1** koja u main metodi kreira dva objekta klase TezineClanovaEkipe. Inicijalizovati prvu ekipu tako da ima maksimalno 3 boksera i uneti težine 100.0, 55.5 i 44.5kg. Inicijalizovati drugu ekipu tako da se ne zna koliko maksimalno ima boksera (a nije više od 20) i uneti težine 66.6, 44.3 i 150.0 kg. Ispisati na ekranu težinu najlakšeg boksera druge ekipe.


## Zadatak 2
*(studenti rade sami)*

Napraviti klasu **VisineClanovaEkipe** u paketu **zadatak2** koja ima:

1. Atribut **nizVisina** koji predstavlja niz visina članova košarkaške ekipe u santimetrima (celi brojevi, npr. 189 cm). 

2. Atribut **brojac** koji predstavlja broj članova ekipe. Postaviti da početna vrednost bude nula.

3. Konstruktor koji parametar prima maksimalni broj članova ekipe (kapacitet niza) i inicijalizuje niz visina na uneti kapacitet samo ako je uneti broj članova ekipe veći od nule. Ako to nije slučaj, niz se inicijalizuje na kapacitet 20. U  svakom slučaju, postaviti da svi elementi niza imaju vrednost 0.

4. Metodu **unesi** koja prima kao parametar visinu novog člana ekipe i dodaje je u niz visina na prvo slobodno mesto. Dodavanje se radi samo ako niz nije popunjen do maksimuma i ako je uneta visina u rasponu od 160 do 250 cm uključujući i te vrednosti. Ako je niz popunjen ili ako visina nije u dozvoljenim granicama, potrebno je ispisati poruku "GRESKA" na ekranu.

5. Metodu **vratiProsek** koja kao povratnu vrednost vraća prosečnu visinu košarkaša u ekipi i to kao ceo broj.

6. Metodu **vratiNajvecuRazliku** koja kao povratnu vrednost vraća razliku u visini između najvišeg i najnižeg košarkaša iz niza.

Napraviti klasu **ProbaVisineClanovaEkipe** u paketu **zadatak2** koja u main metodi kreira tri objekta klase VisineClanovaEkipe sa kapacitetom od 20, 30 i 40 članova. Uneti u drugu ekipu visine 186, 169 i 224cm i ispisati na ekranu prosečnu visinu košarkaša druge ekipe.
