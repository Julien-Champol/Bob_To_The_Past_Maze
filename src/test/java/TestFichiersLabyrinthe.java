
import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import outils.ExceptionInvalidFile;
import static outils.Fichier.testCoordonneesSallesFichier;
import static outils.Fichier.testDoublonsSallesFichier;

/**
 *
 * @author INFO Professors team
 */
public class TestFichiersLabyrinthe {

    private File[] getFiles(File repertoire) {
        if (!repertoire.isDirectory()) {
            fail("testCoordonneesSalles - les tests ne concernent pas un répertoire");
        }
        File[] fichiers = repertoire.listFiles();
        return fichiers;
    }

    /**
     * Test des coordonées des salles
     *
     * @throws outils.ExceptionInvalidFile
     */
    @Test
    public void testCoordonneesSalles() throws ExceptionInvalidFile {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        for (var fic : fichiers) {
            if (!testCoordonneesSallesFichier(fic)) {
                System.out.println("Invalide " + fic.getName());
            }
            assertTrue(testCoordonneesSallesFichier(fic));
        }
    }

    /**
     * Test sur les doublons
     * https://www.it-swarm-fr.com/fr/java/supprimer-les-doublons-de-arraylist/973017982/
     *
     * @throws outils.ExceptionInvalidFile
     */
    @Test
    public void testPasDeDoublon() throws ExceptionInvalidFile {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        for (var fic : fichiers) {
            assertTrue(testDoublonsSallesFichier(fic));
        }
    }

    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

}
