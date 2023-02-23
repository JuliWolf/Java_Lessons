package Lesson_4.lesson;

public interface TwoSideLinkedList<E>  extends LinkedList<E> {

    void insertLast(E value);

    E getLast();
}
