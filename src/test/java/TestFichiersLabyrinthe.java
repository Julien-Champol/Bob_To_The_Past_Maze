
import static org.junit.Assert.*;
import java.io.File;
import labyrinthe.Labyrinthe;
import org.junit.Test;
import outils.Fichier;

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

    @Test
    public void testCoordonneesSalles() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

    @Test
    public void testPasDeDoublon() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

    @Test
    public boolean testCoordonneesSallesFichier(File f) {
        Labyrinthe test = new Labyrinthe();
        test.creerLabyrinthe(f.getName());
        for (var s : test) {
            if (!(s.getX() >= 0 && s.getX() < test.getLargeur()
                    && s.getY() >= 0 && s.getY() < test.getHauteur())) {
                return false;
            }
        }
        return true;
    }
}
