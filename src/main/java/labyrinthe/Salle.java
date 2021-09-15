/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

/**
 * Classe représentant des données sur les salles
 *
 * @author jchampol
 */
public class Salle implements ISalle {

    //abscisse
    private int x;

    //ordonnée
    private int y;

    /**
     * Constructeur paramétré de la classe
     *
     * @param x l'abscisse de la salle
     * @param y l'ordonnée de la salle
     */
    public Salle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * accesseur sur l'abscisse
     *
     * @return
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * accesseur sur l'ordonnée
     *
     * @return
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Méthode d'identification de deux pièces adjacentes
     *
     * @param autre la salle comparée
     * @return vrai ssi salles adjacentes
     */
    @Override
    public boolean estAdjacente(ISalle autre) {
        return !this.equals(autre) && ((this.x == autre.getX() + 1 || this.x == autre.getX() - 1 || this.x == autre.getX())
                || (this.y == autre.getY() + 1 || this.y == autre.getY() - 1 || this.y == autre.getY()));
    }

    /**
     * Méthode détectant l'égalité entre deux salles
     *
     * @param obj
     * @return vrai ssi les deux salles sont identiques
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    /**
     * Méthode de hachage, override obligatoire
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.x;
        hash = 53 * hash + this.y;
        return hash;
    }

}
