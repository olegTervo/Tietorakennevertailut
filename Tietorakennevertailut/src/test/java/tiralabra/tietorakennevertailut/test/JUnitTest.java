/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.tietorakennevertailut.test;

import java.util.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oleg
 */
public class JUnitTest {
    
    List testList;
    
    public JUnitTest() {
        testList = new ArrayList<String>();
    }
    
    private List getTestlist() {
        return this.testList;
    }
    
    @Before
    public void setUp() {
        for(int i = 0; i < 10000; i++) testList.add(i);
    }
    
    @After
    public void tearDown() {
        testList = new ArrayList<String>();
    }

    @Test
    public void test1() {
        assertTrue(testList.indexOf(4444) == 4444);
    }
    
    @Test
    public void test2() {
        List t1 = testList;
        t1.remove("10");
        Assert.assertFalse(t1.contains("10"));
        Assert.assertFalse(testList.contains("10"));
        Assert.assertFalse(this.testList.contains("10"));
        
        List t2 = this.testList;
        t2.remove("11");
        Assert.assertFalse(t1.contains("11"));
        Assert.assertFalse(testList.contains("11"));
        Assert.assertFalse(this.testList.contains("11"));
        
        List t3 = getTestlist();
        t3.remove("12");
        Assert.assertFalse(t1.contains("12"));
        Assert.assertFalse(testList.contains("12"));
        Assert.assertFalse(this.testList.contains("12"));
        
        Assert.assertTrue(t1 == t2);
        Assert.assertTrue(testList == t2);
        Assert.assertEquals(t1, t3);
    }
}
