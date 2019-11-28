import inputScript.VulnerabilityScript;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScriptHandler {
    private InputData inputDependencies;
    private List<VulnerabilityScript> vulnerabilityScriptList = new ArrayList<>();
    private int maxInListIds;
    private int limit;

    public ScriptHandler(InputData inputDependencies) {
        this.inputDependencies = inputDependencies;
    }

    public void go(int id) {
        List<Integer> scriptIds = sortDependencies(inputDependencies.getDependencies());
        maxInListIds = inputDependencies.getMax();

        limit = removeDuplicates(removeMainIdFromDependencies(scriptIds, id)).size();

        VulnerabilityScript mainScript = new VulnerabilityScript(id, removeDuplicates(removeMainIdFromDependencies(createScripts(id, scriptIds), id)));
        System.out.println(mainScript.toString() + " main");
    }

    public List<Integer> createScripts(int id, List<Integer> deps) {
        System.out.println("Scripts inside main \n");

        deps = removeMainIdFromDependencies(removeDuplicates(deps), id);
        int start = maxInListIds + 1;
        int end = maxInListIds + limit;

        for (Integer i : deps) {
            VulnerabilityScript scr = new VulnerabilityScript(i, removeLooping(start, end, id));
            vulnerabilityScriptList.add(scr);
            start += limit;
            end += limit;
        }

        System.out.println(vulnerabilityScriptList);
        return deps;
    }

    public List<Integer> removeMainIdFromDependencies(List<Integer> list, int id){
        List<Integer> ids = new ArrayList<>();
        for(Integer i:list) {
            if(i != id){
                ids.add(i);
            }
        }
        return sortDependencies(ids);
    }

    public List<Integer> removeLooping(int start, int end, int id) {
        List<Integer> ids = new ArrayList<>();
//        for (int i = start; i < end + 1; i++) {
//            ids.add(i);
//        }
        ids.add(45);
        ids.add(9);
        ids.add(1);
        return removeMainIdFromDependencies(sortDependencies(ids),id);
    }

    public List<Integer> sortDependencies(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    public List<Integer> removeDuplicates (List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(i);
                    j--;
                }
            }
        }
        return list;
    }
}
