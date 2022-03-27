package com.company.DataStructureImplementations;

public class Queue<ObjectType> {
    private Deque<ObjectType> internalDeque = new Deque<>();

    public void AddToQueue(ObjectType object) {
        internalDeque.AddToFront(object);
    }

    public ObjectType Peek() {
        return internalDeque.PeekBack();
    }

    public ObjectType Pop() {
        return internalDeque.PopBack();
    }

    public int Length() {
        return internalDeque.Length();
    }
}
