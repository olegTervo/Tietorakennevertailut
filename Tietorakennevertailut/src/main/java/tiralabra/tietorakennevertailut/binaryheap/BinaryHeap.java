package tiralabra.tietorakennevertailut.binaryheap;

public class BinaryHeap {
    public int[] heap;
    public int length;
    public int size;
    
    public boolean isMinHeap;
    
    public BinaryHeap(int length, boolean minHeap) {
        this.heap = new int[length];
        this.length = length;
        this.size = 0;
        this.isMinHeap = minHeap;
    }
    
    public void Swap(int i, int j) {
        int temp = this.heap[j];
        this.heap[j] = this.heap[i];
        this.heap[i] = temp;
    }
    
    public int Parent(int key) {
        return (key - 1) / 2;
    }
    
    public int Left(int key) {
        return 2 * key + 1;
    }
    
    public int Right(int key) {
        return 2 * key + 2;
    }
    
    public void Insert(int key) {
        if(this.size == this.length) {
            return;
        }
        
        int i = this.size;
        this.heap[i] = key;
        this.size++;
        
        if(this.isMinHeap) {
            while(i != 0 && heap[i] < heap[Parent(i)]) { 
                Swap(i, Parent(i));
                i = Parent(i);
            }
        } else {
            while(i != 0 && heap[i] > heap[Parent(i)]) {
                Swap(i, Parent(i));
                i = Parent(i);
            }
        }
    }
    
    public int GetRoot() {
        return this.heap[0];
    }
    
    public int PopRoot() {
        if(this.size <= 0) {
            return this.isMinHeap ? 
                    Integer.MAX_VALUE : 
                    Integer.MIN_VALUE;
        }
        
        if(this.size == 1) {
            this.size = 0;
            return this.heap[0];
        }
        
        int root = this.heap[0];
        
        this.heap[0] = this.heap[size - 1];
        this.size--;
        
        if(this.isMinHeap) {
            FixMinHeapConflicts(0);
        } else {
            FixMaxHeapConflicts(0);
        }
        
        return root;
    }
    
    private void FixMinHeapConflicts(int start) {
        int left = Left(start);
        int right = Right(start);
        int smallest = start;
        
        if(left < this.size && this.heap[left] < this.heap[smallest]) {
            smallest = left;
        }
        if(right < this.size && this.heap[right] < this.heap[smallest]) {
            smallest = right;
        }
        
        if(smallest != start) {
            Swap(start, smallest);
            FixMinHeapConflicts(smallest);
        }
        
    }
    
    private void FixMaxHeapConflicts(int start) {
        int left = Left(start);
        int right = Right(start);
        int biggest = start;
        
        if(left < this.size && this.heap[left] > this.heap[biggest]) {
            biggest = left;
        }
        if(right < this.size && this.heap[right] > this.heap[biggest]) {
            biggest = right;
        }
        
        if(biggest != start) {
            Swap(start, biggest);
            FixMaxHeapConflicts(biggest);
        }
    }
    
    public void print() {
        System.out.print("[" + this.heap[0]);
        for(int i = 1; i < this.length; i++) {
            System.out.print(", " + this.heap[i]);
        }
        System.out.println("]");
    }
}
