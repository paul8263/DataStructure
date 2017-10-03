package com.paultech;

public class MyLinkedList<E> implements MyList<E> {

    private Node<E> first;

    private Node<E> last;

    private int size;

    private boolean isIndexValid(int index) {
        return (index > 0 && index < size);
    }

    private Node<E> getFirstNode() {
        return first;
    }

    private Node<E> getLastNode() {
        return last;
    }

    private Node<E> getNodeAtIndex(int index) {
        if (0 == index) return getFirstNode();
        if (size == index - 1) return getLastNode();
        if (!isIndexValid(index)) return null;

        Node<E> node = first.next;
        int i = 1;
        while (i < index) {
            node = node.next;
            i++;
        }
        return node;
    }

    public void add(E e) {
        if (null == first) {
            first = new Node<>();
            first.e = e;
            last = first;
        } else {
            Node<E> node = new Node<>();
            node.e = e;
            last.next = node;
            last = node;
        }
        size++;
    }

    public E get(int index) {
        Node<E> node = getNodeAtIndex(index);
        if (null != node) return node.e;
        return null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (Node<E> node = first; null != node; ) {
            Node<E> next = node.next;
            node.e = null;
            node.next = null;
            node = next;

        }
        size = 0;
    }

    public E remove(int index) {
        E e;
        if (!isIndexValid(index)) return null;
        if (0 == index) {
            e = removeFirstNode();
        } else if (size - 1 == index) {
            e = removeLastNode();
        } else {
            Node<E> before = getNodeAtIndex(index - 1);
            Node<E> node = before.next;
            Node<E> after = node.next;
            e = node.e;
            node.next = null;
            node.e = null;
            before.next = after;
        }

        size--;

        return e;
    }

    private E removeLastNode() {
        if (0 == size) return null;
        if (1 == size) {
            return removeOnlyNode();
        } else {
            Node<E> lastButOne = getNodeAtIndex(size - 2);
            E e = last.e;
            lastButOne.next = null;
            last.e = null;
            last = lastButOne;
            return e;
        }
    }

    private E removeOnlyNode() {
        Node<E> node = first;
        E e = node.e;
        node.e = null;
        node.next = null;
        first = null;
        last = null;
        return e;
    }

    private E removeFirstNode() {
        if (0 == size) return null;
        if (1 == size) {
             return removeOnlyNode();
        } else {
            Node<E> second = first.next;
            E e = first.e;
            first.next = null;
            first.e = null;
            first = second;
            return e;
        }
    }
}
