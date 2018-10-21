#Teht 3b

Tämä ei toimi sillä Object on yläluokka luokalle Olio ja alussa teemme listasta Olio[] listna joka määrittelee,
että lista on tyyppiä Olio. Vaikka lista tehdään uudetaan, java on viisas ja se tajuaa, että vaikka lista on määritelty olevan Object[] se tajuaa, että listassa on Olio tyyppisiä alkioita.

Jos lista olisi geneerinen ja siinä käytettäisiin wildcard <?> tyyppiä
koodi toimisi, sillä geneerinen lista ei ole alatyyppi mistään toisin kuin normaali [] lista