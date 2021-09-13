/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import personnages.Monstre;

/**
 * Class associating a sprite to a monster
 *
 * @author jchampol
 */
public class MonstreSprite extends ASprite {

    /**
     * the Hero our sprite is linked to
     */
    private final Monstre monMonstre;

    /**
     * Parameterized constructor of the HerosSPrite class
     *
     * @param monMonstre the monster being initialized
     * @param laby the mase
     */
    public MonstreSprite(IPersonnage monMonstre, ILabyrinthe laby) {
        super(monMonstre, new Image("file:icons/monstre1.gif"));
        this.monMonstre = new Monstre(laby.getSortie());
    }

    /**
     * Method overrided so that setPosition and setCoordonnees are working the
     * same way for the monsters
     *
     * @param s
     */
    @Override
    public void setPosition(ISalle s) {
        this.monMonstre.setPosition(s);
        this.setCoordonnees(s.getX(), s.getY());
    }
}
