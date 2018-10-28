# Demo 5 tehtävä 2c

Luokassa TasaArvoSoturi, luokka määrittelyssä ei ole mitään vikaa.

Toisessa määrittelyssä on vikana se, että Object tarkoittaa sitä, että comperable voi olla ihan mikä vain muu olio, joka voi tuottaa suuria onglemia ja myös kun palautetaan -1 se tarkoittaa yleisesti ettei oliota löytynyt. Tämä voi aiheuttaa sen, että esim vertail

Kolmannessa ei ole mitään ongelmaa, sillä hashcode palauttaa ainakin melkein aina eri arvon, joten ei tule duplicaatteja

Neljännessä ei sinäänsä ole ongelmia, mutta jos kahdella on sama hashcode niin esim hashmapissa ne menevät samaan ämpäriin joka tarkoittaa sitä, että esim hashmapin tehokkuus on menetetty sillä, emme voi etsiä hashin avulla elementtejä vaan joudutaan käyttämään jotain muuta tunnistetta.

Viimeisessä luodaan uusi equals methodi muttei uutta hashcode methodia, joka tuottaa siinä määrin ongelmia, että jos halutaan verrata objecteja voidaan saada vääriä vastauksia ja hashmap menettää taas oman tehokkuutensa tämän takia.