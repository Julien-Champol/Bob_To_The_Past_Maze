# Journalisation de la réalisation du projet

## 06/09 : 
###     Début du projet.
        Exercice 1 réalisé. 
        Ajout de README.md sur la branche master.
        
## 07/09 : 
####     Réalisation de l'exercice 2 ,
        relecture, 
        export au format pdf.
####     Réalisation de l'exercice 3 , 
        Création de la classe salle, 
        ajout d'une méthode estIdentique(ISalle) en vue des tests.
####    Réalisation de l'exercice 4 ,
        Implémentation de la méthode creerLabyrinthe(String),
        ajout de la méthode dessinSalle(), problème d'extension de fichier (gif et pas png)
####    Réalisation de l'exercice 5
        Problème d'extension de fichier (gif et pas png)
        Dessin du labyrinthe fonctionnel.
## 08/09 :
####    Réalisation exercice 6
        implémentation testCoordonneesSallesFichier(File f), level invalides 1 et 2 detectés correctement.
####    Réalisation exercice 7
        ArrayList -> HashSet, vérification taille similaire, level 1, 3 et 4 invalides et detectés.
####    Réalisation exercice 8
        Ajout des méthodes en static hors du package de test pour écrire la fonction suivante,
        testValide(String) implémentée.
####    Réalisation exercice 9
#####   Réponse question :
        Réponse question exo 9 : Cette exception doit hériter de la classe IOException.
        Création de ExceptionInvalidFile dans le package outils.
        Appropriation de la boucle principale.
        Déclaration de l'exception dans le programme, utilisation de exit(0) pour quitter le programme comme
        demandé dans l'énoncé.
####    Réalisation exercice 10
        Début de la suite de l'implémentation des classes salle et labyrinthe. estAdjacente(ISalle) a été implémentée par 
        précaution au début du projet mais mise à jour nécessaire. Mise à jour de la classe labyrinthe, implémentation
        de la fonction sallesAccessibles(IPersonnage).
####    Réalisation exercice 11
        Implémentation de la classe abstraite APersonnage, ajout de l'attribut privé positionCourante.
####    Réalisation exercice 12
#####   Réponse question :
        Visibilité de l'attribut salleChoisie : public. 
        Implémentation de la méthode faitSonChoix(Collection<ISalle>).
####    Réalisation exercice 13
        Ecriture de la classe abstraite ASprite qui implémente l'interface ISprite, implémentation de la méthode dessiner()
        avec ajout des attributs nécessaires dont tamon et unite.
####    Réalisation exercice 14
        Création de la classe HerosSprite héritant de ASprite, redéfinition de faitSonChoix(Collection<ISalle>), getPosition(),
        setPosition().
        Clean and build puis run ne permet plus un lancement correct du code.
        Retour d'erreur : "Failed to execute goal org.openjfx:javafx-maven-plugin:0.0.4:run".
        Essai redémarrage PC. Toujours la même erreur.
        Tentative d'isolation du problème en commentant les parties du code les plus récentes.
        Partie du code bloquant le lancement du programme trouvée : lignes 55 à 57 du code de la classe labyrinthe.
## 09/09 :
#####   Reprise du développement au bug du jour précédent :
        Ajout d'un double try/catch dans chargementLaby(String) afin de rendre le code plus lisible.
        Relecture de la méthode testValide, suite à une indication run time exception, je cherche une éventuelle récursivité infinie suite à
        une discussion avec quelqu'un ayant le même problème.
        Récursivité infinie identifiée dans la fonction testValide(). Elle appelle une fonction utilisant creerLabyrinthe() mais cette fonction
        utilise elle-même testValide(). Il y a donc une boucle récursive infinie dans ces lignes de code.
        Il faut essayer de retirer l'appel à creerLabyrinthe(String) dans les tests. Cela est possible en appellant uniquement la partie du code de creerLabyrinthe(String) qui est nécessaire et qui tient en 8 lignes. Les tests sont fonctionnels à nouveau.
        Le programme se lance correctement.
