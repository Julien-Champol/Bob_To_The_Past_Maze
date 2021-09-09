/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import personnages.IPersonnage;

/**
 *
 * @author jchampol
 */
public class HerosSprite extends ASprite implements EventHandler<Event> {

    public HerosSprite(IPersonnage monPerso) {
        super(monPerso, new Image("file:icons/link/LinkRunR1.gif"));
    }

    @Override
    public void handle(Event arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
