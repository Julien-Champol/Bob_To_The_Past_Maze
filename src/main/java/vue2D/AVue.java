package vue2D;

import java.util.concurrent.CopyOnWriteArrayList;
import vue2D.sprites.ISprite;

/**
 * Classe représentant des données sur la vue qui est une collection de ISprite
 *
 * @author INFO Professors team
 */
public abstract class AVue extends CopyOnWriteArrayList<ISprite> implements IVue {
}
