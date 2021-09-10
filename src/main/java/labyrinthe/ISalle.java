package labyrinthe;

/**
 * Interface giving structure for the code of the mase's rooms
 *
 * @author INFO Professors team
 */
public interface ISalle {

    public int getX(); // abcisse

    public int getY(); // ordonnee

    public boolean estAdjacente(ISalle autre);
}
