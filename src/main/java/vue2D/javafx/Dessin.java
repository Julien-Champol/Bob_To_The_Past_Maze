package vue2D.javafx;

import java.util.Collection;
import java.util.HashSet;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import vue2D.sprites.ISprite;

/**
 * Class representing data about drawing methods of the program
 *
 * @author INFO Professors team
 */
public class Dessin extends Canvas {

    private Collection<ISprite> sprites;
    private ILabyrinthe labyrinthe;
    private int unite = 15;
    private GraphicsContext tampon;
    private Image solImage;
    private Image salleImage;
    private Image entree;
    private Image sortie;
    private Image mur;

    /**
     * Parameterized constructor of the class
     *
     * @param labyrinthe the mase that is being played
     * @param sprites the heroes, walls ... sprites to draw
     */
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        setWidth(labyrinthe.getLargeur() * unite);
        setHeight(labyrinthe.getHauteur() * unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
        dessinSalleEtMur();
    }

    /**
     * Method used to load the images from the icons folder.
     */
    public void chargementImages() {
        solImage = new Image("file:icons/pyramide.jpg");
        salleImage = new Image("file:icons/ground.gif");
        entree = new Image("file:icons/groundP.gif");
        sortie = new Image("file:icons/sortie.gif");
        mur = new Image("file:icons/mur10.gif");
    }

    /**
     * Method used to draw the background image.
     */
    public void dessinFond() {
        tampon.drawImage(solImage, 0, 0, unite * labyrinthe.getLargeur(),
                unite * labyrinthe.getHauteur());
    }

    /**
     * Method used to draw the rooms of the mase.
     */
    public void dessinSalleEtMur() {
        // dessin des salles
        for (var s : this.labyrinthe) {
            if (s.equals(labyrinthe.getEntree())) {
                tampon.drawImage(entree, s.getX() * unite, s.getY() * unite);
            } else if (s.equals(labyrinthe.getSortie())) {
                tampon.drawImage(sortie, s.getX() * unite, s.getY() * unite);
            } else {
                tampon.drawImage(salleImage, s.getX() * unite, s.getY() * unite);
            }
        }
        // dessin des murs
        HashSet<ISalle> murs = new HashSet<>();
        // on calcule les coordonnées de toutes les salles possibles
        for (int i = 0; i < this.labyrinthe.getLargeur(); i++) {
            for (int j = 0; j < this.labyrinthe.getHauteur(); j++) {
                murs.add(new Salle(i, j));
            }
        }
        // on retire les salles existentes
        murs.removeAll(this.labyrinthe);
        // reste les murs
        for (var actu : murs) {
            tampon.drawImage(mur, actu.getX() * unite, actu.getY() * unite);
        }
    }
}
