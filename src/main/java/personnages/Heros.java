/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 * Classe représentant des données sur un héros
 *
 * @author jchampol
 */
public class Heros extends APersonnage {

    // La salle choisie par le joueur
    public ISalle salleChoisie;

    /**
     * Constructeur paramétré de la classe Heros
     *
     * @param entree la salle où le héros est placé en début de jeu
     */
    public Heros(ISalle entree) {
        // placement du joueur à la première des positions qu'il occuperaF
        this.setPosition(entree);
    }

    /**
     * Méthode retournant la salle choisie par le joueur si elle est accessible,
     * sa position actuelle autrement
     *
     * @param sallesAccessibles les salles accessibles
     * @return la salle en question
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (sallesAccessibles.contains(salleChoisie)) {
            return salleChoisie;
        } else {
            return this.getPosition();
        }
    }

}
