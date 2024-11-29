package util;

/**
 * File name: LinearNode.java
 * Author: [Cathal Fahy]
 * Description of class: Represents a node in a linked list.
 */
public class LinearNode<T> {
    private T element;
    private LinearNode<T> next;

    // Constructor with element
    public LinearNode(T element) {
        this.element = element;
        this.next = null;
    }

    // Accessors and Mutators
    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public LinearNode<T> getNext() {
        return next;
    }

    public void setNext(LinearNode<T> next) {
        this.next = next;
    }
}
