import inputScript.VulnerabilityScript;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VulnerabilityScript scriptA = new VulnerabilityScript(1, Arrays.asList(4, 5));
        VulnerabilityScript scriptB = new VulnerabilityScript(2, Arrays.asList(6, 7));
        VulnerabilityScript scriptC = new VulnerabilityScript(3, Arrays.asList(8, 9));

        List<VulnerabilityScript> vulnerabilityScriptList = new ArrayList<>(Arrays.asList(scriptA, scriptC, scriptB));

        ScriptHandler scriptHandler = new ScriptHandler(vulnerabilityScriptList);
        scriptHandler.go();
    }
}
