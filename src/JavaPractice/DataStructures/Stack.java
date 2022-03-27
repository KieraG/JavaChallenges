package JavaPractice.DataStructures;

public class Stack<ObjectType> {
    private Deque<ObjectType> internalDeque = new Deque<>();

    public void AddToStack(ObjectType object) {
        internalDeque.AddToFront(object);
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
}