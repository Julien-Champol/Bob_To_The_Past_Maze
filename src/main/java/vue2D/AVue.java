package vue2D;

import java.util.concurrent.CopyOnWriteArrayList;
import vue2D.sprites.ISprite;

/**
 * Class representing data about a graphical view : here a list of sprites
 *
 * @author INFO Professors team
 */
public abstract class AVue extends CopyOnWriteArrayList<ISprite> implements IVue {
}
