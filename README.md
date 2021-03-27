# Haku Vertailu

## Aihe
Tarkoituksena on sovellus, jolla pysty vertailla erilaisia hakualgoritmeja. Syöte voi olla oma tai sovelluksessa valmis oleva.
Myös, jos aikaa riittää, tutken vähän javan hakualgoritmeja ja mahdollisesti SQL-server hakualgoritmeja.

## Ohjelmointikieli
Java

## Työn laajuus
Arviottu työnlaajuus n. 107 tuntia.

## Dokumentaatio
[Käyttöohje]( https://github.com/olegTervo/hakuVertailu/blob/master/Dokumentaatio/Kayttoohje.md )

[Määrittelydokumentti]( https://github.com/olegTervo/hakuVertailu/blob/master/Dokumentaatio/Maarittelydokumentti.md )

[Testausdokumentti]( https://github.com/olegTervo/hakuVertailu/blob/master/Dokumentaatio/Testausdokumentti.md )

[Toteutusdokumentti]( https://github.com/olegTervo/hakuVertailu/blob/master/Dokumentaatio/Toteutusdokumentti.md )

## Raportit
[Viikko 2]( https://github.com/olegTervo/hakuVertailu/blob/master/Raportit/viikko2.md )

## Komentorivitoiminnot

Toimintoja suoritetaan kansiossa, jossa on pom.xml

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _HakuVertailu-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/olegTervo/hakuVertailu/blob/master/HakuVertailu/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
