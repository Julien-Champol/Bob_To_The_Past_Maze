package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import personnages.IPersonnage;

/**
*
* @author INFO Professors team
*/
public interface ISprite extends IPersonnage{
	public void dessiner(GraphicsContext g);
	public void setCoordonnees(int xpix, int ypix);
}
