package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import outils.ExceptionInvalidFile;

import outils.Fichier;
import personnages.IPersonnage;

/**
 * Class repreenting data about a mase 
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
        if (!Fichier.testValide(file)) {
            throw new ExceptionInvalidFile("Le fichier de chargement est invalide");
        } else {
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

    /**
     * The mase's entry accessor
     *
     * @return
     */
    @Override
    public ISalle getEntree() {
        return entree;
    }

    /**
     * The mase's exit accessor
     *
     * @return
     */
    @Override
    public ISalle getSortie() {
        return sortie;
    }

    /**
     * Method returning possible paths between u and v
     *
     * @param u
     * @param v
     * @return
     */
    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    /**
     * The mase's width accessor
     *
     * @return
     */
    @Override
    public int getLargeur() {
        return largeur;
    }

    /**
     * The mase's height accessor
     *
     * @return
     */
    @Override
    public int getHauteur() {
        return hauteur;
    }

}
