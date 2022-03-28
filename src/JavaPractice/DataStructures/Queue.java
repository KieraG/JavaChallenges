package JavaPractice.DataStructures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Queue<ObjectType> {
    private Deque<ObjectType> internalDeque = new Deque<>();

    public void AddToQueue(ObjectType object) {
        internalDeque.AddToBack(object);
    }

    public ObjectType Peek() {
        return internalDeque.PeekFront();
    }

    public ObjectType Pop() {
        return internalDeque.PopFront();
    }

    public int Length() {
        return internalDeque.Length();
    }


    @Test
    void TestAddingToQueue()
    {
        var testQueue = new Queue<Integer>();
        testQueue.AddToQueue(5);
        testQueue.AddToQueue(5);
        testQueue.AddToQueue(5);
        testQueue.AddToQueue(5);

        assertEquals(testQueue.Length(), 4);
    }

    @Test
    void TestPeekingFromQueue()
    {
        var testQueue = new Queue<Integer>();
        testQueue.AddToQueue(1);
        testQueue.AddToQueue(2);
        testQueue.AddToQueue(3);
        testQueue.AddToQueue(4);

        assertEquals(testQueue.Length(), 4);
        assertEquals(testQueue.Peek(), 1);
        assertEquals(testQueue.Length(), 4);
    }

    @Test
    void TestPoppingFromQueue()
    {
        var testQueue = new Queue<Integer>();
        testQueue.AddToQueue(1);
        testQueue.AddToQueue(2);
        testQueue.AddToQueue(3);
        testQueue.AddToQueue(4);

        assertEquals(testQueue.Length(), 4);
        assertEquals(testQueue.Pop(), 1);
        assertEquals(testQueue.Length(), 3);
        assertEquals(testQueue.Peek(), 2);
    }

    @Test
    void TestPoppingFromQueueMoreThanAvailable()
    {
        var testQueue = new Queue<Integer>();
        testQueue.AddToQueue(1);
        testQueue.AddToQueue(2);
        testQueue.AddToQueue(3);
        testQueue.AddToQueue(4);

        assertEquals(testQueue.Length(), 4);
        assertEquals(testQueue.Pop(), 1);
        assertEquals(testQueue.Pop(), 2);
        assertEquals(testQueue.Pop(), 3);
        assertEquals(testQueue.Pop(), 4);
        assertEquals(testQueue.Length(), 0);
        assertEquals(testQueue.Pop(), null);
        assertEquals(testQueue.Length(), 0);
    }
}
