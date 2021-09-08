package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import outils.ExceptionInvalidFile;

import outils.Fichier;
import personnages.IPersonnage;

/**
 *
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    //Mase entry
    protected ISalle entree;
    //Mase exit
    protected ISalle sortie;
    //Width
    private int largeur;
    //Height
    private int hauteur;

    /**
     * Method used to create a mase from a given file.
     *
     * @param file the file to read.
     * @throws outils.ExceptionInvalidFile
     */
    @Override
    public void creerLabyrinthe(String file) throws ExceptionInvalidFile {
        Fichier f = new Fichier(file);
        // dimensions
        largeur = f.lireNombre();
        hauteur = f.lireNombre();
        // entrée et sortie
        int x = f.lireNombre();
        int y = f.lireNombre();
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
        if (!Fichier.testValide(file)) {
            throw new ExceptionInvalidFile("Le fichier de chargement est invalide");
        }
    }

    /**
     * Method used to return the accessibles room for the player
     *
     * @param bob the player's room
     * @return a collection of rooms
     */
    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        Salle actu = (Salle) bob.getPosition();
        Collection<ISalle> sallesAccessibles = new HashSet<>();
        Collection<ISalle> analyse = new HashSet<>();
        analyse.add(new Salle(bob.getPosition().getX(), bob.getPosition().getY() + 1));
        analyse.add(new Salle(bob.getPosition().getX(), bob.getPosition().getY() - 1));
        analyse.add(new Salle(bob.getPosition().getX() - 1, bob.getPosition().getY()));
        analyse.add(new Salle(bob.getPosition().getX() + 1, bob.getPosition().getY() + 1));
        for (var salle : analyse) {
            if (actu.estAdjacente(salle)) {
                sallesAccessibles.add(salle);
            }
        }
        return sallesAccessibles;
    }

    @Override
    public ISalle getEntree() {
        return entree;
    }

    @Override
    public ISalle getSortie() {
        return sortie;
    }

    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    @Override
    public int getLargeur() {
        return largeur;
    }

    @Override
    public int getHauteur() {
        return hauteur;
    }

}
