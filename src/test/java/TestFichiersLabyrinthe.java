
import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
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
     * The only invalid files that are not detected with this test are
     * levelInvalide3.txt and levelInvalide4.txt because they are containing
     * duplicates.
     */
    @Test
    public void testCoordonneesSalles() {
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
     * Method used to detect duplicates. HashSets cannot contain duplicates, we
     * convert our ArrayList into a HashSet if the sizes of our containers are
     * differents, we have duplicates. This code is not a copy/paste but credits
     * to :
     * https://www.it-swarm-fr.com/fr/java/supprimer-les-doublons-de-arraylist/973017982/
     *
     */
    @Test
    public void testPasDeDoublon() {
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
