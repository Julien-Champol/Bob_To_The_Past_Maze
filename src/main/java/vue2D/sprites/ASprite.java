/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.IPersonnage;

/**
 * Abstract class giving basic structure to code the sprites, this class
 * associate a sprite and a character
 *
 * @author jchampol
 */
public abstract class ASprite implements ISprite {

    private IPersonnage monPersonnage;

    private int spriteX;

    private int spriteY;

    private int unite = 15;

    private GraphicsContext tampon;

    private Image spriteImage;

    /**
     * Parameterized constructor of the class
     *
     * @param monPersonnage the character
     * @param spriteImage his sprite
     */
    public ASprite(IPersonnage monPersonnage, Image spriteImage) {
        this.monPersonnage = monPersonnage;
        this.spriteImage = spriteImage;
    }

    /**
     * Method used to draw an image at a specific location on the graphical
     * window
     *
     * @param g
     */
    @Override
    public void dessiner(GraphicsContext g) {
        tampon.drawImage(spriteImage, monPersonnage.getPosition().getX(),
                monPersonnage.getPosition().getY(), unite,
                unite);
    }

    /**
     * Method used to set the coordinates of the sprite
     *
     * @param x sprite's absciss
     * @param y sprite's ordinate
     */
    @Override
    public void setCoordonnees(int x, int y) {
        this.spriteX = x;
        this.spriteY = y;
    }

    /**
     * spriteX accessor method
     *
     * @return spriteX
     */
    public int getSpriteX() {
        return this.spriteX;
    }

    /**
     * spriteY accessor method
     *
     * @return spriteY
     */
    public int getSpriteY() {
        return this.spriteY;
    }

    /**
     * Method used to return the room chosen by the player if it's accessible,
     * else his current position
     *
     * @param sallesAccessibles the accessibles room
     * @return the room
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return this.faitSonChoix(sallesAccessibles);
    }

    /**
     * Returns the position of the player
     *
     * @return
     */
    @Override
    public ISalle getPosition() {
        return this.monPersonnage.getPosition();
    }

    /**
     * Sets the player's position
     *
     * @param s
     */
    @Override
    public void setPosition(ISalle s) {
        this.monPersonnage.setPosition(s);
    }

}
