package Lesson_4.Homework;

import Lesson_4.lesson.deque.Deque;

public class DequeList<E> implements Deque<E> {

    protected int size;
    protected Node<E> first;
    protected Node<E> last;

    @Override
    public boolean insertLeft(E value) {
        Node<E> newNode = new Node<>(value, first, null);
        if (!isEmpty()) {
            first.prev = newNode;
        }
        first = newNode;

        size++;
        if (size == 1) {
            last = first;
        }

        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isEmpty()) {
            return insertLeft(value);
        }

        Node<E> newNode = new Node<>(value, null, last);
        last.next = newNode;
        last = newNode;
        size++;

        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;

        if ( first != null) {
            first.prev = null;
        }

        removedNode.next = null;
        size--;

        if (isEmpty()) {
            last = null;
        }

        return removedNode.item;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = last;
        last = removedNode.prev;

        if ( last != null) {
            last.next = null;
        }

        removedNode.prev = null;

        size--;
        if (isEmpty()) {
            first = null;
        }

        return removedNode.item;
    }

    @Override
    public boolean insert(E value) {
        insertLeft(value);
        return true;
    }

    public boolean insert(E value, int position) {
        if (position > size) {
            return false;
        }

        if (isEmpty() || position == 1) {
            return insertLeft(value);
        }

        if (position == size) {
            return insertRight(value);
        }

        Node<E> current = find(position);
        Node<E> currentPrev = current.prev;
        Node<E> newNode = new Node<>(value, current, currentPrev);

        current.prev = newNode;
        currentPrev.next = newNode;

        size++;

        return true;

    }

    @Override
    public E remove() {
        return removeLeft();
    }

    public E remove (int position) {
        if (position > size) {
            return null;
        }

        if (position == 1) {
            return remove();
        }

        if (position == size) {
            return removeRight();
        }

        size--;
        Node<E> current = find(position);

        if (isEmpty()) {
            first = null;
            last = null;
            return current.item;
        }

        Node<E> currentPrev = current.prev != null ? current.prev : null;
        Node<E> currentNext = current.next != null ? current.next : null;

        if (currentPrev != null) {
            currentPrev.next = currentNext;
        }

        if (currentNext != null) {
            currentNext.prev = currentPrev;
        }

        return current.item;
    }

    @Override
    public E peekFront() {
        return first.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;

        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    public Node<E> find (int position) {

        Node<E> current = first;
        int i = 1;

        while (i < size) {
            if (i == position) {
                return current;
            }
            current = current.next;
            i++;
        }

        return null;
    }

    class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
