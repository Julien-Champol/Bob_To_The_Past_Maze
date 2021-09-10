package labyrinthe;

import java.io.IOException;
import java.util.Collection;
import personnages.IPersonnage;

/**
 * Interface giving structure for the mase's code
 * 
 * @author INFO Professors team
 */
public interface ILabyrinthe extends Collection<ISalle> {

    public void creerLabyrinthe(String file) throws IOException; // cree le labyrinthe a partir d'un fichier 

    public Collection<ISalle> sallesAccessibles(IPersonnage heros); // renvoie les salles accessibles pour le heros

    public ISalle getEntree(); // accesseur sur l'entree 

    public ISalle getSortie(); // accesseur sur la sortie

    public Collection<ISalle> chemin(ISalle u, ISalle v); // un plus court chemin entre u et v

    // dimensions grille
    public int getLargeur();

    public int getHauteur();
}
