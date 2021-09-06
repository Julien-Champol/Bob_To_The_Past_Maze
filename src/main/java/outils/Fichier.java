package outils;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author INFO Professors team
 */
public class Fichier {
    Scanner sc=null;
    
    public Fichier(String nomFichier){
        try{
	    sc = new Scanner(new File(nomFichier));
	}
	catch(Exception e){ System.out.println(e); }     
    }
    
  // retourne le prochain entier dans le fichier
  // retourne -1 s'il n'y en a pas
    public int lireNombre(){
        if (sc.hasNextInt()){
            return sc.nextInt();
        }
        return -1;
    }
    
}
