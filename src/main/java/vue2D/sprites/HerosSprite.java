/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.ILabyrinthe;
import labyrinthe.Salle;
import personnages.Heros;
import personnages.IPersonnage;

/**
 * Class representing data about the hero's sprite
 *
 * @author jchampol
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {

    /**
     * the Hero our sprite is linked to
     */
    private final Heros monHeros;

    /**
     * Parameterized constructor of the HerosSPrite class
     *
     * @param monPerso the IPersonnage
     * @param laby the mase
     */
    public HerosSprite(IPersonnage monPerso, ILabyrinthe laby) {
        super(monPerso, new Image("file:icons/link/LinkRunR1.gif"));
        this.monHeros = (Heros) monPerso;
    }

    /**
     * Method used to handle the moves of the hero, updating the salleChoisie
     * attribute and moving the hero and the sprite
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
