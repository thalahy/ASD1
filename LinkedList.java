package util;
/**
 * File name: LinkedList.java
 * Author: [Cathal Fahy]
 * Description of class: 
 * The class includes methods for adding, removing, accessing, and displaying elements, 
 * as well as checking for containment and list size.
 */
public class LinkedList<T> implements LinkedListADT<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    // Add a new element to the end of the list
    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode; // When the list is empty, both head and tail point to the new node
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++; // Increment size
    }

    // Add an element at a specific position
    public void add(T data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        if (position == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            if (head.next == null) {
                tail = head; // If adding at position 0 makes it the only element
            }
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(data);
            newNode.next = current.next;
            current.next = newNode;
            if (newNode.next == null) {
                tail = newNode; // If newNode is the last element, update tail
            }
        }
        size++; // Increment size
    }

    // Delete a specific element
    public void delete(T data) {
        if (head == null) return;

        // If the data is at the head
        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) {
                tail = null; // If the list becomes empty, update tail to null
            }
            size--; // Decrement size
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                if (current.next == tail) {
                    tail = current; // If we're deleting the tail, update tail
                }
                current.next = current.next.next;
                size--; // Decrement size
                return;
            }
            current = current.next;
        }
    }

    // Get the first element in the list
    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    // Get the last element in the list
    public T getLast() {
        if (tail == null) {
            return null;
        }
        return tail.data; // O(1) retrieval due to maintaining a tail reference
    }

    // Get the next element after the current one
    public T getNext(T currentElement) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(currentElement)) {
                return (current.next != null) ? current.next.data : null;
            }
            current = current.next;
        }
        return null;
    }

    // Get the element at the specified index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Check if the list contains an element
    public boolean contains(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Display all elements in the list
    public void displayAll() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Return the size of the list
    public int size() {
        return size;
    }
}
