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
#####   Reprise exercice 14






