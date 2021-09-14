package application;

import java.io.IOException;
import static java.lang.System.exit;
import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import vue2D.IVue;
import vue2D.sprites.HerosSprite;
import vue2D.sprites.ISprite;
import vue2D.sprites.MonstreSprite;

/**
 * Class giving the fundamental methods so that the code can run
 *
 * @author INFO Professors team
 */
public class Core {

    ISprite heros;
    ILabyrinthe labyrinthe;

    /**
     * Method used to initialize the mase
     */
    protected void initLabyrinthe() {
        // creation du labyrinthe
        labyrinthe = new labyrinthe.Labyrinthe();
        chargementLaby("labys/level3.txt");
    }

    /**
     * Method used to initilaize the sprites
     *
     * @param vue
     */
    protected void initSprites(IVue vue) {
        // creation du heros 
        IPersonnage h = new personnages.Heros(labyrinthe.getEntree());
        this.heros = new HerosSprite(h, labyrinthe);
        vue.add(this.heros);
        //creation des monstres
        IPersonnage m = new personnages.Monstre(labyrinthe.getSortie());
        vue.add(new MonstreSprite(m, labyrinthe));
        m = new personnages.Monstre(labyrinthe.getSortie());
        vue.add(new MonstreSprite(m, labyrinthe));
        m = new personnages.Monstre(labyrinthe.getSortie());
        vue.add(new MonstreSprite(m, labyrinthe));
        m = new personnages.Monstre(labyrinthe.getSortie());
        vue.add(new MonstreSprite(m, labyrinthe));
        m = new personnages.Monstre(labyrinthe.getSortie());
        vue.add(new MonstreSprite(m, labyrinthe));
        m = new personnages.Monstre(labyrinthe.getSortie());
        vue.add(new MonstreSprite(m, labyrinthe));
        m = new personnages.Monstre(labyrinthe.getSortie());
        vue.add(new MonstreSprite(m, labyrinthe));
        m = new personnages.Monstre(labyrinthe.getSortie());
        vue.add(new MonstreSprite(m, labyrinthe));
        m = new personnages.Monstre(labyrinthe.getSortie());
        vue.add(new MonstreSprite(m, labyrinthe));
        m = new personnages.Monstre(labyrinthe.getSortie());
        vue.add(new MonstreSprite(m, labyrinthe));
        m = new personnages.Monstre(labyrinthe.getSortie());
        vue.add(new MonstreSprite(m, labyrinthe));
    }

    /**
     * The game's loop
     *
     * @param vue
     */
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
        try {
            labyrinthe.creerLabyrinthe(fic);
        } catch (IOException ex) {
            try {
                System.out.println("!!Fichier invalide, chargement à partir du niveau 7!!");
                fic = "labys/level7.txt";
                labyrinthe.creerLabyrinthe(fic);
            } catch (IOException e) {
                System.out.println("Fichier de secours invalide, arrêt du programme.");
                exit(1);
            }
        }
    }

    /**
     * Method used to put the program to sleep for nb miliseconds
     *
     * @param nb the number of miliseconds
     */
    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // pause de nb millisecondes
        } catch (InterruptedException ie) {
        };
    }
}
