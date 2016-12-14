package com.company.mylist.list;


/**
 * Created by DanMan on 13.12.2016.
 */
public class List<E> implements MyCollection<E> {
    private Node<E> first;
    private Node<E> last;
    private Node<E> current;
    private int size;
    private final Iterator iterator = new Iterator();

    @Override
    public int size() {
        return size;
    }

    public Iterator getIterator() {
        return iterator;
    }

    @Override
    public void addFirst(E e) {
        Node<E> node = new Node<>(e);
        Node<E> tmp = first;
        first = node;
        node.next = tmp;
        if (size == 0) {
            last = first;
        } else {
            tmp.previous = first;
        }
        size++;
        if (current == null)
            current = first;
    }

    @Override
    public void addLast(E e) {
        Node<E> node = new Node<>(e);
        if (size == 0) {
            first = node;
        } else {
            last.next = node;
            node.previous = last;
        }
        last = node;
        size++;
        if (current == null)
            current = node;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void removeFirst() {
        if (size != 0) {
            first = first.next;
            size--;
            if (size == 0) {
                last = null;
            } else
                first.previous = null;
        }
    }

    @Override
    public void removeLast() {
        if (size != 0) {
            if (size == 1) {
                first = null;
                last = null;
            } else {
                last.previous.next = null;
                last = last.previous;
            }
            size--;
        }
    }

    @Override
    public boolean contains(E e) {
        Node<E> current = first;
        while (current != null) {
            if (current.value.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> node = first; node != null; node = node.next)
            result[i++] = node.value;
        return result;
    }

    @Override
    public void add(E e) {
        addLast(e);
    }

    @Override
    public boolean remove(E e) {
        Node<E> previous = null;
        Node<E> current = first;

        while (current != null) {
            if (current.value.equals(e)) {
                if (previous != null) {
                    previous.next = current.next;
                    if (current.next == null) {
                        last = previous;
                    } else {
                        current.next.previous = previous;
                    }
                    size--;
                } else {
                    removeFirst();
                }
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }


    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public final class Iterator implements SimpleIterable {
        private boolean nextFlag = true;
        private boolean previousFlag = true;

        @Override
        public boolean hasNext() {
            if (size == 0)
                throw new NoSuchElementException("Empty list!");
            if (current != last)
                return true;
            if (nextFlag) {
                nextFlag = false;
                return true;
            }
            return false;
        }

        @Override
        public boolean hasPrevious() {
            if (size == 0)
                throw new NoSuchElementException("Empty list!");
            if (current != first)
                return true;
            if (previousFlag) {
                previousFlag = false;
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            if (size == 0)
                throw new NoSuchElementException("Empty list!");
            E value;
            value = current.value;
            if (current.next != null) {
                current = current.next;
            }
            previousFlag = true;
            return value;
        }

        @Override
        public E back() {
            if (size == 0)
                throw new NoSuchElementException("Empty list!");
            E value;
            value = current.value;
            if (current.previous != null) {
                current = current.previous;
            }
            nextFlag = true;
            return value;
        }
    }


    class Node<E> {
        E value;
        Node<E> next;
        Node<E> previous;

        private Node(E value) {
            this.value = value;
        }
    }


}
