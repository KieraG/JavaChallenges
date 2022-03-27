package com.company.DataStructureImplementations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;


public class Deque<ObjectType> {
    private Vector<ObjectType> internalVector = new Vector<>();


    public void AddToFront(ObjectType object) {
        internalVector.AddToFront(object);
    }

    public void AddToBack(ObjectType object) {
        internalVector.AddToBack(object);
    }

    public ObjectType PeekFront() {
        return internalVector.GetObject(0);
    }

    public ObjectType PeekBack() {
        return internalVector.GetObject(internalVector.Length() - 1);
    }

    public ObjectType PopFront() {
        var object = PeekFront();
        internalVector.RemoveObjectAtIndex(0);
        return object;
    }

    public ObjectType PopBack() {
        var object = PeekBack();
        internalVector.RemoveObjectAtIndex(internalVector.Length() - 1);
        return object;
    }

    public int Length()
    {
        return internalVector.Length();
    }

    @Test
    void TestAddToFront() {
        var testDeque = new Deque<Integer>();
        testDeque.AddToFront(3);
        testDeque.AddToFront(4);
        assumeTrue(testDeque.PeekFront() == 4);
        assumeTrue(testDeque.Length() == 2);
    }

    @Test
    void TestAddToBack() {
        var testDeque = new Deque<Integer>();
        testDeque.AddToBack(3);
        testDeque.AddToBack(4);
        assumeTrue(testDeque.PeekBack() == 4);
        assumeTrue(testDeque.Length() == 2);
    }

    @Test
    void TestPopFront() {
        var testDeque = new Deque<Integer>();
        testDeque.AddToFront(3);
        testDeque.AddToFront(4);
        assumeTrue(testDeque.PopFront() == 4);
        assumeTrue(testDeque.PeekFront() == 3);
        assumeTrue(testDeque.Length() == 1);

    }

    @Test
    void TestPopBack() {
        var testDeque = new Deque<Integer>();
        testDeque.AddToBack(3);
        testDeque.AddToBack(4);
        assumeTrue(testDeque.PopBack() == 4);
        assumeTrue(testDeque.PeekBack() == 3);
        assumeTrue(testDeque.Length() == 1);
    }
}
