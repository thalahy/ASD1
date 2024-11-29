package util;

/**
 * File name: LinkedListADT.java
 * Author: [Cathal Fahy]
 * Description of class: Interface for LinkedList operations.
 */
public interface LinkedListADT<T> {
    // Adds an element to the list (typically at the end)
    void add(T element);

    // Adds an element at a specified position in the list
    void add(T element, int position);

    // Deletes the specified element from the list
    void delete(T element);

    // Returns the first element in the list
    T getFirst();

    // Returns the last element in the list
    T getLast();

    // Returns the next element after the current element in the list
    T getNext(T currentElement);

    // Returns true if the list is empty, false otherwise
    boolean isEmpty();

    // Checks if the list contains a specified element
    boolean contains(T element);

    // Displays all elements in the list
    void displayAll();

    // Returns the size of the list
    int size();
}
