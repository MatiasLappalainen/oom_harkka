#Teht 3c
1.  Tämä uudistus voisi olla hyvä, sillä molemmat oliot tarvitsevat nämä tiedot ja jatko kehityksen kannalta PeliObjectia on helpompi muokata ja sitten implementoida muihin komponentteihin.
2. Rajapinta luokka ei välttämättä ole hyvä idea, sillä silloin olio määrittelee itse esim painovoiman suuruudet ja muut fysikaaliset elementit, kuitenkin painovoiman periytyminen voisi olla hyvä asia niin se pysyisi kaikissa elementeissä samana
3. Ei hyvä sillä ellipsi ja ympyrä ovat eri asia vaikka ovatkin hyvin samanlaisia, mutta samoja kaavoja ei voi esim käyttää molempien ominaisuuksien laskemiseen.
4. Sama kuin ylempänä
5. Number saattaa olla liian korkealla luokka hierarkiassa, mielummin neperin luku voisi periä vaikka doublen tai floatin
6. java.util.Stack perii luokan Vector sillä se saa sieltä methodeja joita Stack tarvitsee tiettyjen asioiden toteuttamiseen.
Tämän periytymisen tyyppi on Object