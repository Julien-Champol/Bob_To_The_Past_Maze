/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;
import labyrinthe.Salle;

/**
 *
 * @author jchampol
 */
public abstract class APersonnage implements IPersonnage {

    //La salle où le joueur se trouve
    private ISalle positionCourante;

    // renvoie une salle parmi sallesAccesibles
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
