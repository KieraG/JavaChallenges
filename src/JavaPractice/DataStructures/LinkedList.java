package JavaPractice.DataStructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class LinkedList<ObjectType> {

    private class LinkedListNode<ObjectType> {
        public ObjectType value = null;
        public LinkedListNode<ObjectType> previousNode = null;
        public LinkedListNode<ObjectType> nextNode = null;
    }

    public LinkedListNode<ObjectType> firstNode = null;
    public LinkedListNode<ObjectType> lastNode = null;

    public LinkedListNode<ObjectType> AddNodeToBack(ObjectType object) {
        LinkedListNode<ObjectType> newNode = new LinkedListNode<>();
        newNode.value = object;
        if (firstNode == null) {
            firstNode = newNode;
        } else {
            newNode.previousNode = lastNode;
            lastNode.nextNode = newNode;
        }
        lastNode = newNode;
        return newNode;
    }

    public LinkedListNode<ObjectType> AddNodeToFront(ObjectType object) {
        LinkedListNode<ObjectType> newNode = new LinkedListNode<>();
        newNode.value = object;
        if (firstNode != null) {
            newNode.nextNode = firstNode;
            firstNode.previousNode = newNode;
        } else {
            lastNode = newNode;
        }
        firstNode = newNode;
        return newNode;
    }

    public int GetNumberOfElements() {
        int totalElements = 0;
        var currentNode = firstNode;
        while (currentNode != null) {
            totalElements++;
            currentNode = currentNode.nextNode;
        }
        return totalElements;
    }


    @Test
    void TestLinkedListAddToEmpty() {
        LinkedList<Integer> testLinkedList = new LinkedList<>();

        testLinkedList.AddNodeToFront(3);
        assumeTrue(testLinkedList.firstNode.value == 3);

    }

    @Test
    void TestLinkedListAddMultiple() {
        LinkedList<Integer> testLinkedList = new LinkedList<>();

        testLinkedList.AddNodeToFront(3);
        testLinkedList.AddNodeToFront(4);
        testLinkedList.AddNodeToBack(5);
        assumeTrue(testLinkedList.firstNode.value == 4);
        assumeTrue(testLinkedList.firstNode.nextNode.value == 3);
        assumeTrue(testLinkedList.firstNode.nextNode.nextNode.value == 5);

    }
}



