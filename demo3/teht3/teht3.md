# Teht3

# a)

	Entiteetit
		Pelimaailma
			-koko
			-lukumäärä: 1
		Rakennus
			-lukumäärä: n
			-väri
			-sijainti
			Ikkunat
				-lukumäärä: n
				-valaistus: kyllä/ei
				-sijainti
		Gorilla
			-lukumäärä: 2
			-sijainti
			-poistaGorilla()
			-luoGorilla()
		Aurinko
			-ilme
			-sijainti
		Pistelaskuri
			-pistemäärä
		PeliLogiikka
			-heittovuoro
			-lisääPisteitä()
			-aloitus()
			-lopetus()
			-erä
			-osuma()
		Banaani
			-sijainti
		Fysiikkamoottori
			-banaanin liiketila
			-tuuli

# b)
	
	Analyysiluokat
		PeliMaailma
			-Luo koko peli-ikkunan ja sen sisällön
		FysiikkaMoottori
			-Laskee jatkuvasti banaanin koordinaatteja, tarkistaa onko lentoradalla objekteja,
			määrittelee tuulen suuntaa ja nopeutta
		PeliLogiikka
			-Määrittelee miten peli alkaa, loppuu, miten se toimii
			
	Suunnitteluluokat
		TuuliNuoli
			-Ei muuta toiminnallisuutta kuin nuolen piirto ikkunaan
			-Tekee nuolen FysiikkaMoottorin tietojen perusteella
		Aurinko
			-Tarkoitus saada Auringolle sijainti ja muuttaa ilmettä osumasta
		
	Toteutusluokat
		Pistelaskuri
			-Säilöö piste- ja erätilanteen
		Rakennus
			-Kordinaatit auttavat gorillojen sijoittamisessa sekä banaanin osumisen tarkastelussa
		Banaani
			-Kaikki banaanin animaatiot 
			-sijainti
			
# c)

	Paketti#1 (dynaamiset asiat)
		FysiikkaMoottori
		PeliLogiikka
		Gorilla
		Pistelaskuri
		TuuliNuoli
		Banaani
	Paketti#2 (staattiset asiat)
		Pelimaailma
		Rakennus
			Ikkuna
		Aurinko
		
# d)

	Pelimaailma
		-Luo pohjan pelissä tapahtuville ja liikkuville objekteille.
	Fysiikkamoottori
		-Voidaan uudellenkäyttää tarvittaessa kun tarvitaan kappaleiden liikeratoja tuulisessa tyhjiössä.
	Gorilla
		-Voidaan käyttää paikallaan pysyvänä objektina, jolla on toiminnallisuus.
	Pistelaskuri
		-Voidaan käyttää laskemaan pisteitä muissakin kahden pelaajan peleissä.
		
# e)

Näin yksinkertaisessa pelissä fysiikan lait on helpompi toteuttaa metodeilla, koska fysiikkamalli on niin yksinkertaistettu (heittoliike ilman vastusvoimia). Jos liikkuvia kappaleita olisi samanaikaisesti suurempi lukumäärä, ohjelma voisi olla turhan raskas.  

Luokkatotetuksen etuna olisi, jos pelin fysiikka ei olisi näin yksinkertainen (esim. törmäyksiä kappaleilla joilla on eriävä massa).
	
	
		
			
		
		
	