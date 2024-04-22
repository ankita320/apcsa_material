public class MyHeap{
    private int[] heap;
    private int size;
    private int maxsize;
    private boolean isMaxHeap;

    public MyHeap(int numElements, boolean isMax) {
         maxsize = numElements;
         size = 0;
         heap = new int[maxsize];
         isMaxHeap = isMax;
      }

    private int parent(int pos) {
        // RETURN POSTION PARENT
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        // RETURN POSITION LEFTCHILD
        return pos * 2 + 1;
    }
    
    private int rightChild(int pos) {
        // RETURN POSITION RIGHTCHILD
        return pos * 2 + 2;
    }
    
    private void swap(int idx1, int idx2) {
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }
    

    private void downHeapify(int pos) {
        if (isMaxHeap == true) {
        while (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
            if (heap[pos] < heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                pos = leftChild(pos);
            }
            else if (heap[pos] < heap[leftChild(pos)]) {
                swap(pos, leftChild(pos));
                pos = rightChild(pos);
            }

        }
    }
        else {
            while (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                if (heap[pos] > heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    pos = leftChild(pos);
                }
                else if (heap[pos] > heap[leftChild(pos)]) {
                    swap(pos, leftChild(pos));
                    pos = rightChild(pos);
                }
    
            }

        }
}
    
    private void heapifyUp(int pos) {
        if (isMaxHeap) {
            while (heap[pos] > heap[parent(pos)]) {
                swap(pos, parent(pos));
                pos = parent(pos);
            }
        }
        else {
            while (heap[pos] < heap[parent(pos)]) {
                swap(pos, parent(pos));
                pos = parent(pos);
            }
        }
    }

    public void insert(int element) {
        size++;
        heap[size - 1] = element;
        heapifyUp(element);
            // YOUR CODE HERE
    }

    public void print() {
        String n = "";
        n+="[";
        for (int i = 0; i < heap.length-1;i++) {
            n+=heap[i];
            n+=", ";
        }
        n+=heap[size-1];
        n+="]";
        System.out.print(n);

    }

    public int deleteRoot() {
        int root = heap[0];
        swap(0, size-1);
        size--;
        heap[size-1] = 0;
        downHeapify(heap[root]);
        return root;
    }


    public int heapSort() {
        if (heap[pos] < heap[rightChild(pos)]) {
            swap(pos, leftChild(pos));
            pos = leftChild(pos);
        }
        downHeapify();
       // YOUR CODE HERE
        return 0;
    }

}
