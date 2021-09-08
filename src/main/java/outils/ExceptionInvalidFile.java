/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import java.io.IOException;

/**
 *
 * @author jchampol
 */
public class ExceptionInvalidFile extends IOException {

    public ExceptionInvalidFile(String message) {
        super(message);
    }
}
