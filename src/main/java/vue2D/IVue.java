package vue2D;

import java.util.Collection;

import vue2D.sprites.ISprite;

/**
* Interface providing structure to code the view
* 
* @author INFO Professors team
*/
public interface IVue extends Collection<ISprite>{
    
    public void dessiner();
    
}
