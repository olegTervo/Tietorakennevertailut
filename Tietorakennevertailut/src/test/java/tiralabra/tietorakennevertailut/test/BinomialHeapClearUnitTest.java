/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.tietorakennevertailut.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tiralabra.tietorakennevertailut.binomialheap.BinomialHeapClear;
import tiralabra.tietorakennevertailut.binomialheap.BinomialHeapNode;

/**
 *
 * @author oleg
 */
public class BinomialHeapClearUnitTest {
    
    private BinomialHeapClear testmin;
    private int n;
    
    @Before
    public void setUp() {
        this.testmin = new BinomialHeapClear();
        this.n = 15;
        
        for(int i = 0; i < n; i++) {
            this.testmin.add(i);
        }
    }
    
    @After
    public void tearDown() {
        this.testmin = null;
    }
    
    @Test(timeout = 1000)
    public void MergeTest() {
        BinomialHeapClear test = new BinomialHeapClear();
        test.add(-1);
        test = BinomialHeapClear.merge(test, testmin);
        Assert.assertEquals(-1, test.getMinumum().key);
    }
    
    @Test(timeout = 1000)
    public void InsertTest() {
        //Assert.assertEquals(10, testmin.size());
        System.out.println("Heap created:");
        this.testmin.printHeap();
    }
    
    @Test(timeout = 5000)
    public void PopTest() {
        for(int i = 0; i < n; i++) {
            BinomialHeapNode min = this.testmin.extractMinimumNode();
            Assert.assertNotNull(min);
            Assert.assertEquals(i, min.key);
        }
    }
}
