package tiralabra.tietorakennevertailut.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tiralabra.tietorakennevertailut.binaryheap.BinaryHeap;

public class BinaryHeapUnitTest {
    
    private BinaryHeap testmin;
    private int n;
    
    @Before
    public void setUp() {
        this.n = 10000000; //= 5s, *10 = 60s
        this.testmin = new BinaryHeap(n, true);
        
        for(int i = n; i > 0; i--) {
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
        Assert.assertEquals(1, this.testmin.GetRoot());
        Assert.assertEquals(this.testmin.length, this.testmin.size);
        
        //this.testmin.print();
    }
    
    @Test
    public void PopTest() {
        for(int i = 1; i <= n; i++) {
            int pop = this.testmin.PopRoot();
            //this.testmin.print();
            Assert.assertEquals(i, pop);
            Assert.assertEquals(n-i, this.testmin.size);
        }
    }
    
    @Test
    public void stressTest() {
        for(int i = 1; i <= n/2; i++) {
            testmin.PopRoot();
        }
        
        Assert.assertEquals(n-n/2, this.testmin.size);
        
        for(int i = 1; i <= n/2; i++) {
            testmin.Insert(i);
        }
        for(int i = 1; i <= n; i++) {
            testmin.PopRoot();
        }
        
        Assert.assertEquals(0, testmin.size);
    }
}
