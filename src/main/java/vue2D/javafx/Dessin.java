package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import vue2D.sprites.ISprite;

/**
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

    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        setWidth(labyrinthe.getLargeur() * unite);
        setHeight(labyrinthe.getHauteur() * unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
        dessinSalle();
    }

    /**
     * Method used to load the images from the icons folder.
     */
    public void chargementImages() {
        solImage = new Image("file:icons/pyramide.jpg");
        salleImage = new Image("file:icons/ground.gif");
        entree = new Image("file:icons/groundP.gif");
        sortie = new Image("file:icons/sorties.gif");
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
    public void dessinSalle() {
        //this.labyrinthe.forEach(n -> tampon.drawImage(salleImage, n.getX() * unite, n.getY() * unite));
        for (var s : this.labyrinthe) {
            if (s.equals(labyrinthe.getEntree())) {
                tampon.drawImage(entree, s.getX() * unite, s.getY() * unite);
            } else if (s.equals(labyrinthe.getSortie())) {
                tampon.drawImage(sortie, s.getX() * unite, s.getY() * unite);
            } else {
                tampon.drawImage(salleImage, s.getX() * unite, s.getY() * unite);
            }
        }
    }
}
