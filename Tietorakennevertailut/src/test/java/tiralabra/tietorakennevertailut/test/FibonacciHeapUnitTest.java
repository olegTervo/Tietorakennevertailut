package tiralabra.tietorakennevertailut.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tiralabra.tietorakennevertailut.fibonacciheap.FibonacciHeap;
public class FibonacciHeapUnitTest {
    
    private FibonacciHeap testmin;
    private FibonacciHeap testmax;    
    
    @Before
    public void setUp() {
        this.testmin = new FibonacciHeap(true);
        this.testmax = new FibonacciHeap(false);
        
        for(int i = 0; i < 10; i++) {
            this.testmin.Insert(i);
            this.testmax.Insert(i);
        }
    }
    
    @After
    public void tearDown() {
        this.testmin = null;
        this.testmax = null;
    }
    
    @Test
    public void InsertTest() {
        Assert.assertTrue(this.testmin.isMinHeap);
        Assert.assertFalse(this.testmax.isMinHeap);        
        
        Assert.assertEquals(0, this.testmin.GetRoot());
        //Assert.assertEquals(9, this.testmax.GetRoot());
    }
    
    @Test
    public void PopTest() {
        for(int i = 0; i < 10; i++) {
            int pop = this.testmin.PopRoot();
            Assert.assertEquals(i, pop);
        }
        //for(int i = 9; i >= 0; i--) {
        //    Assert.assertEquals(this.testmax.PopRoot(), i);
        //}
    }
    
    @Test
    public void FindTest() {
        Assert.assertEquals(3, testmin.Find(3).key);
    }
}
