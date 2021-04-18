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
import tiralabra.tietorakennevertailut.redblacktree.RedBlackTree;
import tiralabra.tietorakennevertailut.redblacktree.RedBlackTreeNode;

/**
 *
 * @author oleg
 */
public class RedBlackTreeUnitTest {
    private RedBlackTree test;
    
    @Before
    public void setUp() {
        test = new RedBlackTree();
    }
    
    @After
    public void tearDown() {
        test = null;
    }
    
    @Test
    public void testContains() {
        test.insert(new RedBlackTreeNode(2));
        test.insert(new RedBlackTreeNode(1));
        test.insert(new RedBlackTreeNode(3));
        
        Assert.assertTrue(test.contains(new RedBlackTreeNode(1)));
        Assert.assertTrue(test.contains(new RedBlackTreeNode(2)));
        Assert.assertTrue(test.contains(new RedBlackTreeNode(3)));
        
        Assert.assertFalse(test.contains(new RedBlackTreeNode(0)));
        
    }
}
