/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.tietorakennevertailut.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tiralabra.tietorakennevertailut.trie.Trie;

/**
 *
 * @author oleg
 */
public class TrieUnitTest {
    private Trie test;
        
    @Before
    public void setUp() {
        test = new Trie();
    }
    
    @After
    public void tearDown() {
        test = null;
    }

    @Test
    public void testIsEmpty() {
        test.insert("test");
        Assert.assertFalse(test.isEmpty());
    }
    
    @Test
    public void testContains() {
        test.insert("test");
        Assert.assertTrue(test.containsNode("test"));
        
        Assert.assertFalse(test.containsNode("smth"));
        Assert.assertFalse(test.containsNode("te"));
    }
    
    @Test
    public void testInsertDelete() {
        test.insert("test");
        
        Assert.assertTrue(test.containsNode("test"));
        test.delete("te");
        Assert.assertTrue(test.containsNode("test"));
        test.delete("st");
        Assert.assertTrue(test.containsNode("test"));
        
        test.delete("test");
        Assert.assertFalse(test.containsNode("test"));
        
        Assert.assertTrue(test.isEmpty());
    }
    
    @Test
    public void testGetOptions() {
        test.insert("test");
        test.insert("te");
        test.insert("t");
        test.insert("testtesttesttest");
        test.insert("smth");
        test.insert("s");
        
        Assert.assertEquals(1, test.getOptions("testtesttesttest").size());
        Assert.assertEquals("testtesttesttest", test.getOptions("testtesttesttest").get(0));
        Assert.assertEquals(4, test.getOptions("t").size());
        
        ArrayList<String> testList = new ArrayList();
        testList.addAll(Arrays.asList("t", "te", "test", "testtesttesttest"));
        Assert.assertEquals(test.getOptions("t"), testList);
        
        testList.remove("t");
        Assert.assertEquals(test.getOptions("te"), testList);
        
        Assert.assertEquals(test.getOptions("tost"), new ArrayList());
    }
}
