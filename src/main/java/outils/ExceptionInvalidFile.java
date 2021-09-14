package outils;

import java.io.IOException;

/**
 * Exception lancée quand on tente de charger un fichier invalide, hérite de
 * IOException en cohérence avec le code de Core
 *
 * @author jchampol
 */
public class ExceptionInvalidFile extends IOException {

    /**
     * Constructeur paramétré de la classe ExceptionInvalidFile
     *
     * @param message message affiché lorsque l'exception est lancéeF
     */
    public ExceptionInvalidFile(String message) {
        super(message);
    }
}
