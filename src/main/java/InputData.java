import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputData {
    private List<Integer> dependencies = new ArrayList<Integer>();

    public InputData() {
//        dependencies.add(10);
//        dependencies.add(6);
//        dependencies.add(4);
//        dependencies.add(7);
//        dependencies.add(2);
//        dependencies.add(8);
//        dependencies.add(5);
        dependencies.add(3);
        dependencies.add(1);
        dependencies.add(9);
    }

    public List<Integer> getDependencies() {
        return dependencies;
    }

    public Integer getMax(){
        Collections.sort(dependencies);
        return dependencies.get(dependencies.size()-1);
    }

    public Integer getMin(){
        Collections.sort(dependencies);
        return dependencies.get(0);
    }

    public int getElement(int el){
        for (Integer i:dependencies) {
            if(el == i)
                return i;
        }
        return 0;
    }

    public void setDependencies(List<Integer> dependencies) {
        this.dependencies = dependencies;
    }



}
