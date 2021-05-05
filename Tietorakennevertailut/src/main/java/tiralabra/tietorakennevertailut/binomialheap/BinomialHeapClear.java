/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.tietorakennevertailut.binomialheap;

/**
 *
 * @author oleg
 */
public class BinomialHeapClear {
    
    public BinomialHeapNode head;

    public BinomialHeapClear() {
    }
    
    public BinomialHeapClear(int size, BinomialHeapNode head) {
        this.head = head;
    }
    
    public void add(int key) {
        BinomialHeapNode newNode = new BinomialHeapNode(key);
        addTree(newNode);
    }
    
    private void addTree(BinomialHeapNode n1) {
        if(this.head == null) {
            this.head = n1;
            return;
        }
        BinomialHeapClear temp = new BinomialHeapClear();
        temp.insertTreeToTheEnd(n1);
        this.head = merge(this, temp).head;
        fixConflicts();
    }
    
    private void insertTreeToTheEnd(BinomialHeapNode n1) {
        BinomialHeapNode last = this.head;
        
        if(last == null) {
            this.head = new BinomialHeapNode(n1);
            return;
        }
        
        while(last.sibling != null) {
            last = last.sibling;
        }
        
        last.sibling = new BinomialHeapNode(n1);
    }
    
    public static BinomialHeapClear merge(BinomialHeapClear h1, BinomialHeapClear h2) {
        BinomialHeapNode n1 = h1.head;
        BinomialHeapNode n2 = h2.head;
        
        BinomialHeapClear ret = new BinomialHeapClear();
        
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
        
        return ret;
    }

    private void fixConflicts() {
        
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
                    if(previous.key != current.key){
                        removeTree(current);
                    } else {
                        removeTree(previous.child);
                    }
                    current = current.sibling;
                    if(next != null) {
                        next = next.sibling;
                    }
                }
            }
        }
    }
    
    public static BinomialHeapNode merge(BinomialHeapNode n1, BinomialHeapNode n2) {
        if(n1.key > n2.key) {
            // Black magic...
            n1 = swap(n2, n2 = n1);
        }
        
        n2 = BinomialHeapNode.copy(n2);
        n2.parent = n1;
        n2.sibling = n1.child;
        n1.child = n2;
        n1.degree++;
        
        return n1;
    }
    
    private void removeTree(BinomialHeapNode n1) {
        BinomialHeapNode last = this.head;
        
        if(last.key == n1.key) {
            this.head = this.head.sibling;
            return;
        }
        
        while(last != null && last.sibling != null) {
            if(last.sibling.key == n1.key) {
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
        BinomialHeapNode min = this.head;
        BinomialHeapNode current = null;
        if(min != null) {
            current = this.head.sibling;
        }

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
        if(min.key == 11) printHeap();
        BinomialHeapNode next = this.head;
        BinomialHeapClear newHeap = new BinomialHeapClear();
        
        while(next != null) {
            if(next.key != min.key) {
                newHeap.insertTreeToTheEnd(next);
                next = next.sibling;
            } else {
                newHeap = newHeap.head != null ? 
                        BinomialHeapClear.merge(newHeap, removeRoot(next)) : 
                        removeRoot(next);
                newHeap.printHeap();
                this.head = null;
                this.head = newHeap.getHead();
                break;
            }
        }
        return min;
    }
    
    private BinomialHeapClear removeRoot(BinomialHeapNode root) {
        BinomialHeapClear heap = new BinomialHeapClear();
        BinomialHeapNode temp = root.child;
        
        if(temp == null) {
            heap.head = root.sibling;
            return heap;
        }
        
        if(temp.sibling == null) {
            temp.sibling = root.sibling;
        }
        
        while(temp != null) {
            BinomialHeapNode last = BinomialHeapNode.copy(temp);
            temp = temp.sibling;
            last.sibling = null;
            heap.insertTreeToTheEnd(last);
        }
        
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
    
    protected BinomialHeapNode getHead() {
        return this.head;
    }
}
