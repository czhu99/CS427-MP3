package BlackBox.Setups;

import BlackBox.PUTs.SortAlgorithmPUT;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class SortSetup {

    protected static SortAlgorithmPUT sortAlgorithmPUT;

    @BeforeClass
    public static void setUp(){
        sortAlgorithmPUT = new SortAlgorithmPUT();
    }

}
