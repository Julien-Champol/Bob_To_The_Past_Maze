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
    
    @Override
    public void setPosition(ISalle s) {
        this.spriteX = x;
        this.spriteY = y;
    }
}
