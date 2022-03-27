package com.company.DataStructureImplementations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Arrays;

public class Vector<ObjectType> {
    private final int initialArraySize = 100;
    private Object[] internalArray;

    // Current number of elements in the vector
    private int currentSize = 0;

    public Vector() {
        internalArray = new Object[initialArraySize];
    }

    public void AddToBack(ObjectType object) {
        InsertObjectAtIndex(currentSize, object);
    }

    public void AddToFront(ObjectType object) {
        InsertObjectAtIndex(0, object);
    }

    public int Length() {
        return currentSize;
    }

    public void InsertObjectAtIndex(int indexToPlaceAt, ObjectType object) {
        if (currentSize == internalArray.length) {
            DoubleCapacity();
        }
        for (int index = currentSize; index > indexToPlaceAt; index--) {
            internalArray[index] = internalArray[index - 1];
        }
        internalArray[indexToPlaceAt] = object;
        currentSize++;
    }

    public void RemoveObjectAtIndex(int indexToRemoveAt) {
        for (int index = indexToRemoveAt; index < currentSize; index++) {
            internalArray[index] = internalArray[index + 1];
        }
        currentSize--;
    }

    public ObjectType GetObject(int index) {
        if (index > currentSize || index < 0) {
            return null;
        }
        return (ObjectType) internalArray[index];
    }

    private void DoubleCapacity() {
        int newSize = internalArray.length * 2;
        internalArray = Arrays.copyOf(internalArray, newSize);
    }

    @Test
    void TestRemovingFromVector() {
        var testVector = new Vector<Integer>();

        testVector.AddToBack(1);
        testVector.AddToBack(2);
        testVector.AddToBack(3);
        testVector.AddToBack(4);

        assumeTrue(testVector.Length() == 4);

        testVector.RemoveObjectAtIndex(2);

        assumeTrue(testVector.GetObject(2) == 4);
        assumeTrue(testVector.Length() == 3);

        assumeTrue(testVector.GetObject(3) == null);


    }

    @Test
    void TestAddingToVector() {
        var testVector = new Vector<Integer>();

        testVector.AddToBack(1);
        testVector.AddToBack(2);

        assumeTrue(testVector.GetObject(0) == 1);
        assumeTrue(testVector.GetObject(1) == 2);
        assumeTrue(testVector.Length() == 2);
    }

    @Test
    void TestInsertingToVector() {
        var testVector = new Vector<Integer>();

        testVector.AddToBack(1);
        testVector.AddToBack(2);

        assumeTrue(testVector.GetObject(0) == 1);

        testVector.InsertObjectAtIndex(0, 43);

        assumeTrue(testVector.GetObject(0) == 43);
        assumeTrue(testVector.GetObject(1) == 1);
        assumeTrue(testVector.GetObject(2) == 2);

        testVector.InsertObjectAtIndex(1, 27);

        assumeTrue(testVector.GetObject(0) == 43);
        assumeTrue(testVector.GetObject(1) == 27);
        assumeTrue(testVector.GetObject(2) == 1);
        assumeTrue(testVector.GetObject(3) == 2);
        assumeTrue(testVector.Length() == 4);
    }

    @Test
    void TestVectorResizing() {
        var testVector = new Vector<Integer>();

        for (int i = 0; i < 200; i++) {
            testVector.AddToBack(i);
        }
        boolean allNumbersCorrect = true;
        for (int i = 0; i < 200; i++) {
            if (testVector.GetObject(i) != i) {
                allNumbersCorrect = false;
            }
        }

        assumeTrue(allNumbersCorrect);
        assumeTrue(testVector.Length() == 200);
    }
}
