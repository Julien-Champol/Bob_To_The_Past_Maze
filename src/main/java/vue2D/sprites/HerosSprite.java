package vue2D.sprites;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.ILabyrinthe;
import labyrinthe.Salle;
import personnages.Heros;
import personnages.IPersonnage;

/**
 * Classe représentant des données à propos de la classe HeroSprite
 *
 * @author jchampol
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {

    // le Hero qu'on est en train de représenter
    private Heros monHeros;

    /**
     * Constructeur paramétré de HerosSprite
     *
     * @param monPerso le personnage
     * @param laby le labyrinthe
     */
    public HerosSprite(IPersonnage monPerso, ILabyrinthe laby) {
        super(monPerso, new Image("file:icons/link/LinkRunR1.gif"));
        this.monHeros = (Heros) monPerso;
    }

    /**
     * Redéfinition de la méthode handle de EventHandler
     *
     * @param event
     */
    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT:
                this.monHeros.salleChoisie = new Salle(this.getPosition().getX() - 1, this.getPosition().getY());
                break;
            case RIGHT:
                this.monHeros.salleChoisie = new Salle(this.getPosition().getX() + 1, this.getPosition().getY());
                break;
            case UP:
                this.monHeros.salleChoisie = new Salle(this.getPosition().getX(), this.getPosition().getY() - 1);
                break;
            case DOWN:
                this.monHeros.salleChoisie = new Salle(this.getPosition().getX(), this.getPosition().getY() + 1);
                break;
        }
    }
}
