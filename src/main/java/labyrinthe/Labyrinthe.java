package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;

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
     */
    @Override
    public void creerLabyrinthe(String file) {
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
    }

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        return null;
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
