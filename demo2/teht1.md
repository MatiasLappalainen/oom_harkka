#  teht1

2.1

## a)  
    fi.utu.oomkit.gui
        Julkiset luokat
            MainWindowBase
            OOMApp
            ReactiveCanvas (aliluokka)
            ReactiveLabel (aliluokka)
            SimpleCanvas (aliluokka)

        Suojatut luokat
            DefaultDialogFactory
            FXConsole (aliluokka)
            MergedStream (aliluokka)
            SimpleMainWindow (aliluokka)
            StreamWrapper (aliluokka)

    fi.utu.oomkit.example.emptyapp
        Julkinen
            EmptyApp
    fi.utu.oomkit.components.properties
        Julkinen
            ObservableBase

    fi.utu.oomkit
        Julkinen
            AppConfiguration

    fi.utu.oonkit.util
        Julkinen
            Point

## b)
    EmptyApp
    EmptyApp luo pienemmän ruudun ikkunaan (Canvas) ja piirtää sinne auton satunnaiseen kohtaan laatikkoa. topBarContent luo yläpalkkiin tekstiä.

    OOMApp
    Avaa wellcome-screenin, joka sulkeutuu 2000ms kuluttua. Ruudussa on OOMkitin versionumero, joka saadaan OOMApp.OOMVersion:sta. OOMApp luo ikkunan buttoneilla (restart, exit). Restart-button tulostaa konsoliin "Starting the application". Exit lopettaa ohjelman. Luo konsolin, johon tulee ilmoitus määritettyjen näppäien painamisesta. Ei tue skandeja.

## c)
    MainWindow
    Interface, joka perii WindowContentin. Sisältää pelkkiä muuttujia, esim. leveys, korkeus ja title.
    
    WindowContent
    Sisältää metodit topBarContent(), mainContent() ja bottomBarContent(). Palauttaa järjestyksessä tyhjän ArrayListin (ruudun yläosassa teksi on luotu listasta), tyhjän Canvaksen ja tyhjän ArrayListin (buttonit).

    MainWindowBase
    Totetuttaa interfacet (MainWindow ja WindowContent). Luo konsolin, joka tulee FXConsolesta ja luo konsolille ruudun buildSideView:lla. Asettaa ikkunan suhteet ja luo ruudun, johon EmptyApp piirtää kuviot. Sijoittaa BorderPane:lla sisällön oikeaan paikkaan ikkunaan. Metodit buildTopBar ja buildBottomBar rakentavat buildBarin flowpanen avulla palkit. Metodi buildRoot sijoitta borderPanen avulla luodut palkit oikeisiin paikkoihin ikkunassa. Lopuksi toteutetaan MainWindowBase.

    OOMApp.SimpleMainWindow
    Perii MainWindowBase ja tekee bottomBarin sisällön (painikkeet).

    Muokattavuus

    On mahdollista muokata viewratiota, side viewratiota, palkkien sisältöjä ja ikkunan dimensioita muuttamalla alkuperäistä lähdekoodia, koska muuttujien tyypit final.

## d)
    Muutetaan AppLogic-luokasta tickDuration 1000ms --> 25ms.Scheduled-luokkaa puukotetaan siten, että system.out.print korvataan esim. kutsumalla asiakkaan metodia.
