package BlackBox.Setups;

import BlackBox.PUTs.LruCachePUT;
import Utils.LruCacheMethod;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class LruCacheSetup {

    protected static LruCachePUT lruCachePUT;
    @Before
    public void setUpEach(){
        lruCachePUT = new LruCachePUT();
    }

}
