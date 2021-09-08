package outils;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import labyrinthe.Labyrinthe;

/**
 *
 * @author INFO Professors team
 */
public class Fichier {

    Scanner sc = null;

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
     * Method used to test all the coordinates contained in a file
     *
     * @param f The file we are reading
     * @return true iff all the file's coordinates are valid ones
     */
    public static boolean testCoordonneesSallesFichier(File f) {
        Labyrinthe test = new Labyrinthe();
        test.creerLabyrinthe("labys/" + f.getName());
        for (var s : test) {
            if (!(s.getX() >= 0 && s.getX() < test.getLargeur())
                    || !(s.getY() >= 0 && s.getY() < test.getHauteur())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method used to test all the rooms of a file and detect the duplicates
     *
     * @param f the file to test
     * @return true iff the files doesn't contain duplicates
     */
    public static boolean testDoublonsSallesFichier(File f) {
        Labyrinthe test = new Labyrinthe();
        test.creerLabyrinthe("labys/" + f.getName());
        Set comparaison = new HashSet(test);
        if (comparaison.size() != test.size()) {
            System.out.println("Contient des doublons : " + f.getName());
        }
        return (comparaison.size() == test.size());
    }

    /**
     * This method is used to call the test methods on a specified file name.
     *
     * @param nomFichier the specified file
     * @return true iff all the tests are passed
     */
    public static boolean testValide(String nomFichier) {
        File nouveau = new File(nomFichier);
        return (testCoordonneesSallesFichier(nouveau) && testDoublonsSallesFichier(nouveau));
    }

}
