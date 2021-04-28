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
import tiralabra.tietorakennevertailut.binomialheap.BinomialHeap;

/**
 *
 * @author oleg
 */
public class BinomialHeapUnitTest {
    
    private BinomialHeap testmin;
    private BinomialHeap testmax;    
    
    @Before
    public void setUp() {
        this.testmin = new BinomialHeap(10, true);
        this.testmax = new BinomialHeap(10, false);
        
        for(int i = 0; i < 10; i++) {
            this.testmin.insert(i);
            this.testmax.insert(i);
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
        Assert.assertEquals(9, this.testmax.GetRoot());
        Assert.assertEquals(testmin.length, testmin.size);
        Assert.assertEquals(testmax.length, testmax.size);
    }
    
    @Test
    public void PopTest() {
        for(int i = 0; i < 10; i++) {
            Assert.assertEquals(this.testmin.PopRoot(), i);
        }
        for(int i = 9; i >= 0; i--) {
            Assert.assertEquals(this.testmax.PopRoot(), i);
        }
    }
}
