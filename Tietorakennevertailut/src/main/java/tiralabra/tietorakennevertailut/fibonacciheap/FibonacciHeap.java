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
            FibonacciHeapNode child = rootNode.getChild();
            FibonacciHeapNode childOnStart = child;
            FibonacciHeapNode temp;
            
            if (child != null) {
                do {
                    temp = child.getRight();
                    Insert(child);
                    child.parent = null;
                    child = temp;
                } while (child != null && !child.equals(childOnStart));
            }
            
            rootNode.left.right = rootNode.getRight();
            rootNode.right.left = rootNode.getLeft();
            rootNode.child = null;
            
            if (rootNode.equals(rootNode.right)) {
                this.min = null;
            } else {
                this.min = rootNode.getRight();
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
            node.left = min.getLeft();
            min.left = node;
                    
            if (node.key < min.key) {
                min = node;
            }
        }
        size += 1;
    }
    
    private void FixConflicts() {
        double phi = (1 + Math.sqrt(5)) / 2;
        int Dofn = (int) (Math.log(this.size) / Math.log(phi));
        
        FibonacciHeapNode[] nodes = new FibonacciHeapNode[Dofn+1];
        
        for (int i = 0; i < Dofn+1; i++) {
            nodes[i] = null;
        }
        
        FibonacciHeapNode w = min;
        
        if (w != null) { 
            FibonacciHeapNode check = min;
            do {
                FibonacciHeapNode x = w;
                int d = x.degree;
                
                while (nodes[d] != null) {
                    FibonacciHeapNode y = nodes[d];
                    
                    if (x.key > y.key) {
                        FibonacciHeapNode tempNode = x;
                        x = y;
                        y = tempNode;
                        w = x;
                    }
                    if(y.equals(min)){
                        this.min = x;
                    }
                    
                    Link(y, x);
                    
                    if(y.right.equals(x)) {
                        this.min = x;
                    }
                    check = x;
                    nodes[d] = null;
                    d++;
                }
                nodes[d] = x;
                w = w.getRight();
            } while (w != null && !w.equals(check));
            
            this.min = null;
            
            for (int i = 0; i < Dofn+1; ++i) {
                if (nodes[i] != null) {
                    Insert(nodes[i]);
                }
            }
        }
        
    }
    
    private void Link(FibonacciHeapNode y, FibonacciHeapNode x) {
        y.left.right = y.getRight();
        y.right.left = y.getLeft();
        
        if(x.right.equals(x)) {
            this.min = x;
        }
        
        y.left = y;
        y.right = y;
        y.parent = x;
        
        if(x.child == null) {
            x.child = y;
        }
        y.right = x.getChild();
        y.left = x.child.getLeft();
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

    public void print() {
        print(min);
        System.out.println();
    }

    private void print(FibonacciHeapNode c) {
        System.out.print("(");
        if (c == null) {
            System.out.print(")");
            return;
        } else {
            FibonacciHeapNode temp = c;
            do {
                System.out.print(temp.key);
                FibonacciHeapNode k = temp.child;
                print(k);
                System.out.print("->");
                temp = temp.right;
            } while (temp != c);
            System.out.print(")");
        }
    }
}
