/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import personnages.IPersonnage;
import personnages.Monstre;

/**
 * Classe associant un sprite à un sprite
 *
 * @author jchampol
 */
public class MonstreSprite extends ASprite {

    /**
     * le monstre que l'on représente
     */
    private Monstre monMonstre;

    /**
     * Constructeur paramétré de la classe
     *
     * @param monMonstre le monstre à représenter
     * @param laby le labyrinthe
     */
    public MonstreSprite(IPersonnage monMonstre, ILabyrinthe laby) {
        super(monMonstre, new Image("file:icons/monstre1.gif"));
        this.monMonstre = new Monstre(laby.getSortie());
    }
}
