/*
 * To change node license header, choose License Headers in Project Properties.
 * To change node template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.tietorakennevertailut.redblacktree;

/**
 *
 * @author oleg
 */
public class RedBlackTree {
    private RedBlackTreeNode root;
    
    public boolean contains(RedBlackTreeNode node) {
        if(node == null) {
            return false;
        }
        
        RedBlackTreeNode next = root;        
        while(next != null) {
            if(next.compareTo(node) == 0) {
                return true;
            } else if(next.compareTo(node) < 0) {
                next = next.left;
            } else {
                next = next.right;
            }
        }
        
        return false;
    }
    
    public void insert(RedBlackTreeNode node) {
        if(root == null){
            root = node;
            insert1(node);
        } else {
            recursiveInsert(node, root);
        }
    }
    
    private void recursiveInsert(RedBlackTreeNode node, RedBlackTreeNode next) {
        if(next.compareTo(node) < 0) {
            if(next.left == null) {
                next.left = node;
                node.parent = next;
                insert1(node);
            } else {
                recursiveInsert(node, next.left);
            }
        } else {
            if(next.right == null) {
                next.right = node;
                node.parent = next;
                insert1(node);
            } else {
                recursiveInsert(node, next.right);
            }
        }
    }
    
    private void insert1(RedBlackTreeNode node) {
        if(node.parent == null) {
            node.isRed = false;
        } else {
            insert2(node);
        } 
    }
    
    private void insert2(RedBlackTreeNode node) {
        if(node.parent.isRed) {
            insert3(node);
        }
    }
    
    private void insert3(RedBlackTreeNode node) {
        RedBlackTreeNode uncle = node.getUncle();
        
        if(uncle != null && uncle.isRed) {
            node.parent.isRed = false;
            uncle.isRed = false;
            RedBlackTreeNode grandparent = node.getGrandparent();
            grandparent.isRed = true;
            
            insert1(grandparent);
        } else {
            insert4(node);
        }
    }
    
    private void insert4(RedBlackTreeNode node) {
        RedBlackTreeNode grandparent = node.getGrandparent();
        
        if(node.equals(node.parent.right) && node.parent.equals(grandparent.left)) {
            node.parent.rotateLeft();
            node = node.left;
        } else if(node.equals(node.parent.left) && node.parent.equals(grandparent.right)) {
            node.parent.rotateRight();
            node = node.right;
        }
        
        insert5(node);
    }
    
    private void insert5(RedBlackTreeNode node) {
        RedBlackTreeNode grandparent = node.getGrandparent();
        
        node.parent.isRed = false;
        grandparent.isRed = true;
        if(node == node.parent.left && node.parent == grandparent.left) {
            grandparent.rotateRight();
        } else {
            grandparent.rotateLeft();
        }
    }
}