## 10/09 :
#####   Reprise exercice 14
        Implémentation, re-définition de handle, mise à jour de l'attribut salleChoisie.
        Implémentation de EventHandler<KeyEvent> refusée, erreur :
*type argument java.awt.event.KeyEvent is not within bounds of type-variable T*

        Solution : utilisation d'un import java.awt au lieu de javafx.
        Ajout d'un attribut monHeros afin de pouvoir accéder à l'attribut salleChoisie et le mettre à jour.
        Première version de l'exercice 14 réalisée, le code se lance correctement, passage à l'exercice 15.
####    Réalisation exercice 15
        Code de Core décommenté : manque un constructeur dans la classe Heros.
        Constructeur de HerosSprite erroné, ajout d'un paramètre de type ILabyrinthe.
        Suite à une lecture générale du code, je réalise que je ne le maitrise pas. Le code initial est donc
        entièrement commenté pour mieux le comprendre. Voir commit "documentation intégrale du code".
        Problème avec l'erreur suivante :
*"JavaFX Application Thread" java.lang.NullPointerException*

        Problème dans la méthode dessiner().
## 11/09 :
#####   Reprise exercice 15
        Bug d'écran blanc réglé avec l'ajouyt de la condition if dans la boucle suivante :
*for (var s : this.sprites) {
            if (s.getClass().toString().equals("vue2D.sprites.HerosSprite.java")) {
                tampon.drawImage(heros, s.getPosition().getX() * unite, s.getPosition().getY() * unite);
            }
        }*

        A ce stade, le héros n'est cependant pas affiché. 
        Après plusieurs tests il est visible que la condition if est erronnée : 
*vue2D.sprites.HerosSprite.java*  au lieu de *class vue2D.sprites.HerosSprite*
         
         On a toujours l'erreur du null pointer.
         Après demande d'aide à un camarade, l'attribut null est detecté, la positionChoisie était initialisée mais pas la position de départ initialisée avec 
*setPosition(ISalle)*

        le déplacement est problématique, flèche du gauche et du haut ne fonctionne pas correctement.
## 13/09
#####   Reprise exercice 15
        Correction du déplacement vers le haut et la gauche. Relecture de la méthode salleAccessibles(IPersonnage).
        Le problème se situait dans le switch de la méthode handle(KeyEvent), les breaks étainet absents.
        A ce stade le héros n'a aucune contrainte de déplacement et les murs du labyrinthe ne sont pas dessinés.
        Un premier code de dessin des murs est réalisé et commenté, n'étant pas encore arrivé à la question 29.
####    Réalisation exercice 16
        Un problème de conception se présente : gérer le déplacement des monstres dans monstreSprite.
        De plus, le déplacement du joueur fonctionne mal, il peut se déplacer n'importe où.
        Phénomène étrange lorsque l'instruction setPosition(salleChoisie) est placée deux fois dans le code :
        dans la méthode faitSonChoix(Collection<ISalle>) et dans la méthode handle(KeyEvent), le déplacement fonctionne correctement.
####    Réalisation exercice 17
        Le déplacement des monstres ne fonctionnent pas, après les avoir placés à la sortie et avoir implémenté les deux classes,
        ils ne se déplacent pas, le code de déplacement du joueur est suspect, trop complexe par rapport aux méthodes fournies.
        Avant d'aller plus loin dans les exercices, il faut reprendre le code existant.
## 14/09
#####   Reprise exercice 17 et correction du code existant
        Problème de déplacement trouvé : la ligne 104 de ASprite était la suivante :
*return this.faitSonChoix(sallesAccessibles);*
        Cette ligne ne renvoyer rien car faitSonChoix n'était pas définie.
