package tiralabra.tietorakennevertailut.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tiralabra.tietorakennevertailut.fibonacciheap.FibonacciHeap;
import tiralabra.tietorakennevertailut.fibonacciheap.FibonacciHeapNode;
public class FibonacciHeapUnitTest {
    
    private FibonacciHeap testmin;
    private int n;
    
    @Before
    public void setUp() {
        this.testmin = new FibonacciHeap(true);
        this.n = 10;
        
        for(int i = n-1; i >= 0; i--) {
            this.testmin.Insert(i);
        }
    }
    
    @After
    public void tearDown() {
        this.testmin = null;
    }
    
    @Test
    public void InsertTest() {
        Assert.assertTrue(this.testmin.isMinHeap);
        Assert.assertEquals(0, this.testmin.GetRoot());
        Assert.assertEquals(n, this.testmin.size);
        
        Assert.assertEquals(this.testmin.Find(n-1), new FibonacciHeapNode(this.testmin.Find(n-1)));
        
        for(int i = 0; i < n; i++) {
            Assert.assertEquals(i, this.testmin.Find(i).key);
            Assert.assertNotEquals(new FibonacciHeapNode(i), this.testmin.Find(i));
        }
    }
    
    @Test
    public void PopTest() {
        for(int i = 0; i < n; i++) {
            int pop = this.testmin.PopRoot();
            Assert.assertEquals(i, pop);
        }
    }
    
    @Test
    public void FindTest() {
        Assert.assertEquals(3, testmin.Find(3).key);
    }
    
    
    //@Test
    public void stressTest() {
        for(int i = 0; i < n; i++) {
            testmin.Insert(i);
            Assert.assertNotNull(testmin.Find(i));
        }
        for(int i = 0; i < n/2; i++) {
            testmin.PopRoot();
        }
        for(int i = 0; i < n/2; i++) {
            testmin.Insert(i);
            Assert.assertNotNull(testmin.Find(i));
        }
        for(int i = 0; i < n; i++) {
            testmin.PopRoot();
        }
        
        Assert.assertNull(testmin.min);
        Assert.assertEquals(0, testmin.size);
    }
}
