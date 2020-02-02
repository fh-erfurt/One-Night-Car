# One Night Car

[![Build Status](https://github.com/fh-erfurt/One-Night-Car/workflows/One-Night-Car/badge.svg)](https://github.com/fh-erfurt/One-Night-Car/actions)

## Über uns
### Teammitglieder
Ahmad Abo Louha, Pascal Giese, Benito Grauel, Alejandro Restrepo Klinge

## Packages
* Person: Beinhaltet alle Informationen von Kunden, Mitarbeiter und Admins. Zuständig: Alejandro Restrepo Klinge (@mrrestre)
![Package Person](/diagrammen/packagePerson.png)

* Rental: Beinhaltet alle Informationen von den verschiedenen Rentaltypen. Zuständig: Pascal Giese (@pascalgiese)
  * Electric Rental: Mieten eines elektrischen Autos
  * Fuel Rental: Mieten eines nicht elektrischen Autos 
![Package Rental](/diagrammen/packageRental.png)

* ParkingArea: Beinhaltet alle Informationen von den verschiedenen ParkingAreas. Hat eine maximale Anzahl von Autos die dazu gehören dürfen. Zuständig: Benito Grauel (@TheBenitoo)
  * Electric ParkingArea: beschreibt eine ParkinArea mit (bengrenzter Anzahl) Anschlüssen für elektrische Autos
  * Fuel Rental: beschreibt eine gewönliche ParkinArea 
![Package Parking Area](/diagrammen/packageParkingArea.png)

* Car: Beinhaltet alle Informationen von Autos. Zuständig: Ahmad Abo Louha (@AhmadAboLouha)
  * Electric Car: haben verschiedene Eigenschaften als andere Autos
![Package Car](/diagrammen/packageCar.png)

## Produkte
One-Night-Car CarSharing Verwaltungsystem

## Stakeholder/Akteure:
* Kunde: Benutzer von unserem System. Können verschiedene Autos Mieten. Haben ein customerLevel, welches sagt welche Autos gemietet werden dürfen.
* Mitarbeiter: Betreuung von Nutzer und Autos
  * Maintainer: kümmert sich darum, dass Autos immer im besten Stand sind (Betankt, ohne Schädigungen) 
  * Customer Support: kümmert sich darum, dass Kunden immer zufrieden sind 
  * Boss: kümmert sich darum, dass alles gut läuft
* Admin: verantwortlich für bestimmten fälle. Beispielweise: Erlaubnis von Stornierungen, Kunde oder Employee von System löschen

## Events
* Auto mieten: Ein Rental-Objekt wird instanziiert (Zwischen einen Kunde und ein Auto)
* Auto reparieren: Ein Maintainer repariert ein Auto (Nach der Reparatur wird nie wieder in CarState == Perfect)
* Auto tanken: Ein Maintainer kümmert sich darum, dass die Autos die im Moment nicht gemietet sind, genug Benzin / Diesel haben
TODO: hier noch andere Aktivitäten ergänzen

## Anforderungsbeschreibung(Grob)
TODO: hier ein Paar sätze schreiben

## Abgrenzung(Das System soll nicht:)
Rechnungswesen: Das System soll keine Lohnzahlungen an Person, sowie Rechnungen und deren Abwicklung von Kunden- oder Herstellerkäufen verwalten. Dies übernimmt ein externer Dienstleister.

Zahlung: Über externen Dienstleister PayPal oder SofortÜberweisung: Am Ende des Miet- vorgangs, wird der Käufer dorthin weitergeleitet, Shop gibt Käufer- und Bestelldaten an Paypal o.Ä. weiter und erhält eine Status-Rückmeldung.

## Protokoll
Um zu wissen was zu machen war und wer was machen soll, haben wir zusammen eine Excel-Datei erstellt, indem alle Instanzvariablen und Methoden für jede Klasse stehen. Idee ist folgende: Alles erstmal auflisten, dann bei implementieren die Zellen ständig mit den richtigen Farben bemalen.

![Plan](/diagrammen/planGuide.jpg)
![Plan](/diagrammen/planCars.jpg)
![Plan](/diagrammen/planPA.jpg)
![Plan](/diagrammen/planPerson.jpg)
![Plan](/diagrammen/planRental.jpg)

