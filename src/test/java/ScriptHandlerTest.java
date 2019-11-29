import org.junit.Before;
import org.junit.Test;
import sun.font.Script;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScriptHandlerTest {
    private ScriptHandler scriptHandler;

    @Before
    public void setUp() {
        scriptHandler = new ScriptHandler(new InputData());
    }

    @Test
    public void shouldRemoveIdOfMainScriptFromListDependenciesWithMainId() {
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 7, 5, 6);
        List<Integer> expected = Arrays.asList(2, 3, 5, 6, 7);

        List<Integer> actual = scriptHandler.removeMainIdFromDependencies(list, 1);

        assertEquals(actual, expected);
    }

    @Test
    public void shouldRemoveIdOfMainScriptFromListDependenciesWithoutMainId() {
        List<Integer> list = Arrays.asList(2, 3, 7, 5, 6);
        List<Integer> expected = Arrays.asList(2, 3, 5, 6, 7);

        List<Integer> actual = scriptHandler.removeMainIdFromDependencies(list, 1);

        assertEquals(actual, expected);
    }

    @Test
    public void shouldSetNewDependenciesForSecondId(){
        List<Integer> expected = Arrays.asList(5, 6);

        List<Integer> actual = scriptHandler.setNewDependencies(0);

        assertEquals(actual, expected);
    }
}