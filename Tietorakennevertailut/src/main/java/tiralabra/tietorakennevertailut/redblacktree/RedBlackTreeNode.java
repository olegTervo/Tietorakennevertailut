package tiralabra.tietorakennevertailut.redblacktree;

public class RedBlackTreeNode implements Comparable {
    public RedBlackTreeNode parent;
    public RedBlackTreeNode left;
    public RedBlackTreeNode right;
    public boolean isRed;
    
    public int key;
    
    public boolean isNill() {
        return this.left == null;
    }
    
    public RedBlackTreeNode(int key, RedBlackTreeNode parent) {
        this.isRed = true;
        this.key = key;
        this.parent = parent;
        
        this.left = new RedBlackTreeNode();
        this.right = new RedBlackTreeNode();
    }
    
    public RedBlackTreeNode(int key) {
        this.key = key;
        this.isRed = true;
        
        this.left = new RedBlackTreeNode();
        this.right = new RedBlackTreeNode();
    }
    
    public RedBlackTreeNode() {
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
            if(parent.equals(grandparent.left)) {
                return grandparent.right;
            }
            return grandparent.left;
        }
        
        return null;
    }
    
    public RedBlackTreeNode getSubling() {
        if(this.equals(this.parent.left)) {
            return this.parent.right;
        } else {
            return this.parent.left;
        }
    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass().equals(this.getClass())) {
            return ((RedBlackTreeNode) o).key - this.key;
        }
        else return -1;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        
        if(o.getClass().equals(this.getClass())) {
            return ((RedBlackTreeNode) o).key - this.key == 0;
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.key;
        return hash;
    }
    
}
