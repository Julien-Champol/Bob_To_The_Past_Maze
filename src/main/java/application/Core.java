package application;

import java.io.IOException;
import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import vue2D.IVue;
import vue2D.sprites.ISprite;

/**
 *
 * @author INFO Professors team
 */
public class Core {
    ISprite heros;
    ILabyrinthe labyrinthe;

    protected void initLabyrinthe() {
        // creation du labyrinthe
        labyrinthe = new labyrinthe.Labyrinthe();
        chargementLaby("labys/level3.txt");
    }

    protected void initSprites(IVue vue) {
        // creation du heros 
        //IPersonnage h = new personnages.Heros(labyrinthe.getEntree());
        //this.heros = new HerosSprite(h, labyrinthe);
        //vue.add(this.heros);
    }

    protected void jeu(IVue vue) {
        // boucle principale
        ISalle destination = null;
        while (!labyrinthe.getSortie().equals(heros.getPosition())) {
            // choix et deplacement
            for (IPersonnage p : vue) {
                Collection<ISalle> sallesAccessibles = labyrinthe.sallesAccessibles(p);
                destination = p.faitSonChoix(sallesAccessibles); // on demande au personnage de faire son choix de salle
                p.setPosition(destination); // deplacement
            }
            // detection des collisions
            boolean collision = false;
            ISprite monstre = null;
            for (ISprite p : vue) {
                if (p != heros) {
                    if (p.getPosition() == heros.getPosition()) {
                        System.out.println("Collision !!");
                        collision = true;
                        monstre = p;
                    }
                }
            }
            if (collision) {
                vue.remove(monstre);
                vue.remove(heros);
                System.out.println("Perdu !");
                System.out.println("Plus que " + vue.size() + " personnages ...");
            }

            temporisation(50);
        }
        System.out.println("Gagné!");
    }

    private void chargementLaby(String fic) {
        try {
            labyrinthe.creerLabyrinthe(fic);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // pause de nb millisecondes
        } catch (InterruptedException ie) {
        };
    }
}
