import java.util.Arrays;
import java.util.List;

public class InputData {
    private List<Integer> dependencies;

    public InputData() {
        dependencies = Arrays.asList(3, 2, 4);
    }

    public List<Integer> getDependencies() {
        return dependencies;
    }
}
