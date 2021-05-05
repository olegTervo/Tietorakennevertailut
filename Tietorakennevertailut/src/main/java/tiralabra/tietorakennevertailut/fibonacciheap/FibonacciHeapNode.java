package tiralabra.tietorakennevertailut.fibonacciheap;

public class FibonacciHeapNode {
    public FibonacciHeapNode parent;
    public FibonacciHeapNode left;
    public FibonacciHeapNode right;
    public FibonacciHeapNode child;
    public int degree;
    public int key;

    public FibonacciHeapNode(int key) {
        this.degree = 0;
        this.parent = null;
        this.left = this;
        this.right = this;
        this.child = null;
        this.key = key;
    }
    
    public FibonacciHeapNode(FibonacciHeapNode another) {
        this.degree = another.degree;
        this.parent = another.parent;
        this.left = another.left;
        this.right = another.right;
        this.child = another.child;
        this.key = another.key;
    }
    
    public FibonacciHeapNode getParent() {
        return this.parent;
    }
    
    public FibonacciHeapNode getChild() {
        return this.child;
    }
    
    public FibonacciHeapNode getLeft() {
        return this.left;
    }
    
    public FibonacciHeapNode getRight() {
        return this.right;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        
        if(o.getClass().equals(this.getClass())) {
            FibonacciHeapNode other = (FibonacciHeapNode) o;
            return other.degree == this.degree &&
                    other.key == this.key &&
                    ((other.parent != null && this.parent != null && other.parent.key == this.parent.key) ||
                        (other.parent == null && this.parent == null)) &&
                    ((other.left != null && this.left != null && other.left.key == this.left.key) ||
                        (other.left == null && this.left == null)) &&
                    ((other.right != null && this.right != null && other.right.key == this.right.key) ||
                        (other.right == null && this.right == null)) &&
                    ((other.child != null && this.child != null && other.child.key == this.child.key) ||
                        (other.child == null && this.child == null));
        }
        else return false;
    }
}