*return this.monPersonnage.faitSonChoix(sallesAccessibles)*
        Il fallait pointer sur la classe où elle est définie, c'est-à-dire la classe IPersonnage.
        Reprise du déplacement du monstre à présent, suppression du Override de setPosition dans monstreSprite, le déplacement des monstres est fonctionnel.
        Les exercices 16 et 17 sont réalisés.
####    Réalisation exercice 18 
#####   Rajout d'une temporisation pour les monstres
        Rajout des lignes de code suivantes dans faitSonChoix(Collection<ISalle>) de Monstre :

        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        Le jeu est plus agréable à regarder de cette manière.
        La vue hérite à présent de CopyOnWriteArrayList.
        Les collisions entre le personnage et les monstres ne sont pas fonctionnelles, on remplace les == et != de core par des appels à .equals(Object).
        Avant d'aller plus loin, un nettoyage du code, la mise à jour du diagramme de classe et une documentation uniforme s'impose.
## 15/09
#####   Fin de la documentation et de la première refactorisation 
        Remise à jour du diagramme final et début de l'objectif 5.
####    Réalisation exercice 19
        Pour dissocier le déplacement salle par salle dans le labyrinthe du déplacement graphique, il va falloir changer la méthode 
        dessinner(GraphicsContext) de la classe ASprite. On ne peut plus utiliser les coordonnées de la position courante dans la méthode,
        il faudra utiliser la méthode setCoordonnees(int, int).
## 16/09
####    Reprise exercice 19
        Indice obtenu sur la réalisation de l'exercice 19 : déplacement de 1 pixel en 1 pixel au lieu de 15 en 15. 
        La difficulté jusqu'à présent rencontrée dans le code réside dans ce changement du déplacement. 
        L'utilisation d'une méthode lerp(linear interpolation) de manière similaire à celle d'un camarade semble judicieuse.
        De cette façon, on a plus à se soucier de lancer un déplacement graphique ssi le déplacement par salle est fini, 
        en effet en utilisant le code de la manière suivante, les coordonnées du sprite "traquent" celle de la salle :
        
        On insère la méthode suivante dans la classe ASprite :

        public static float lerp(float b, float a, float f) {
        return b + f * (a - b);
        }

        on l'appelle deux fois dans la méthode dessiner(GraphicsContext) lignes 58 et 59 : 
        
        spriteX = lerp(spriteX, monPersonnage.getPosition().getX() * UNITE, 0.20f);
        spriteY = lerp(spriteY, monPersonnage.getPosition().getY() * UNITE, 0.20f);

        La méthode dessinner() étant appelée plusieurs fois par seconde que la position du personnage change ou non, on 
        a pas à se soucier d'ajouter une quelconque boucle au programme.
## 17/09
####    Réalisation exercice 20
        Arrivé à ce stade, la première étape est de faire la différence entre les coordonnées euclidiennes et Manhattan.
        Nous utiliserons les coordonnées euclidiennes comme dans tout le code.
        Il faut également svoir quelle propriété modifier pour faire en sorte qu'une salle ne soit pas affichée.
        
        On pourrait utiliser les méthodes de GraphicsContext telles que SetEffect(Effect) combinée avec une instance 
        de la classe ColorAdjust. Une fois ColorAdjust instancié on appelle la méthode setBrightness et on a notre effet.
        Pour retirer l'effect on utilise setEffect(null).
        Après plusieurs tests sans lecture des coordonnées, il semble assez simple d'utiliser ces lignes de code :

                 colorAdjust.setBrightness(-1.0);
                tampon.setEffect(colorAdjust);
                tampon.drawImage(salleImage, s.getX() * UNITE, s.getY() * UNITE);
                tampon.setEffect(null);

        en ajustant la valeur du double en paramètre de setBrightness en fonction de la distance entre le héros et la salle.

        La prochaine étape est de calculer les coordonnées des salles et autres éléments à afficher en fonction de leur distance.
        Première difficulté : dans quelle classe créer la fonction qui détermine si la salle et le héros sont dans un même 
        périmètre ?








        
        




