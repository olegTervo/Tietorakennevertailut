package tiralabra.tietorakennevertailut.redblacktree;

public class RedBlackTree {
    public RedBlackTreeNode root;
    
    public boolean contains(RedBlackTreeNode node) {
        if(node == null) {
            return false;
        }
        
        RedBlackTreeNode next = root;        
        while(next != null) {
            if(next.equals(node)) {
                return true;
            } else if(next.compareTo(node) < 0) {
                next = next.left;
            } else {
                next = next.right;
            }
        }
        
        return false;
    }
    
    public void insert(int key) {
        if(root == null) {
            root = new RedBlackTreeNode(key);
            insert1(root);
        } else {
            recursiveInsert(new RedBlackTreeNode(key), root);
        }
    }
    
    public void delete(RedBlackTreeNode node) {
        
        if(node != null && root != null) {
            if(node.left == null && node.right == null) {
                if(node.equals(root)) {
                    root = null;
                } else if(node.equals(node.parent.left)) {
                    node.parent.left = new RedBlackTreeNode();
                    return;
                } else {
                    node.parent.right = null;
                    return;
                }
            } else if(node.left.isNill() || node.right.isNill()) {
                deleteOneChild(node);
            } else {
                RedBlackTreeNode maxLeftChild = node.left;
                
                while(!maxLeftChild.right.isNill()) {
                    maxLeftChild = maxLeftChild.right;
                }
                node.key = maxLeftChild.key;
                delete(maxLeftChild);
            }
        }
        
    }
    
    private void replaceNode(RedBlackTreeNode node, RedBlackTreeNode child) {
        child.parent = node.parent;
        if(node.parent != null) {
            if(node.equals(node.parent.left)) {
                node.parent.left = child;
            } else {
                node.parent.right = child;
            }
        }
        else {
            root = child;
        }
    }
    
    private void deleteOneChild(RedBlackTreeNode node) {
        RedBlackTreeNode child;
        
        if(node.right.isNill()) {
            child = node.left;
        } else {
            child = node.right;
        }
        
        replaceNode(node, child);
        if(!node.isRed) {
            if(child.isRed) {
                child.isRed = false;
            } else {
                delete1(child);
            }
        }
    }
    
    private void recursiveInsert(RedBlackTreeNode node, RedBlackTreeNode next) {
        if(next.compareTo(node) < 0) {
            if(next.left.isNill()) {
                next.left = node;
                node.parent = next;
                insert1(node);
            } else {
                recursiveInsert(node, next.left);
            }
        } else {
            if(next.right.isNill()) {
                next.right = node;
                node.parent = next;
                insert1(node);
            } else {
                recursiveInsert(node, next.right);
            }
        }
    }
    
    private void delete1(RedBlackTreeNode node) {
        if(node.parent != null) {
            delete2(node);
        }
    }
    
    private void delete2(RedBlackTreeNode node) {
        RedBlackTreeNode subling = node.getSubling();
        
        if(subling.isRed) {
            node.parent.isRed = true;
            subling.isRed = false;
            
            if(node.equals(node.parent.left)) {
                rotateLeft(node.parent);
            } else {
                rotateRight(node.parent);
            }
        }
        delete3(node);
    }
    
    private void delete3(RedBlackTreeNode node) {
        RedBlackTreeNode subling = node.getSubling();
        
        if(!node.parent.isRed && !subling.isRed && !subling.left.isRed && !subling.right.isRed) {
            subling.isRed = true;
            delete1(node.parent);
        } else {
            delete4(node);
        }
    }
    
    private void delete4(RedBlackTreeNode node) {
        RedBlackTreeNode subling = node.getSubling();
        
        if(node.parent.isRed && !subling.isRed && !subling.left.isRed && !subling.right.isRed) {
            subling.isRed = true;
            node.parent.isRed = false;
        } else {
            delete5(node);
        }
    }
    
    private void delete5(RedBlackTreeNode node) {
        RedBlackTreeNode subling = node.getSubling();
        
        if(!subling.isRed) {
            if(node.equals(node.parent.left) && !subling.right.isRed && subling.left.isRed) {
                subling.isRed = true;
                subling.left.isRed = false;
                rotateRight(subling);
            } else if(node.equals(node.parent.right) && !subling.left.isRed && subling.right.isRed) {
                subling.isRed = true;
                subling.right.isRed = false;
                rotateLeft(subling);
            }
        }
        delete6(node);
    }
    
    private void delete6(RedBlackTreeNode node) {
        RedBlackTreeNode subling = node.getSubling();
        subling.isRed = node.parent.isRed;
        node.parent.isRed = false;
        
        if(node.equals(node.parent.left)) {
            subling.right.isRed = false;
            rotateLeft(node.parent);
        } else {
            subling.left.isRed = false;
            rotateRight(node.parent);
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
        
        if(!uncle.isNill() && uncle.isRed) {
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
            rotateLeft(node.parent);
            node = node.left;
        } else if(node.equals(node.parent.left) && node.parent.equals(grandparent.right)) {
            rotateRight(node.parent);
            node = node.right;
        }
        
        insert5(node);
    }
    
    private void insert5(RedBlackTreeNode node) {
        RedBlackTreeNode grandparent = node.getGrandparent();
        
        node.parent.isRed = false;
        grandparent.isRed = true;
        if(node.equals(node.parent.left) && node.parent.equals(grandparent.left)) {
            rotateRight(grandparent);
        } else {
            rotateLeft(grandparent);
        }
    }

    public void rotateLeft(RedBlackTreeNode node) {
        RedBlackTreeNode childNode = node.right;
        
        childNode.parent = node.parent;
        if(node.parent != null) {
            if(node.parent.left.equals(node)){
                node.parent.left = childNode;
            } else {
                node.parent.right = childNode;
            }
        }
        else {
            root = childNode;
        }
        
        node.right = childNode.left;
        if(!childNode.left.isNill()) {
            childNode.left.parent = node;
        }
        
        node.parent = childNode;
        childNode.left = node;
    }
    
    public void rotateRight(RedBlackTreeNode node) {
        RedBlackTreeNode childNode = node.left;
        
        childNode.parent = node.parent;
        if(node.parent != null) {
            if(node.parent.left.equals(node)){
                node.parent.left = childNode;
            } else {
                node.parent.right = childNode;
            }
        }
        else {
            root = childNode;
        }
        
        node.left = childNode.right;
        if(childNode.right != null) {
            childNode.right.parent = node;
        }
        
        node.parent = childNode;
        childNode.right = node;
    }
    
}
