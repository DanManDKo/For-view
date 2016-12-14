package com.company.mylist.list;

import java.util.Collection;

/**
 * Created by DanMan on 13.12.2016.
 */
public interface MyCollection<E> {
    int size();


    void addFirst(E e);

    void addLast(E e);

    boolean isEmpty();

    void removeFirst();

    void removeLast();

    boolean contains(E e);


    Object[] toArray();

    void add(E e);

    boolean remove(E e);


    void clear();




}
