package vue2D;

import java.util.Collection;

import vue2D.sprites.ISprite;

/**
* Interface donnant une structure pour coder la vue du jeu
* 
* @author INFO Professors team
*/
public interface IVue extends Collection<ISprite>{
    
    public void dessiner();
    
}
