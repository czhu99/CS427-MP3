package BlackBox.PUTs;

import BlackBox.SortAlgorithm;
import static org.junit.Assert.assertArrayEquals;
import BlackBox.CycleSort;

import java.util.ArrayList;
import java.util.List;

class CertainSortAlgorithm extends CycleSort{};

public class SortAlgorithmPUT{

    public List<int[]> inputs;

    public SortAlgorithmPUT() {
        this.inputs = new ArrayList<>();

    }

    public void run(int[] input, int[] expectedOutput){
        if(input == null){
            inputs.add(null);
        }else {
            inputs.add(input.clone());
        }
        SortAlgorithm sa = new CertainSortAlgorithm();
        assertArrayEquals(expectedOutput,sa.sort(input));
    }

}
