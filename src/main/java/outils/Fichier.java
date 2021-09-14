package outils;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import labyrinthe.Labyrinthe;
import labyrinthe.Salle;

/**
 * Classe représentant des données sur la représentation d'un labyrinthe par un
 * fichier
 *
 * @author INFO Professors team
 */
public class Fichier {

    // Scanner permettant la lecture d'un fichier
    Scanner sc = null;

    /**
     * Constructeur paramétré de la classe Fichier
     *
     * @param nomFichier le chemin d'accès au fichier
     */
    public Fichier(String nomFichier) {
        try {
            sc = new Scanner(new File(nomFichier));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // retourne le prochain entier dans le fichier
    // retourne -1 s'il n'y en a pas
    public int lireNombre() {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        }
        return -1;
    }

    /**
     * Méthode testant la validité de toutes les coordonnées d'un fichier
     *
     * @param f le fichier en cours de lecture
     * @return vrai ssi les coordonnées sont valides (sup ou égal à 0, inférieur
     * à largeur/hauteur)
     * @throws outils.ExceptionInvalidFile
     */
    public static boolean testCoordonneesSallesFichier(File f) throws ExceptionInvalidFile {
        // initialisation d'un labyrinthe et de l'instance de Fichier le représentant
        Labyrinthe test = new Labyrinthe();
        Fichier fic = new Fichier("labys/" + f.getName());
        // lecture de la hauteur et de la largeur
        int hauteur = fic.lireNombre();
        int largeur = fic.lireNombre();
        // lecture successive des coordonnées 
        int x = fic.lireNombre();
        int y = fic.lireNombre();
        while (x != -1 || y != -1) {
            test.add(new Salle(x, y));
            x = fic.lireNombre();
            y = fic.lireNombre();
        }
        // test successif des coordonnées 
        for (var s : test) {
            if (!(s.getX() >= 0 && s.getX() < largeur)
                    || !(s.getY() >= 0 && s.getY() < hauteur)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Méthode testant la présence de doublons dans un fichierF
     *
     * @param f le fichier à tester
     * @return vrai ssi le fichier est sans doublons
     * @throws outils.ExceptionInvalidFile
     */
    public static boolean testDoublonsSallesFichier(File f) throws ExceptionInvalidFile {
        // initialisation d'un labyrinthe et de l'instance de Fichier le représentant
        Labyrinthe test = new Labyrinthe();
        Fichier fic = new Fichier("labys/" + f.getName());
        // lecture de la hauteur et de la largeurF
        int hauteur = fic.lireNombre();
        int largeur = fic.lireNombre();
        int x = fic.lireNombre();
        int y = fic.lireNombre();
        while (x != -1 || y != -1) {
            test.add(new Salle(x, y));
            x = fic.lireNombre();
            y = fic.lireNombre();
        }
        // comparaison contient les éléments du laby mais sans éventuels doublons
        // si comparaison a une taille différente du labyrinthe, on a des doublons 
        Set comparaison = new HashSet(test);
        if (comparaison.size() != test.size()) {
            System.out.println("Contient des doublons : " + f.getName());
        }
        return (comparaison.size() == test.size());
    }

    /**
     * Cette méthode appelle les méthodes de test à partir d'un nom de fichier
     *
     * @param nomFichier le fichier spécifiéF
     * @return vrai ssi tous les tests passent
     * @throws outils.ExceptionInvalidFile
     */
    public static boolean testValide(String nomFichier) throws ExceptionInvalidFile {
        File nouveau = new File(nomFichier);
        return (testCoordonneesSallesFichier(nouveau) && testDoublonsSallesFichier(nouveau));
    }

}
