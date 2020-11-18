# Benodigd: 
* Java 8 JDK

# Initieel:
* clone de repo
* maak een nieuw project in intellij (from existing sources)
  * selecteer de java map in de geclonede directory
* Configureren IntelliJ Project Structure (Ctrl+Alt+Shift+S)
  * SDK: Kies Java 8
  * Libraries:
    * Klik links bovenin + en kies java
    * selecteer: app/libs/robocode.jar -> OK
    * Klik nu in het rechter panel de eerste +
    * Selecteer robocode-1.9.3.9-src.zip -> OK
* Configureren run configuratie:
  * Kies + en dan application
  * Geef het een leuke naam
  * Main class: robocode.Robocode
  * VM options: -Xmx512M -Dsun.io.useCanonCaches=false -Ddebug=true
  * Working directory: selecteer de app directory (default staat daar de java directory vervang dat voor app)
  * Sla op
* Configureren robocode zodat jouw bot gevonden wordt
  * Klik run in intellij (robocode wordt nu gestart)
  * Klik Options -> Preferences
  * Kies de Development options tab
  * Klik Add
  * Navigeer naar je outmap <projectdir>/java/out/production/RoboCode
  * Klik Open en dan Finish
  

# Draaien
* Het is niet nodig om robo code voor iedere run opnieuw te starten, alleen je robot opnieuw combileren is voldoende (Ctrl+F9)
* In robocode:
  * Klik Battle -> New
  * Selecteer je tank en voeg deze toe (Add)
  * Selecteer nog een andere tank en voeg deze toe (In het begin is SittingDuck wel een makkelijke ;) )
  * Aangezien we met de standaard rules gaan spelen kan je direct op start battle klikken
  Er worden dan 5 battles gespeeld