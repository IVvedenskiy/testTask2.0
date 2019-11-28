import inputScript.VulnerabilityScript;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ScriptHandler scriptHandler = new ScriptHandler(new InputData());
        scriptHandler.go(9);
    }
}
