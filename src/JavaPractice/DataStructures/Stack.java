package JavaPractice.DataStructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class Stack<ObjectType> {
    private Deque<ObjectType> internalDeque = new Deque<>();

    public void AddToStack(ObjectType object) {
        internalDeque.AddToBack(object);
    }

    public ObjectType Peek() {
        return internalDeque.PeekBack();
    }

    public ObjectType Pop() {
        return internalDeque.PeekFront();
    }

    public int Length() {
        return internalDeque.Length();
    }
}