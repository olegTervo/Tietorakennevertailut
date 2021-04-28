package tiralabra.tietorakennevertailut.fibonacciheap;

public class FibonacciHeap {
    public int size;
    public FibonacciHeapNode min;
    public boolean isMinHeap;
    private FibonacciHeapNode found;

    public FibonacciHeap(boolean minHeap) {
        this.isMinHeap = minHeap;
        min = null;
        size = 0;
    }

    public void Insert(int key) {
        Insert(new FibonacciHeapNode(key));
    }

    public int GetRoot() {
        return this.min.key;
    }

    public int PopRoot() {
        FibonacciHeapNode rootNode = this.min;
        
        if (rootNode != null) {
            FibonacciHeapNode child = rootNode.child;
            FibonacciHeapNode childOnStart = child;
            FibonacciHeapNode temp;
            
            if (child != null) {
                do {
                    temp = child.right;
                    Insert(child);
                    child.parent = null;
                    child = temp;
                } while (child != null && !temp.equals(childOnStart));
            }
            
            rootNode.left.right = rootNode.right;
            rootNode.right.left = rootNode.left;
            rootNode.child = null;
            
            if (rootNode.equals(rootNode.right)) {
                this.min = null;
            } else {
                this.min = rootNode.right;
                this.FixConflicts();
            }
            this.size--;
            return rootNode.key;
        }
        return this.isMinHeap ? 
                Integer.MAX_VALUE : 
                Integer.MIN_VALUE;
    }
    
    public FibonacciHeapNode Find(int key) {
        found = null;
        Find(key, this.min);
        return found;
    }
    
    private void Insert(FibonacciHeapNode node) {
        if (min == null) {
            min = node;
            node.left = min;
            node.right = min;
        } else {
            min.left.right = node;
            node.right = min;
            node.left = min.left;
            min.left = node;
                    
            if (node.key < min.key) {
                min = node;
            }
        }
        size += 1;
    }
    
    private void FixConflicts() {
        int degree = GetDegree();
        FibonacciHeapNode[] nodes = new FibonacciHeapNode[degree+1];
        
        for (int i = 0; i < degree; i++) {
            nodes[i] = null;
        }
        
        FibonacciHeapNode x = min;
        
        if (x != null) { 
            do {
                int d = x.degree;
                
                while (nodes[d] != null) {
                    FibonacciHeapNode y = nodes[d];
                    
                    if (x.key > y.key) {
                        FibonacciHeapNode tempNode = new FibonacciHeapNode(x);
                        x = y;
                        y = tempNode;
                    }
                    if(y.equals(min)){
                        this.min = x;
                    }
                    
                    Link(y, x);
                    
                    if(y.right.equals(x)) {
                        this.min = x;
                    }
                    
                    nodes[d] = null;
                    d++;
                }
                nodes[d] = x;
                x = x.right;
            } while (x != null && !x.equals(this.min));
            
            this.min = null;
            
            for (int i = 0; i < degree; ++i) {
                if (nodes[i] != null) {
                    Insert(nodes[i]);
                }
            }
        }
        
    }
    
    private int GetDegree() {
        int ret = 0;
        int s = this.size;
        while(s > 0) {
            s = s / 2;
            ret++;
        }
        
        return ret;
    }

    private void Link(FibonacciHeapNode y, FibonacciHeapNode x) {
        y.left.right = y.right;
        y.right.left = y.left;
        
        if(x.right.equals(x)) {
            this.min = x;
        }
        
        y.left = y;
        y.right = y;
        y.parent = x;
        
        if(x.child == null) {
            x.child = y;
        }
        y.right = x.child;
        y.left = x.child.left;
        x.child.left.right = y;
        x.child.left = y;
        
        if(y.key < x.child.key){
            x.child = y;
        }
        x.degree = x.degree + 1;
    }

    private void Find(int key, FibonacciHeapNode c) {
        if (found == null && c != null) {
            FibonacciHeapNode temp = c;
            do {
                if (key == temp.key)
                    found = temp;
                else {
                    FibonacciHeapNode k = temp.child;
                    Find(key, k);
                    temp = temp.right;
                }
            } while (!temp.equals(c) && found == null);
        }
    }

}
