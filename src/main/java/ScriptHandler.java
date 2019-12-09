import inputScript.VulnerabilityScript;

import java.util.*;
import java.util.stream.Collectors;

import static inputScript.VulnerabilityScript.COMPARE_BY_ID;

public class ScriptHandler {

    private List<VulnerabilityScript> vulnerabilityScriptList;

    public ScriptHandler(List<VulnerabilityScript> vulnerabilityScriptList) {
        this.vulnerabilityScriptList = vulnerabilityScriptList;
    }

    public void go() {
        Collections.sort(vulnerabilityScriptList, COMPARE_BY_ID);
        System.out.println("Basic scripts");
        System.out.println(vulnerabilityScriptList);
        System.out.println("Created scripts as dependencies without duplicates");
        System.out.println(createScriptsInDependencies(removeDuplicates(vulnerabilityScriptList)));
    }


    public List<VulnerabilityScript> createScriptsInDependencies(List<VulnerabilityScript> list){
        List<VulnerabilityScript> scriptList = new ArrayList<>();
        int j = 0;

        for (VulnerabilityScript script : list){
            VulnerabilityScript scr1 = new VulnerabilityScript(script.getDependencies().get(0), setNewDependencies(j));
            j++;
            VulnerabilityScript scr2 = new VulnerabilityScript(script.getDependencies().get(1), setNewDependencies(j));
            j++;
            scriptList.add(scr1);
            scriptList.add(scr2);
        }

        return scriptList;
    }

    public List<Integer> setNewDependencies(int i) {
        List<List<Integer>> ids = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(10, 11),
                        Arrays.asList(12, 13),
                        Arrays.asList(14, 15),
                        Arrays.asList(16, 17),
                        Arrays.asList(18, 19),
                        Arrays.asList(20, 21),
                        Arrays.asList(18, 19),
                        Arrays.asList(20, 21)
                ));

        return ids.get(i);
    }

    public List<VulnerabilityScript> removeDuplicates(List<VulnerabilityScript> list) {
        List<Integer> dependencies = new ArrayList<>();

        for (VulnerabilityScript script : list){
            dependencies.add(script.getScriptId());
        }

        int size = dependencies.size();

        for(int i=0; i<size-1;i++){
            if(dependencies.get(i) == dependencies.get(i+1)){
                list.remove(i+1);
                dependencies.remove(i+1);
                size--;
            }
        }
        return list;
    }
}
