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
    private int unite = 15;

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

    /**
     * Constructeur paramétré de la classe Dessin
     *
     * @param labyrinthe la labyrinthe à représenter
     * @param sprites les sprites à dessiner
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
     * Méthode de dessin de l'image de fond
     */
    public void dessinFond() {
        tampon.drawImage(solImage, 0, 0, unite * labyrinthe.getLargeur(),
                unite * labyrinthe.getHauteur());
    }

    /**
     * Méthode de dessin des salles et des murs
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
