/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.tietorakennevertailut.redblacktree;

/**
 *
 * @author oleg
 */
public class RedBlackTreeNode implements Comparable {
    public RedBlackTreeNode parent;
    public RedBlackTreeNode left;
    public RedBlackTreeNode right;
    public boolean isRed;
    
    public int key;
    
    public RedBlackTreeNode(int key) {
        this.key = key;
        this.isRed = false;
    }
    
    public boolean isRedColor() { 
        return this.isRed; 
    }
    
    public RedBlackTreeNode getGrandparent() {
        if(parent != null) {
            return parent.parent;
        }
        return null;
    }
    
    public RedBlackTreeNode getUncle() {
        RedBlackTreeNode grandparent = getGrandparent();
        if(grandparent != null) {
            if(grandparent.left.equals(parent)) {
                return grandparent.right;
            }
            return grandparent.left;
        }
        
        return null;
    }
    
    public void rotateLeft() {
        RedBlackTreeNode pivotNode = right;
        
        pivotNode.parent = parent;
        if(parent != null) {
            if(parent.left.equals(this)){
                parent.left = pivotNode;
            } else {
                parent.right = pivotNode;
            }
        }
        
        this.right = pivotNode.left;
        if(pivotNode.left != null) {
            pivotNode.left.parent = this;
        }
        
        this.parent = pivotNode;
        pivotNode.left = this;
    }
    
    public void rotateRight() {
        RedBlackTreeNode pivotNode = left;
        
        pivotNode.parent = parent;
        if(parent != null) {
            if(parent.left.equals(this)){
                parent.left = pivotNode;
            } else {
                parent.right = pivotNode;
            }
        }
        
        this.left = pivotNode.right;
        if(pivotNode.right != null) {
            pivotNode.right.parent = this;
        }
        
        this.parent = pivotNode;
        pivotNode.right = this;
    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass().equals(this.getClass())) {
            return ((RedBlackTreeNode) o).key - this.key;
        }
        else return -1;
    }
}
