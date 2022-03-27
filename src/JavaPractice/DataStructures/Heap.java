package JavaPractice.DataStructures;

public class Heap<ObjectType> {
    private boolean isMinHeap = false;

    public boolean IsMinHeap() {
        return isMinHeap;
    }

    Heap(boolean minHeap) {
        isMinHeap = minHeap;
    }

    private int GetParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int GetLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int GetRightChildIndex(int index) {
        return (index * 2) + 2;
    }

}
