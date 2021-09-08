/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

/**
 * Class representing data about a room in a mase
 *
 * @author jchampol
 */
public class Salle implements ISalle {

    //absciss
    private int x;

    //ordinate
    private int y;

    /**
     * Parameterized constructor of the class
     *
     * @param x the room's absciss
     * @param y the room's ordinate
     */
    public Salle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * x parameter accessor
     *
     * @return
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * y parameter accessor
     *
     * @return
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Method used to tell if two rooms are adjacents
     *
     * @param autre the other room
     * @return true iff the two rooms are adjacents
     */
    @Override
    public boolean estAdjacente(ISalle autre) {
        return !this.equals(autre) && (this.x == autre.getX() + 1 || this.x == autre.getX() - 1 || this.x == autre.getX())
                || (this.y == autre.getY() + 1 || this.y == autre.getY() - 1 || this.y == autre.getY());
    }

    /**
     * Method used to know if two rooms are the same, useful in tests.
     *
     * @return true iff the two rooms are the same.
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.x;
        hash = 53 * hash + this.y;
        return hash;
    }

}
