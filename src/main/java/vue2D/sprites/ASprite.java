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
import personnages.IPersonnage;

/**
 * Classe abstraite rajoutant des éléments à la structure basique utilisée pour
 * coder les sprites
 *
 * @author jchampol
 */
public abstract class ASprite implements ISprite {

    // le personnage auquel est associé le sprite
    public IPersonnage monPersonnage;

    // l'abscisse du sprite, initialisé à l'abscisse du joueur
    private int spriteX;

    // l'ordonnée du sprite, initialisé à l'ordonnée du joueur
    private int spriteY;

    // le nombre d'unités par lequel on multiplie la taille réelle de l'image
    private final int UNITE = 15;

    // l'image du sprite
    private Image spriteImage;

    // vrai ssi le personnage est en mouvement
    public boolean enMouvement;

    /**
     * Constructeur paramétré de la classe
     *
     * @param monPersonnage le personnage
     * @param spriteImage son sprite (image)
     */
    public ASprite(IPersonnage monPersonnage, Image spriteImage) {
        this.monPersonnage = monPersonnage;
        this.spriteImage = spriteImage;
        this.spriteX = monPersonnage.getPosition().getX();
        this.spriteY = monPersonnage.getPosition().getY();
    }

    /**
     * Méthode utilisée pour dessiner un sprite à l'endroit où se trouve le
     * personnage qui lui est associé
     *
     * @param g instance de la classe GraphicsContext, indispensable
     */
    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(spriteImage, spriteX, spriteY, UNITE, UNITE);
    }

    /**
     * Méthode changeant les coordonnées d'un sprite
     *
     * @param xpix abscisse sprite en pixels
     * @param ypix ordonnée sprite en pixels
     */
    @Override
    public void setCoordonnees(int xpix, int ypix) {
        this.spriteX = xpix * UNITE;
        this.spriteY = ypix * UNITE;
    }

    /**
     * accesseur sur spriteX
     *
     * @return spriteX
     */
    public int getSpriteX() {
        return this.spriteX;
    }

    /**
     * accesseur sur spriteY
     *
     * @return spriteY
     */
    public int getSpriteY() {
        return this.spriteY;
    }

    /**
     * Méthode retournant la salle choisie par le joueur si elle est accessible,
     * sa position actuelle autrement
     *
     * @param sallesAccessibles les salles accessibles
     * @return the room
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return this.monPersonnage.faitSonChoix(sallesAccessibles);
    }

    /**
     * Retourne la position actuelle du joueur
     *
     * @return
     */
    @Override
    public ISalle getPosition() {
        return this.monPersonnage.getPosition();
    }

    /**
     * Change la position actuelle du joueur
     *
     * @param s
     */
    @Override
    public void setPosition(ISalle s) {
        this.monPersonnage.setPosition(s);
        // l'idée est-elle bonne ?
        /*
        setCoordonnees((int) (s.getX() - 0.6), (int) (s.getY() - 0.6));
        setCoordonnees((int) (s.getX() - 0.5), (int) (s.getY() - 0.5));
        setCoordonnees((int) (s.getX() - 0.4), (int) (s.getY() - 0.4));
        setCoordonnees((int) (s.getX() - 0.3), (int) (s.getY() - 0.3));
        setCoordonnees((int) (s.getX() - 0.2), (int) (s.getY() - 0.2));
        setCoordonnees((int) (s.getX() - 0.1), (int) (s.getY() - 0.1));*/
        setCoordonnees(s.getX(), s.getY());
    }

}
