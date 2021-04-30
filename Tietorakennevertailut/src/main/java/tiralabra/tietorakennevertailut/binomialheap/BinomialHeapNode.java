package tiralabra.tietorakennevertailut.binomialheap;

public class BinomialHeapNode {
    public int key;
    public int degree;

    public BinomialHeapNode parent = null;
    public BinomialHeapNode sibling = null;
    public BinomialHeapNode child = null;

    public BinomialHeapNode() {
        this.degree = 0;
    }
    
    public BinomialHeapNode(int key) {
        this.key = key;
        this.degree = 0;
    }
    
    public BinomialHeapNode(BinomialHeapNode other) {
        this.key = other.key;
        this.degree = other.degree;
        this.parent = other.parent;
        this.child = other.child;
    }
    
    public static BinomialHeapNode copy(BinomialHeapNode other) {
        BinomialHeapNode ret = new BinomialHeapNode();
        ret.key = other.key;
        ret.degree = other.degree;
        ret.parent = other.parent;
        ret.child = other.child;
        ret.sibling = other.sibling;
        
        return ret;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        
        if(o.getClass().equals(this.getClass())) {
            BinomialHeapNode other = (BinomialHeapNode) o;
            return other.degree == this.degree &&
                    other.key == this.key &&
                    ((other.parent != null && this.parent != null && other.parent.key == this.parent.key) ||
                        (other.parent == null && this.parent == null)) &&
                    ((other.sibling != null && this.sibling != null && other.sibling.key == this.sibling.key) ||
                        (other.sibling == null && this.sibling == null)) &&
                    ((other.child != null && this.child != null && other.child.key == this.child.key) ||
                        (other.child == null && this.child == null));
        }
        else return false;
    }
}
