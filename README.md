# One Night OneNightCar.Car

[![Build Status](https://github.com/fh-erfurt/One-Night-Car/workflows/One-Night-Car/badge.svg)](https://github.com/fh-erfurt/One-Night-Car/actions)

## Über uns
### Teammitglieder
Ahmad Abo Louha, Pascal Giese, Benito Grauel, Alejandro Restrepo Klinge


## Was wir gemacht haben
Wir haben unser Datenmodell genutzt und eine Weboberfläche für dieses gebaut. Man kann sich auf der Oberfläche einloggen und Autos mieten. Zudem gibt es eine Profilübersicht für jeden Kunden, in der aktive Mietverträge angezeigt werden.

## Tools
wir haben während der Projektlaufzeit mit verschiedenen Tools gearbeitet wie: Spring-boot, Servlet, Thymeleaf, JUnit und SQL Datenbank.

## Projektstruktur
das Projekt ist in MVC Pattern geteilt:
#### Model:
enthält logische Struktur von Daten geteilt in verschiedene Packages und jede Package hat die logische verbundene Klassen.
* Package OneNightCar.person: Beinhaltet alle Informationen von Kunden, Mitarbeiter und Admins.
![Package OneNightCar.Person](/diagrammen/PersonPackage.png)
* Package OneNightCar.car: Beinhaltet alle Informationen von Autos
![Package OneNightCar.Car](/diagrammen/CarPackage.png)
* Package OneNightCar.parkingArea: Beinhaltet alle Informationen von den verschiedenen ParkingAreas. Hat eine maximale Anzahl von Autos die dazu gehören dürfen.
![Package Parking Area](/diagrammen/ParkingAreaPackage.png)
* Package OneNightCar.rental: Beinhaltet alle Informationen von den verschiedenen Rentaltypen
![Package OneNightCar.Rental](/diagrammen/RentalPackage.png)

#### Repository
für jede Klasse wurde eine Repository erstellt um die Daten zu speichern und in/von Datenbank zu schreiben und zu lesen.
in BootStrapDate werden instanzen erstellt und in die Datenbank gegschickt um die im GUI zu nutzen

#### Datenbank
mySql Datenbank benutzt und local durch phpMyAdmin Server gesteuert

![Package OneNightCar.Rental](/diagrammen/DB.jpeg)

#### Controller:
ist zuständig für die Interaktion zwischen Präsentationsschicht und Daten
* MainController
* Login-, Logout-, signupController: zur Bearbeitung der genannten Forms
* RentalController: hier wird der Prozess des Automietens behandelt, fängt mit Autosuchen an dann das gewünschte Auto in bestimmten Zeiten wählen und dann mieten

es wurde auch Klassen erstellt, um die Daten aus verschiedenen Forms zu bearbeiten zBs. LoginForm, CarSearchForm, SignUpForm...

#### View:
enthält die grafische Darstellung der Daten in Art von Html seiten
##### Seiten
* index
![Package OneNightCar.Person](/diagrammen/index.png)
* carSearch
![Package OneNightCar.Person](/diagrammen/carSearch.png)
* login
![Package OneNightCar.Person](/diagrammen/login.png)
* 404
![Package OneNightCar.Person](/diagrammen/404.png)
* signup
* imprint
* ...

## Online Server
das Projekt wurde auf Heroku Server derployed und durch den Link erreichbar
http://onenightcar.herokuapp.com/

## Produkte
One-Night-OneNightCar.Car CarSharing Verwaltungsystem

## Stakeholder/Akteure:
* Kunde: Benutzer von unserem System. Können verschiedene Autos Mieten. Haben ein customerLevel, welches sagt welche Autos gemietet werden dürfen.
* Mitarbeiter: Betreuung von Nutzer und Autos
  * Maintainer: kümmert sich darum, dass Autos immer im besten Stand sind (Betankt, ohne Schädigungen) 
  * Customer Support: kümmert sich darum, dass Kunden immer zufrieden sind 
  * Boss: kümmert sich darum, dass alles gut läuft
* Admin: verantwortlich für bestimmten fälle. Beispielweise: Erlaubnis von Stornierungen, Kunde oder Employee von System löschen

## Events
* Auto mieten: Ein OneNightCar.Rental-Objekt wird instanziiert (Zwischen einem Kunde und einem Auto)
* Auto reparieren: Ein Maintainer repariert ein Auto (Nach der Reparatur wird nie wieder in CarState == Perfect)
* Auto tanken: Ein Maintainer kümmert sich darum, dass die Autos die im Moment nicht gemietet sind, genug Benzin / Diesel haben
* Mitarbeiter einstellen : Ein neues Objekt der Klasse Mitarbeiter wird instanziiert
* Kundensupport: Ein Mitarbeiter wird einem Kunden zugeordnet mittels Funktion und löst dessen Problem
* Neues Auto bereitstellen: Ein Objekt der Klasse ElectricCar oder CombustionCar wird instanziiert
* neue Kunde registrieren

## Abgrenzung(Das System soll nicht:)
Rechnungswesen: Das System soll keine Lohnzahlungen an OneNightCar.Person, sowie Rechnungen und deren Abwicklung von Kunden- oder Herstellerkäufen verwalten. Dies übernimmt ein externer Dienstleister.

Zahlung: Über externen Dienstleister PayPal oder SofortÜberweisung: Am Ende des Miet- vorgangs, wird der Käufer dorthin weitergeleitet, Shop gibt Käufer- und Bestelldaten an Paypal o.Ä. weiter und erhält eine Status-Rückmeldung.
