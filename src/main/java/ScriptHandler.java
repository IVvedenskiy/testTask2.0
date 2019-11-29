import inputScript.VulnerabilityScript;

import java.util.*;
import java.util.stream.Collectors;

public class ScriptHandler {
    private InputData inputDependencies;
    private List<VulnerabilityScript> vulnerabilityScriptList = new ArrayList<>();

    public ScriptHandler(InputData inputDependencies) {
        this.inputDependencies = inputDependencies;
    }

    public void go(int id) {
        List<Integer> scriptIds = inputDependencies.getDependencies();
        Collections.sort(scriptIds);

        VulnerabilityScript mainScript = new VulnerabilityScript(id, removeDuplicates(removeMainIdFromDependencies(createScripts(id, scriptIds), id)));
        System.out.println("\n" + mainScript.toString() + " main");
    }

    public List<Integer> createScripts(int id, List<Integer> deps) {
        System.out.println("Scripts inside main \n");

        deps = removeMainIdFromDependencies(removeDuplicates(deps), id);
        int j = 0;

        for (Integer i : deps) {
            VulnerabilityScript scr = new VulnerabilityScript(i, setNewDependencies(j));
            vulnerabilityScriptList.add(scr);
            j++;
        }

        System.out.println(vulnerabilityScriptList);
        return deps;
    }

    public List<Integer> removeMainIdFromDependencies(List<Integer> list, int id) {
        List<Integer> ids = new ArrayList<>();
        for (Integer i : list) {
            if (i != id) {
                ids.add(i);
            }
        }
        Collections.sort(ids);
        return ids;
    }

    public List<Integer> setNewDependencies(int i) {
        List<List<Integer>> ids = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(5, 6),
                        Arrays.asList(7, 8),
                        Arrays.asList(9, 10)
                ));
        return ids.get(i);
    }

    public List<Integer> removeDuplicates(List<Integer> list) {
        return list
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
