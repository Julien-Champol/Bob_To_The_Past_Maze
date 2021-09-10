/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 * Class representing data about the hero.
 *
 * @author jchampol
 */
public class Heros extends APersonnage {

    //The room the player has chosen
    public ISalle salleChoisie;

    /**
     * Parameterized constructor of the Heros class
     *
     * @param entree
     */
    public Heros(ISalle entree) {
        this.salleChoisie = entree;
    }

    /**
     * Method used to return the room chosen by the player if it's accessible,
     * else his current position
     *
     * @param sallesAccessibles the accessibles room
     * @return the room
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
