import inputScript.VulnerabilityScript;
import org.junit.Before;
import org.junit.Test;
import sun.font.Script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static inputScript.VulnerabilityScript.COMPARE_BY_ID;
import static org.junit.Assert.*;

public class ScriptHandlerTest {
    private ScriptHandler scriptHandler;
    private List<VulnerabilityScript> vulnerabilityScriptList = new ArrayList<>();

    @Before
    public void setUp() {
        scriptHandler = new ScriptHandler(vulnerabilityScriptList);
    }

    @Test
    public void shouldRemoveDuplicatesInMainScriptsList() {

        VulnerabilityScript scriptA = new VulnerabilityScript(1, Arrays.asList(4, 5));
        VulnerabilityScript scriptB = new VulnerabilityScript(2, Arrays.asList(6, 7));
        VulnerabilityScript scriptC = new VulnerabilityScript(3, Arrays.asList(8, 9));
        VulnerabilityScript scriptD = new VulnerabilityScript(2, Arrays.asList(6, 7));

        List<VulnerabilityScript> vulnerabilityScriptList = new ArrayList<>(Arrays.asList(scriptA, scriptC, scriptB, scriptD));
        Collections.sort(vulnerabilityScriptList, COMPARE_BY_ID);

        List<VulnerabilityScript> expected = Arrays.asList(scriptA, scriptB, scriptC);

        List<VulnerabilityScript> actual = scriptHandler.removeDuplicates(vulnerabilityScriptList);

        assertEquals(actual, expected);
    }


    @Test
    public void shouldSetNewDependenciesForSecondId(){
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(14, 15), Arrays.asList(16, 17));

        List<List<Integer>> actual = Arrays.asList(scriptHandler.setNewDependencies(2), scriptHandler.setNewDependencies(3));

        assertEquals(actual, expected);
    }

    @Test
    public void shouldSortListByComparator(){
        VulnerabilityScript scriptA = new VulnerabilityScript(1, Arrays.asList(4, 5));
        VulnerabilityScript scriptB = new VulnerabilityScript(2, Arrays.asList(6, 7));
        VulnerabilityScript scriptC = new VulnerabilityScript(3, Arrays.asList(8, 9));
        VulnerabilityScript scriptD = new VulnerabilityScript(4, Arrays.asList(10, 11));
        VulnerabilityScript scriptE = new VulnerabilityScript(5, Arrays.asList(12, 13));

        List<VulnerabilityScript> vulnerabilityScriptList =
                new ArrayList<>(Arrays.asList(scriptE, scriptC, scriptB, scriptA, scriptD));

        List<VulnerabilityScript> expected = Arrays.asList(scriptA, scriptB, scriptC, scriptD, scriptE);

        Collections.sort(vulnerabilityScriptList, COMPARE_BY_ID);
        List<VulnerabilityScript> actual = vulnerabilityScriptList;

        assertEquals(actual, expected);
    }
}