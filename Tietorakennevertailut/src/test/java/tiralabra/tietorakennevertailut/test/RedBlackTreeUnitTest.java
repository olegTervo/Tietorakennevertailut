package tiralabra.tietorakennevertailut.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tiralabra.tietorakennevertailut.redblacktree.RedBlackTree;
import tiralabra.tietorakennevertailut.redblacktree.RedBlackTreeNode;

public class RedBlackTreeUnitTest {
    private RedBlackTree test;
    private int n;
    
    @Before
    public void setUp() {
        test = new RedBlackTree();
        this.n = 10000000; // 15s
    }
    
    @After
    public void tearDown() {
        test = null;
    }
    
    //@Test
    public void testInsert() {
        test.insert(1);
        
        Assert.assertTrue(test.root.equals(new RedBlackTreeNode(1)));
        
        Assert.assertNotNull(test.root.right);
        Assert.assertTrue(test.root.right.isNill());
        Assert.assertNull(test.root.right.right);
        Assert.assertFalse(test.root.right.isRed);
        
        Assert.assertNotNull(test.root.left);
        
        test.insert(2);
        Assert.assertEquals(test.root, new RedBlackTreeNode(1));
        Assert.assertEquals(test.root.right.key, new RedBlackTreeNode(2).key);
        RedBlackTreeNode next = test.root;
        while(next != null) {
            System.out.println(next.key);
            next = next.right;
        }
        
        test.insert(3);
        next = test.root;
        while(next != null) {
            System.out.println(next.key);
            next = next.right;
        }
        test.insert(4);
        next = test.root;
        while(next != null) {
            System.out.println(next.key);
            next = next.right;
        }
        test.insert(5);
        
        next = test.root;
        while(next != null) {
            System.out.println(next.key);
            next = next.right;
        }
            
        Assert.assertNotEquals(test.root, new RedBlackTreeNode(1));
        Assert.assertNotNull(test.root.left);
        Assert.assertNotNull(test.root.right);
    }
    
    @Test
    public void testContains() {
        test.insert(2);
        test.insert(1);
        test.insert(3);
        
        Assert.assertTrue(test.contains(new RedBlackTreeNode(1)));
        Assert.assertTrue(test.contains(new RedBlackTreeNode(2)));
        Assert.assertTrue(test.contains(new RedBlackTreeNode(3)));
        
        Assert.assertFalse(test.contains(new RedBlackTreeNode(5)));
        
    }
    
    @Test
    public void testDelete() {
        test.insert(2);
        test.insert(1);
        test.insert(3);
        test.insert(3);
        test.insert(4);
        test.insert(5);
        
        
        Assert.assertTrue(test.contains(new RedBlackTreeNode(1)));
        Assert.assertTrue(test.contains(new RedBlackTreeNode(2)));
        Assert.assertTrue(test.contains(new RedBlackTreeNode(3)));
        
        test.delete(new RedBlackTreeNode(1));
        Assert.assertFalse(test.contains(new RedBlackTreeNode(1)));
        test.delete(new RedBlackTreeNode(2));
        Assert.assertFalse(test.contains(new RedBlackTreeNode(2)));
        test.delete(new RedBlackTreeNode(3));
        Assert.assertFalse(test.contains(new RedBlackTreeNode(3)));
        test.delete(new RedBlackTreeNode(4));
        Assert.assertFalse(test.contains(new RedBlackTreeNode(4)));
        test.delete(new RedBlackTreeNode(5));
        Assert.assertFalse(test.contains(new RedBlackTreeNode(5)));
        
        Assert.assertTrue(test.root.isNill());
        
    }
    
    @Test
    public void insertDelete() {
        for(int i = 1; i < n; i++) {
            test.insert(i);
            Assert.assertTrue(test.contains(new RedBlackTreeNode(i)));
        }
        
        for(int i = 1; i < n; i++) {
            test.delete(new RedBlackTreeNode(i));
            Assert.assertFalse(test.contains(new RedBlackTreeNode(i)));
        }
    }
}
