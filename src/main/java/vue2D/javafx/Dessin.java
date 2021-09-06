package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import vue2D.sprites.ISprite;

/**
*
* @author INFO Professors team
*/

public class Dessin extends Canvas {
    
    private Collection<ISprite> sprites;
    private ILabyrinthe labyrinthe;
    private int unite = 15;
    private GraphicsContext tampon;
    private Image solImage;
   
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites)
    {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        setWidth(labyrinthe.getLargeur()*unite);
        setHeight(labyrinthe.getHauteur()*unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond(); 
    }
    
     public void chargementImages(){
    	solImage = new Image("file:icons/pyramide.jpg");
    }
    
    public void dessinFond(){
        tampon.drawImage(solImage,0,0,unite*labyrinthe.getLargeur(),
                unite*labyrinthe.getHauteur());
    }

}
