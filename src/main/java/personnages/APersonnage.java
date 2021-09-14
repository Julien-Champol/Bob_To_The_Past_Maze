/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import labyrinthe.ISalle;

/**
 * Classe abstraite apportant une structure supplémentaire pour représenter des
 * données sur un personnage
 *
 * @author jchampol
 */
public abstract class APersonnage implements IPersonnage {

    //La salle où le joueur se trouve
    private ISalle positionCourante;

    // renvoie sa position courante
    @Override
    public ISalle getPosition() {
        return positionCourante;
    }

    // definit sa position courante
    @Override
    public void setPosition(ISalle s) {
        this.positionCourante = s;
    }

}
