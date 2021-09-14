/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import java.util.Random;
import labyrinthe.ISalle;

/**
 * Class representing data about a monster
 *
 * @author jchampol
 */
public class Monstre extends APersonnage {

    /**
     * Parameterized constructor of the monster class
     *
     * @param sortie
     */
    public Monstre(ISalle sortie) {
        this.setPosition(sortie);
    }

    /**
     * Method used to return the room randomly chosen by the monster if it's
     * accessible, else his current position
     *
     * @param sallesAccessibles the accessibles room
     * @return the room
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        Random rmd = new Random();
        int indice = rmd.nextInt(sallesAccessibles.size());
        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return (ISalle) sallesAccessibles.toArray()[indice];
    }
}
