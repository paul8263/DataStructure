package com.paultech;

public interface MyList<E> {

    void add(E e);

    E get(int index);

    int size();

    void clear();

    E remove(int index);
}
