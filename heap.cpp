#include <iostream>
using namespace std;

// fixUp - adjust when priority of an element increases
// fixDown - adjust when priority of an element decreases

// push (PQ) - adjust with fixUp
// pop (PQ) - adjust with fixDown
// top (PQ) - return reference to highest priority element

// heapify - build heap
// heapSort - sort after heapify()

// why is bottom top search with fixDown() faster than top bottom search with fixUp()

class Heap {
    vector<int> heap;
    int heapSize;
    void fixUp(int k) {
        while(k > 0 && heap[(k-1)/2] < heap[k]) {
            swap(heap[k], heap[(k-1)/2]);
            k = (k-1)/2;
        }
    }
    void fixDown(int k) {
        while(k <= (heapSize/2)-1) {
            int j = 2*k + 1; // left child
            if(j < heapSize - 1 && heap[j+1] > heap[j]) { // right child exists and is greater than left child
                ++j;
            }
            // now, j is index of max child
            if(heap[k] >= heap[j]) { break; } // element is greater than both children, heap is restored
            // if not
            swap(heap[k], heap[j]);
            k = j; // make sure k tracks the element after swap
        }
    }
public:
    Heap(vector<int> &heap_in, int size) : heap(heap_in), heapSize(size) {}

    void push(int item) {
        heap[heapSize++] = item;
        fixUp(heapSize - 1);
    }
    void pop() {
        heap[0] = heap[heapSize - 1];
        heapSize--;
        fixDown(0);
    }
    int &top() {
        return heap[0];
    }

    void heapify() { // makes non-heap data into a heap, bottom up fixDown()
        for(int i = (heapSize/2)-1; i >= 0; --i) {
            fixDown(i);
        }
    }

    void heapSort() { // undo the sort with heapify()
        heapify();
        int full_size = heapSize;

        for(int i = 0; i < full_size - 1; ++i) {
            swap(heap[0], heap[heapSize - 1]);
            heapSize--;
            fixDown(0);
        }

        heapSize = full_size;
    }

    void printHeap() {
        for(int i = 0; i < heapSize; ++i) {
            cout << heap[i] << " ";
        }
    }
};


int main() {
    vector<int> heapVec = {81, 18, 14, 9, 7, 1, 5, 2, 4};
    Heap h(heapVec, heapVec.size());
    h.push(100);

    vector<int> notHeap = {0, 3, 14, 9, 7, 1, 5, 2, 4, 6};
    Heap nH(notHeap, notHeap.size());
    nH.heapify();
    for(int i = 0; i < notHeap.size(); ++i) {
        cout << nH.top() << " ";
        nH.pop();
    }
    cout << endl; // now it is a heap

    vector<int> to_sort = {0, 3, 14, 9, 7, 1, 5, 2, 4, 6};
    Heap heap_sort(to_sort, to_sort.size());
    heap_sort.heapSort();
    heap_sort.printHeap(); // now it is sorted
    
}