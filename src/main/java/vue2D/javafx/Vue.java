package vue2D.javafx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import labyrinthe.ILabyrinthe;
import vue2D.IVue;
import vue2D.AVue;
import vue2D.sprites.ISprite;

/**
 * Class representing data about the view using the structure of AVue and Ivue
 *
 * @author INFO Professors team
 */
public class Vue extends AVue implements IVue {
    
    Dessin dessin;
    ILabyrinthe labyrinthe;
    public Scene scene;

    /**
     * Parameterized constructor of the class
     *
     * @param labyrinthe
     */
    public Vue(ILabyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        dessin = new Dessin(labyrinthe, this);
        Group root = new Group();
        this.scene = new Scene(root);
        root.getChildren().add(dessin);
    }

    /**
     * The drawing method of the view
     */
    @Override
    public void dessiner() {
        // recopie du fond (image); murs + salles
        dessin.dessinFond();
        dessin.dessinSalle();
        // dessin des sprites
        for (ISprite s : this) {
            s.dessiner(dessin.getGraphicsContext2D());
        }
    }

    /**
     * Method used to tell that the keylistener is on, helps to manage the key
     * strokes
     *
     * @param sprite
     * @return
     */
    @Override
    public boolean add(ISprite sprite) {
        super.add(sprite);
        // si le sprite est controle par le clavier
        if (sprite instanceof EventHandler) {
            System.out.println("registering keylistener");
            // association de l'ecouteur sur le clavier avec le composant graphique principal
            this.scene.setOnKeyPressed((EventHandler) sprite);
        }
        return true;
    }
}
