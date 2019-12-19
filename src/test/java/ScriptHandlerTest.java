import inputScript.VulnerabilityScript;
import org.junit.Before;
import org.junit.Test;
import sun.font.Script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScriptHandlerTest {
    private ScriptHandler scriptHandler;

    @Before
    public void setUp() {
        scriptHandler = new ScriptHandler();
    }

    @Test
    public void shouldTestGOMethod(){
        VulnerabilityScript scriptI = new VulnerabilityScript(9, Arrays.asList());
        VulnerabilityScript scriptH = new VulnerabilityScript(8, Arrays.asList());
        VulnerabilityScript scriptG = new VulnerabilityScript(7, Arrays.asList());

        VulnerabilityScript scriptF = new VulnerabilityScript(6, Arrays.asList(scriptI.getScriptId()));
        VulnerabilityScript scriptE = new VulnerabilityScript(5, Arrays.asList(scriptF.getScriptId()));
        VulnerabilityScript scriptD = new VulnerabilityScript(4, Arrays.asList(scriptH.getScriptId()));

        VulnerabilityScript scriptC = new VulnerabilityScript(3, Arrays.asList(scriptH.getScriptId(), scriptI.getScriptId()));
        VulnerabilityScript scriptB = new VulnerabilityScript(2, Arrays.asList(scriptF.getScriptId(), scriptG.getScriptId()));
        VulnerabilityScript scriptA = new VulnerabilityScript(1, Arrays.asList());



        List<VulnerabilityScript> vulnerabilityScriptList =
                new ArrayList<>(Arrays.asList(scriptE, scriptC, scriptB, scriptA, scriptD,
                        scriptH,  scriptG, scriptI, scriptF));

        List<VulnerabilityScript> expected = Arrays.asList(scriptA, scriptG, scriptH, scriptI,
                 scriptD, scriptF, scriptE, scriptB, scriptC);

        List<VulnerabilityScript> actual = scriptHandler.go(vulnerabilityScriptList);

        assertEquals(actual, expected);
    }

    @Test
    public void shouldTestGOMethodWithoutDependencies(){
        VulnerabilityScript scriptI = new VulnerabilityScript(9, Arrays.asList());
        VulnerabilityScript scriptH = new VulnerabilityScript(8, Arrays.asList());
        VulnerabilityScript scriptG = new VulnerabilityScript(7, Arrays.asList());

        VulnerabilityScript scriptF = new VulnerabilityScript(6, Arrays.asList());
        VulnerabilityScript scriptE = new VulnerabilityScript(5, Arrays.asList());
        VulnerabilityScript scriptD = new VulnerabilityScript(4, Arrays.asList());

        VulnerabilityScript scriptC = new VulnerabilityScript(3, Arrays.asList());
        VulnerabilityScript scriptB = new VulnerabilityScript(2, Arrays.asList());
        VulnerabilityScript scriptA = new VulnerabilityScript(1, Arrays.asList());



        List<VulnerabilityScript> vulnerabilityScriptList =
                new ArrayList<>(Arrays.asList(scriptE, scriptC, scriptB, scriptA, scriptD,
                        scriptH,  scriptG, scriptI, scriptF));

        List<VulnerabilityScript> expected = Arrays.asList(scriptA, scriptB, scriptC, scriptD,
                scriptE, scriptF, scriptG, scriptH, scriptI);

        List<VulnerabilityScript> actual = scriptHandler.go(vulnerabilityScriptList);

        assertEquals(actual, expected);
    }

    @Test
    public void shouldTestGOMethodWithDuplicates(){
        VulnerabilityScript scriptI = new VulnerabilityScript(9, Arrays.asList());
        VulnerabilityScript scriptH = new VulnerabilityScript(8, Arrays.asList());
        VulnerabilityScript scriptG = new VulnerabilityScript(7, Arrays.asList());

        VulnerabilityScript scriptF = new VulnerabilityScript(6, Arrays.asList(scriptI.getScriptId()));
        VulnerabilityScript scriptE = new VulnerabilityScript(5, Arrays.asList(scriptF.getScriptId()));

        VulnerabilityScript scriptD = new VulnerabilityScript(3, Arrays.asList(scriptH.getScriptId(), scriptI.getScriptId()));
        VulnerabilityScript scriptC = new VulnerabilityScript(3, Arrays.asList(scriptH.getScriptId(), scriptI.getScriptId()));
        VulnerabilityScript scriptB = new VulnerabilityScript(2, Arrays.asList(scriptF.getScriptId(), scriptG.getScriptId()));

        VulnerabilityScript scriptA = new VulnerabilityScript(1, Arrays.asList(scriptB.getScriptId()));



        List<VulnerabilityScript> vulnerabilityScriptList =
                new ArrayList<>(Arrays.asList(scriptE, scriptC, scriptB, scriptA, scriptD,
                        scriptH,  scriptG, scriptI, scriptF));

        List<VulnerabilityScript> expected = Arrays.asList(scriptG, scriptH, scriptI, scriptA,
                scriptF, scriptE, scriptB, scriptC);

        List<VulnerabilityScript> actual = scriptHandler.go(vulnerabilityScriptList);

        assertEquals(actual, expected);
    }
}