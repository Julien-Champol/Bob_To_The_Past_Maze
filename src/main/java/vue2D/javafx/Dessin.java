package vue2D.javafx;

import java.util.Collection;
import java.util.HashSet;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import vue2D.sprites.ISprite;

/**
 * Classe représentant des données sur les méthodes de dessin du jeu
 *
 * @author INFO Professors team
 */
public class Dessin extends Canvas {

    // les sprites à dessiner sur le labyrintheF
    private Collection<ISprite> sprites;

    // le labyrinthe que l'on représente
    private ILabyrinthe labyrinthe;

    // l'unite par laquelle on multiplie la taille de l'imageF
    private final int UNITE = 15;

    // l'instance de GraphicsContext qui nous permet de réaliser les dessins
    private GraphicsContext tampon;

    // le sol
    private Image solImage;

    // les salles
    private Image salleImage;

    // l'entrée du labyrinthe
    private Image entree;

    // la sortie du labyrinthe 
    private Image sortie;

    // un mur
    private Image mur;

    // image temporaire
    private Image tmp;
    
    private HashSet<ISalle> murs = new HashSet<>();

    /**
     * Constructeur paramétré de la classe Dessin
     *
     * @param labyrinthe la labyrinthe à représenter
     * @param sprites les sprites à dessiner
     */
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        setWidth(labyrinthe.getLargeur() * UNITE);
        setHeight(labyrinthe.getHauteur() * UNITE);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
        dessinSalleEtMur();
    }

    /**
     * Méthode chargeant les images depuis le dossier icons/
     */
    public void chargementImages() {
        solImage = new Image("file:icons/pyramide.jpg");
        salleImage = new Image("file:icons/ground.gif");
        entree = new Image("file:icons/groundP.gif");
        sortie = new Image("file:icons/sortie.gif");
        mur = new Image("file:icons/mur10.gif");
    }

    /**
     * Méthode retournant vrai ssi une salle ou un mur est hors d'un certain
     * périmètre autour d'un sprite Trouvable à cette addresse :
     *
     * https://stackoverflow.com/questions/481144/equation-for-testing-if-a-point-is-inside-a-circle
     *
     * @param test la salle à tester
     * @param centre la position du sprite
     * @param rayon le rayon autour du sprite
     * @return vrai ssi test n'est pas dans le rayon de centre
     */
    public boolean perimetreSprite(ISalle test, ISalle centre, int rayon) {
        return (Math.pow(test.getX() - centre.getX(), 2) + Math.pow(test.getY() - centre.getY(), 2) > Math.pow(rayon, 2));
    }

    /**
     * Méthode de dessin de l'image de fond
     */
    public void dessinFond() {
        tampon.drawImage(solImage, 0, 0, UNITE * labyrinthe.getLargeur(),
                UNITE * labyrinthe.getHauteur());
    }

    /**
     * Méthode de dessin des salles et des murs
     */
    public void dessinSalleEtMur() {
        for (ISprite sprite : sprites) {
            for (ISalle s : this.labyrinthe) {
                //ajustement de l'opacité
                if (perimetreSprite(s, sprite.getPosition(), 5)) {
                    tampon.setGlobalAlpha(0.2);
                } else if (perimetreSprite(s, sprite.getPosition(), 3)) {
                    tampon.setGlobalAlpha(0.6);
                } else if (perimetreSprite(s, sprite.getPosition(), 2)) {
                    tampon.setGlobalAlpha(0.9);
                }
                // On commence à dessiner
                if (s.equals(labyrinthe.getEntree())) {
                    tmp = entree;
                } else if (s.equals(labyrinthe.getSortie())) {
                    tmp = sortie;
                } else {
                    tmp = salleImage;
                }
                tampon.drawImage(tmp, s.getX() * UNITE, s.getY() * UNITE);
            }

            // dessin des murs
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
                tampon.drawImage(mur, actu.getX() * UNITE, actu.getY() * UNITE);
            }
            tampon.setGlobalAlpha(1);
        }
    }
}
