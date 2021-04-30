package tiralabra.tietorakennevertailut.binomialheap;

public class BinomialHeap {

    public BinomialHeapNode head;

    public BinomialHeap() {
    }
    
    public BinomialHeap(int size, BinomialHeapNode head) {
        this.head = head;
    }

    public void add(int key) {
        System.out.println("---NEW ITERATION: add " + key);
        BinomialHeapNode newNode = new BinomialHeapNode(key);
        addTree(newNode);
    }
    
    private void addTree(BinomialHeapNode n1) {
        if(this.head == null) {
            this.head = n1;
            return;
        }
        BinomialHeap temp = new BinomialHeap();
        temp.insertTreeToTheEnd(n1);
        this.head = merge(this, temp).head;
        fixConflicts();
    }
    
    private void insertTreeToTheEnd(BinomialHeapNode n1) {
        System.out.println("INSERT TREE ITERATION " + n1.key);
        printHeap();
        BinomialHeapNode last = this.head;
        
        if(last == null) {
            this.head = new BinomialHeapNode(n1);
            return;
        }
        
        while(last.sibling != null) {
            System.out.println("INSERT TREE WHILE ITERATION, sibling: " + last.sibling.key);
            last = last.sibling;
        }
        last.sibling = new BinomialHeapNode(n1);
        
        System.out.println("INSERT TREE ITERATION RES: ");
        printHeap();
    }
    
    public static BinomialHeap merge(BinomialHeap h1, BinomialHeap h2) {
        System.out.println("MERGE ITERATION");
        h1.printHeap();
        h2.printHeap();
        BinomialHeapNode n1 = h1.head;
        BinomialHeapNode n2 = h2.head;
        
        BinomialHeap ret = new BinomialHeap();
        
        while(n1 != null && n2 != null) {
            if(n1.degree <= n2.degree) {
                ret.insertTreeToTheEnd(n1);
                n1 = n1.sibling;
            } else {
                ret.insertTreeToTheEnd(n2);
                n2 = n2.sibling;
            }
        }
        while(n1 != null) {
            ret.insertTreeToTheEnd(n1);
            n1 = n1.sibling;
        }
        while(n2 != null) {
            ret.insertTreeToTheEnd(n2);
            n2 = n2.sibling;
        }
        ret.printHeap();
        System.out.println("NEXT ITERATION");
        return ret;
    }

    private void fixConflicts() {
        System.out.println("FIX CONFLICTS ITERATION");
        if(head != null && head.sibling != null) {
            BinomialHeapNode previous = head;
            BinomialHeapNode current = head.sibling;
            BinomialHeapNode next = head.sibling.sibling;
            
            while(previous != null) {
                if(current == null) {
                    previous = current;
                } else if(previous.degree < current.degree) {
                    previous = current;
                    current = next;
                    if(next != null) {
                        next = next.sibling;
                    }
                } else if(next != null && previous.degree == current.degree && previous.degree == next.degree) {
                    previous = current;
                    current = next;
                    next = next.sibling;
                } else if(previous.degree == current.degree) {
                    previous = merge(previous, current);
                    if(previous.key != current.key) removeTree(current);
                    else removeTree(previous.child);
                    current = current.sibling;
                    if(next != null) {
                        next = next.sibling;
                    }
                }
            }
        }
        System.out.println("\nFIX CONFLICTS ITERATION END");
        printHeap();
    }
    
    public static BinomialHeapNode merge(BinomialHeapNode n1, BinomialHeapNode n2) {
        boolean swaped = false;
        if(n1.key > n2.key) {
            swaped = true;
            System.out.println("MERGE TREE ITERATION 1");
            // Black magic...
            n1 = swap(n2, n2 = n1);
        }
        
        printTree(n1);        
        System.out.println(" VS ");
        printTree(n2);
        System.out.println(" ;\n");
        
        n2 = BinomialHeapNode.copy(n2);
        n2.parent = n1;
        n2.sibling = n1.child;
        n1.child = n2;
        n1.degree++;
        
        printTree(n1);
        return n1;
    }
    
    private void removeTree(BinomialHeapNode n1) {
        System.out.println("REMOVE TREE ITERATION " + n1.key);
        printHeap();
        BinomialHeapNode last = this.head;
        
        if(last.key == n1.key) {
            System.out.println("REMOVE TREE ITERATION WHEN REMOVING HEAD");
            this.head = this.head.sibling;
            return;
        }
        printHeap();
        while(last != null && last.sibling != null) {
            System.out.println("REMOVE TREE ITERATION SEARCHING... " + last.key);
            if(last.sibling.key == n1.key) {
                System.out.println("REMOVE TREE ITERATION WHEN FOUND " + last.key);
                last.sibling = last.sibling.sibling;
            }
            last = last.sibling;
        }
        
    }
    
    private static void printTree(BinomialHeapNode node) {
        while(node != null) {
            System.out.print("( ");
            System.out.print(node.key + " ");
            printTree(node.child);
            node = node.sibling;
            System.out.print("T)");
        }
    }
    
    public void printHeap() {
        BinomialHeapNode node = this.head;
        printTree(node);
        System.out.println();
    }
    
    private static BinomialHeapNode swap(BinomialHeapNode n1, BinomialHeapNode n2) {
        return n1;
    }
    
    public BinomialHeapNode getMinumum() {
        printHeap();
        BinomialHeapNode min = this.head;
        BinomialHeapNode current = null;
        if(min != null) current = this.head.sibling;

        while(current != null) {
            if (min.key > current.key) {
                min = current;
            }
            current = current.sibling;
        }
        return min;
    }
    
    public BinomialHeapNode extractMinimumNode() {
        BinomialHeapNode min = getMinumum();
        BinomialHeapNode next = BinomialHeapNode.copy(head);
        BinomialHeap newHeap = new BinomialHeap();
        printTree(min);
        while(next != null) {
            if(next.key != min.key) {
                printTree(next);
                System.out.println();
                newHeap.insertTreeToTheEnd(next);
                next = next.sibling;
            } else {
                System.out.println();
                printTree(next);
                System.out.println();
                this.head = null;
                newHeap = BinomialHeap.merge(newHeap, removeRoot(next));
                this.head = newHeap.head;
                break;
            }
        }
        
        printHeap();
        return min;
    }
    
    private BinomialHeap removeRoot(BinomialHeapNode root) {
        BinomialHeap heap = new BinomialHeap();
        BinomialHeapNode temp = root.child;
        
        if(temp == null) {
            heap.head = root.sibling;
            heap.printHeap();
            return heap;
        }
        
        while(temp != null) {
            BinomialHeapNode last = BinomialHeapNode.copy(temp);
            temp = temp.sibling;
            last.sibling = null;
            heap.insertTreeToTheEnd(last);
        }
        heap.printHeap();
        return heap;
    }

    public BinomialHeapNode changeKey(BinomialHeapNode node, int newKey) {
        if (newKey < node.key) {
            return null;
        }

        BinomialHeapNode current = node;
        while (current.parent != null && newKey > current.parent.key) {
            current.key = current.parent.key;
            current = current.parent;
        }
        current.key = newKey;
        return current;
    }
}
