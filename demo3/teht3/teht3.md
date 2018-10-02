# Teht3

a)

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

b)
	
	Analyysiluokat
		PeliMaailma
			-Luo koko peli-ikkunan ja sen sisällön
		FysiikkaMoottori
			-Laskee jatkuvasti banaanin koordinaatteja, tarkistaa onko lentoradalla objekteja,
			määrittelee tuulen suuntaa ja nopeutta
	