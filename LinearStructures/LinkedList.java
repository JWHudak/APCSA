package LinearStructures;

import java.lang.Iterable;
import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
    private int size = 0;
    
    private Node<E> head, tail;

    public LinkedList() {}

    public LinkedList(E[] objects) {
        for(int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    public void add(E e) {
        add(size, e);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    @SuppressWarnings("unchecked")
    public int indexOf(E e) {
        if(size == 0) {
            return -1;
        }
        int index = 0;
        Node<E> current = head;
        do {
            if(current.element == e) {
                return index;
            }
            current = current.next;
            index++;
        } while(current != null);

        return -1;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if(tail == null) {
            tail = head;
        }
    }

    @SuppressWarnings("unchecked")
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if(tail == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    @SuppressWarnings("unchecked")
    public void add(int index, E e) {
        if(index == 0) {
            addFirst(e);
        }
        else if(index >= size) {
            addLast(e);
        }
        else {
            Node<E> current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E getFirst() {
        if(size == 0) {
            return null;
        }
        return head.element;
    }

    public E getLast() {
        if(size == 0) {
            return null;
        }
        return tail.element;
    }

    @SuppressWarnings("unchecked")
    public E removeFirst() {
        if(size == 0) {
            return null;
        }
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if(head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    @SuppressWarnings("unchecked")
    public E removeLast() {
        if(size == 0) {
            return null;
        }
        else if(size == 1) {
            Node<E> temp = head;
            clear();
            return temp.element;
        }
        else {
            Node<E> current = head;

            for(int i = 0; i < size - 2; i++) {
                current = current.next;
            }

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);
        if(index == 0) {
            Node<E> temp = head;
            removeFirst();
            return temp.element;
        }
        else if(index >= size) {
            Node<E> temp = tail;
            removeLast();
            return temp.element;
        }
        else {
            Node<E> current = head;
            for(int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = (current.next).next;
            size--;
            return temp.element;
        }
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        Node<E> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public void clear() {
        size = 0;
        head = tail = null;
    }

    @SuppressWarnings("unchecked")
    public int lastIndexOf(E e) {
        if(tail.element == e) {
            return size - 1;
        }
        Node<E> current = head;
        int latest = -1;
        for(int i = 0; i < size; i++) {
            if(current.element == e) {
                latest = i;
            }
            current = current.next;
        }
        return latest;
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E e) {
        checkIndex(index);
        Node<E> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = e; 
        return current.element; 
    }

    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        Node<E> current = head;
        if(size == 0) {
            return "[]";
        }
        String t = "[" + current.element;
        for(int i = 0; i < size - 1; i++) {
            current = current.next;
            t += ", " + current.element;
        }
        t += "]";
        return t;
    }

    private static class Node<E> {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        Node<E> current = head;
        int index = 0;
        
        public boolean hasNext() {
            return (index < size);
        }

        @SuppressWarnings("unchecked")
        public E next() {
            E value = current.element;
            current = current.next;
            index++;
            return value;
        }

        public void remove() {
            LinkedList.this.remove(index);
        }
    }
}
