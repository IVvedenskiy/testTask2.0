import inputScript.VulnerabilityScript;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VulnerabilityScript scriptI = new VulnerabilityScript(9, Arrays.asList());
        VulnerabilityScript scriptH = new VulnerabilityScript(8, Arrays.asList());
        VulnerabilityScript scriptG = new VulnerabilityScript(7, Arrays.asList());

        VulnerabilityScript scriptF = new VulnerabilityScript(6, Arrays.asList(scriptI.getScriptId()));
        VulnerabilityScript scriptE = new VulnerabilityScript(5, Arrays.asList(scriptF.getScriptId()));
        VulnerabilityScript scriptD = new VulnerabilityScript(4, Arrays.asList(scriptH.getScriptId()));

        VulnerabilityScript scriptC = new VulnerabilityScript(3, Arrays.asList(scriptH.getScriptId(), scriptI.getScriptId()));
        VulnerabilityScript scriptB = new VulnerabilityScript(2, Arrays.asList(scriptF.getScriptId(), scriptG.getScriptId()));
        VulnerabilityScript scriptA = new VulnerabilityScript(1, Arrays.asList(scriptD.getScriptId(), scriptE.getScriptId()));

        List<VulnerabilityScript> vulnerabilityScriptList =
                new ArrayList<>(Arrays.asList(scriptA, scriptC, scriptB,
                                              scriptI, scriptD, scriptH,
                                              scriptF, scriptE, scriptG));

        ScriptHandler scriptHandler = new ScriptHandler();
        scriptHandler.go(vulnerabilityScriptList);

        System.out.println("Basic scripts");
        System.out.println(vulnerabilityScriptList);
    }
}
