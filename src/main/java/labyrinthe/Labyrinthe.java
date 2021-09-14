package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import outils.ExceptionInvalidFile;

import outils.Fichier;
import personnages.IPersonnage;

/**
 * Classe représentant les données d'un labyrintheF
 *
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    //L'entrée
    protected ISalle entree;
    //La sortie
    protected ISalle sortie;
    //largeur de la grille
    private int largeur;
    //hauteur de la grille
    private int hauteur;

    /**
     * Méthode permettant de créer un labyrinthe à partir d'un fichier
     *
     * @param file le fichier à lire
     * @throws outils.ExceptionInvalidFile
     */
    @Override
    public void creerLabyrinthe(String file) throws ExceptionInvalidFile {
        Fichier f = new Fichier(file);
        if (!Fichier.testValide(file)) {
            throw new ExceptionInvalidFile("Le fichier de chargement est invalide");
        } else {
            // dimensions
            largeur = f.lireNombre();
            hauteur = f.lireNombre();
            // entrée et sortie
            int x = f.lireNombre();
            int y = f.lireNombre();
            // l'entrée et la sortie font partie des salles
            entree = new Salle(x, y);
            this.add(entree);
            x = f.lireNombre();
            y = f.lireNombre();
            sortie = new Salle(x, y);
            this.add(sortie);
            // autres salles
            x = f.lireNombre();
            y = f.lireNombre();
            while (x != -1 || y != -1) {
                this.add(new Salle(x, y));
                x = f.lireNombre();
                y = f.lireNombre();
            }
        }
    }

    /**
     * Méthde retournant les salles accessibles à un personnage
     *
     * @param bob le personnage
     * @return aune collection contenant les salles en question
     */
    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        Salle actu = (Salle) bob.getPosition();
        Collection<ISalle> sallesAccessibles = new HashSet<>();
        Collection<ISalle> analyse = new HashSet<>();
        analyse.add(new Salle(bob.getPosition().getX(), bob.getPosition().getY() + 1));
        analyse.add(new Salle(bob.getPosition().getX(), bob.getPosition().getY() - 1));
        analyse.add(new Salle(bob.getPosition().getX() - 1, bob.getPosition().getY()));
        analyse.add(new Salle(bob.getPosition().getX() + 1, bob.getPosition().getY()));
        for (var salle : analyse) {
            if (this.contains(salle) && actu.estAdjacente(salle)) {
                sallesAccessibles.add(salle);
            }
        }
        return sallesAccessibles;
    }

    /**
     * Accesseur sur l'entrée
     *
     * @return
     */
    @Override
    public ISalle getEntree() {
        return entree;
    }

    /**
     * Accesseur sur la sortie
     *
     * @return
     */
    @Override
    public ISalle getSortie() {
        return sortie;
    }

    /**
     * Méthode retournant les chemins possible entre deux salles
     *
     * @param u première salle
     * @param v seconde salle
     * @return
     */
    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    /**
     * Accesseur sur la largeur
     *
     * @return
     */
    @Override
    public int getLargeur() {
        return largeur;
    }

    /**
     * Accesseur sur la hauteur
     *
     * @return
     */
    @Override
    public int getHauteur() {
        return hauteur;
    }

}
