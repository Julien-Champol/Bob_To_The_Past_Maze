package vue2D.javafx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import labyrinthe.ILabyrinthe;
import vue2D.IVue;
import vue2D.AVue;
import vue2D.sprites.ISprite;

/**
 * Classe représentant des données sur la vue graphique d'un labyrinthe
 *
 * @author INFO Professors team
 */
public class Vue extends AVue implements IVue {

    // Instance de Dessin permettant d'appeler les méthodes de dessin sur le labyrinthe
    Dessin dessin;

    // Le labyrinthe représenté
    ILabyrinthe labyrinthe;

    // Elément obligatoire
    public Scene scene;

    /**
     * COnstructeur paramétré de la classe
     *
     * @param labyrinthe le labyrinthe à représenter
     */
    public Vue(ILabyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        dessin = new Dessin(labyrinthe, this);
        Group root = new Group();
        this.scene = new Scene(root);
        root.getChildren().add(dessin);
    }

    /**
     * Méthode de dessin des éléments du labyrinthe
     */
    @Override
    public void dessiner() {
        // recopie du fond (image); murs + salles
        dessin.dessinFond();
        dessin.dessinSalleEtMur();
        // dessin des sprites
        this.forEach(s -> {
            s.dessiner(dessin.getGraphicsContext2D());
        });
    }

    /**
     * Méthode d'ajout d'un sprite à la vue
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
