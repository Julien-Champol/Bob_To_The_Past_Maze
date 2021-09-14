package labyrinthe;

/**
 * Interface donnant la structure pour les salles d'un labyrinthe
 *
 * @author INFO Professors team
 */
public interface ISalle {

    public int getX(); // abcisse

    public int getY(); // ordonnee

    public boolean estAdjacente(ISalle autre);
}
