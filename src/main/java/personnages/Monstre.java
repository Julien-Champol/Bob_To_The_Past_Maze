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
 * Classe représentant des données sur un monstre qui est un type de personnage
 *
 * @author jchampol
 */
public class Monstre extends APersonnage {

    /**
     * Constructeur paramétré de la calsse MFonstre
     *
     * @param sortie les monstres sont placés à la sortie du laby par défautF
     */
    public Monstre(ISalle sortie) {
        this.setPosition(sortie);
    }

    /**
     * Méthode retournant la salle choisie aléatoirement par le monstre parmis
     * les salles accessibles
     *
     * @param sallesAccessibles les salles accessibles pour le monstre depuis sa
     * salle actuelle
     * @return la salle choisie
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        Random rmd = new Random();
        // on ralentit le déplacement des monstres
        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        // on choisit aléatoirement un indice compris entre 0 et la taille de 
        // la collection des sallesAccessibles
        return (ISalle) sallesAccessibles.toArray()[rmd.nextInt(sallesAccessibles.size())];
    }
}
