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
 * Classe permettant l'initialisation du jeu et la mise à jour de la vue
 *
 * @author INFO Professors team
 */
public class Core {

    ISprite heros;
    ILabyrinthe labyrinthe;

    /**
     * Méthode utilisée pour initialiser le labyrinthe à partir d'un fichier
     */
    protected void initLabyrinthe() {
        // creation du labyrinthe
        labyrinthe = new labyrinthe.Labyrinthe();
        chargementLaby("labys/level3.txt");
    }

    /**
     * Méthode d'initialisation des sprites
     *
     * @param vue
     */
    protected void initSprites(IVue vue) {
        // creation du heros 
        IPersonnage h = new personnages.Heros(labyrinthe.getEntree());
        this.heros = new HerosSprite(h, labyrinthe);
        vue.add(this.heros);
        //creation des monstres
        for (int i = 0; i < 11; i++) {
            IPersonnage m = new personnages.Monstre(labyrinthe.getSortie());
            vue.add(new MonstreSprite(m, labyrinthe));
        }
        IPersonnage m = new personnages.Monstre(labyrinthe.getSortie());
        vue.add(new MonstreSprite(m, labyrinthe));
    }

    /**
     * La boucle de jeu
     *
     * @param vue la vue à mettre à jour
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
                if (!p.equals(heros)) {
                    if (p.getPosition().equals(heros.getPosition())) {
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
     * Méthode de création du labyrinthe à partir d'un labyrinthe par défaut,
     * quitte le programme si ce-dernier est invalide
     *
     * @param fic le fichier à partir duquel nous chargeons le fichier
     */
    private void chargementLaby(String fic) {
        try {
            labyrinthe.creerLabyrinthe(fic);
        } catch (IOException ex) {
            try {
                System.out.println("!!Fichier invalide, chargement à partir du niveau 7!!");
                //fichier de chargement par défaut
                fic = "labys/level7.txt";
                labyrinthe.creerLabyrinthe(fic);
            } catch (IOException e) {
                System.out.println("Fichier de secours invalide, arrêt du programme.");
                exit(1);
            }
        }
    }

    /**
     * Méthode mettant le programme en pause pendant nb milisecondes
     *
     * @param nb le nombre de milisecondesF
     */
    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // pause de nb millisecondes
        } catch (InterruptedException ie) {
        };
    }
}
