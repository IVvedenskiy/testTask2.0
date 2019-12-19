import inputScript.VulnerabilityScript;

import java.util.*;

import static inputScript.VulnerabilityScript.*;

public class ScriptHandler {

    private List<VulnerabilityScript> vulnerabilityScriptList;

    public ScriptHandler() {
    }

    public List<VulnerabilityScript> go(List<VulnerabilityScript> list) {
        vulnerabilityScriptList = list;

        Collections.sort(vulnerabilityScriptList, COMPARE_BY_ID);
        removeDuplicates(vulnerabilityScriptList);
        Collections.sort(vulnerabilityScriptList, COMPARE_BY_DEPENDENCY_COUNT);
        Collections.sort(vulnerabilityScriptList, COMPARE_BY_ID_IN_DEPENDENCY);

        return vulnerabilityScriptList;
    }


    private List<VulnerabilityScript> removeDuplicates(List<VulnerabilityScript> list) {
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
