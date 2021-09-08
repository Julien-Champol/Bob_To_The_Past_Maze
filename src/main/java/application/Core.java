package application;

import java.io.IOException;
import static java.lang.System.exit;
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

    /**
     * Method used to load the mase, from a default file if the one given in
     * parameters doesn't work, if this one doesn't work either we quit the
     * program.
     *
     * @param fic the file we load the mase from
     */
    private void chargementLaby(String fic) {
        boolean invalid = true;
        int i = 0;
        while (invalid) {
            try {
                labyrinthe.creerLabyrinthe(fic);
                invalid = false;
            } catch (IOException ex) {
                System.out.println("!!Fichier invalide, chargement à partir du niveau 7!!");
                fic = "labys/level7.txt";
                invalid = true;
                if (i == -1) {
                    System.out.println("Fichier de secours invalide, arrêt du programme.");
                    exit(1);
                }
                i = -1;
            }
        }
    }

    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // pause de nb millisecondes
        } catch (InterruptedException ie) {
        };
    }
}
