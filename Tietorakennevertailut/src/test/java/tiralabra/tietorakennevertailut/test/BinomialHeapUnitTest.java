package tiralabra.tietorakennevertailut.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tiralabra.tietorakennevertailut.binomialheap.BinomialHeap;

public class BinomialHeapUnitTest {
    
    private BinomialHeap testmin;
    
    @Before
    public void setUp() {
        this.testmin = new BinomialHeap();
        
        for(int i = 0; i < 10; i++) {
            this.testmin.add(i);
        }
        
        testmin.printHeap();
        System.out.println("\n");
    }
    
    @After
    public void tearDown() {
        this.testmin = null;
    }
    
    @Test(timeout = 1000)
    public void MergeTest() {
        BinomialHeap test = new BinomialHeap();
        test.add(-1);
        test = BinomialHeap.merge(test, testmin);
        System.out.println("Merge test");
        test.printHeap();
    }
    
    @Test(timeout = 5000)
    public void PopTest() {
        System.out.println("Pop test");
        for(int i = 0; i < 10; i++) {
            System.out.println(testmin.getMinumum().key + " : " + i);
            Assert.assertEquals(i, this.testmin.extractMinimumNode().key);
        }
    }
}
