package BlackBox.PUTs;

import BlackBox.LruCache;
import BlackBox.LruCacheImpl;
import Utils.LruCacheMethod;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

class CertainLruCache extends LruCacheImpl {
    public CertainLruCache(int capacity){
        super(capacity);
    }
};

public class LruCachePUT{

    public List<LruCacheMethod> lruMethodList;
    public List<int[]> inputArgsList;
    private LruCache lruCache;

    public LruCachePUT() {
        this.lruMethodList = new ArrayList<>();
        this.inputArgsList = new ArrayList<>();
    }

    public void run(LruCacheMethod lruMethod, int[] inputArgs, Integer expectedOutput){

        lruMethodList.add(lruMethod);
        if(inputArgs != null){
            inputArgsList.add(inputArgs.clone());
        }else{
            inputArgsList.add(null);
        }
        Integer output = null;
        switch (lruMethod){
            case Get:
                output = lruCache.get(inputArgs[0]);
                break;
            case Put:
                lruCache.put(inputArgs[0],inputArgs[1]);
                break;
            case Constructor:
                lruCache = new CertainLruCache(inputArgs[0]);
                break;
        }
        assertEquals(expectedOutput,output);
    }

}
