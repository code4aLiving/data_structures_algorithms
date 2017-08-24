package datastructures;

import org.jetbrains.annotations.NotNull;

import java.util.*;


public class MyLinkedList<T extends Comparable<T>> extends AbstractSequentialList<T>
        implements Iterable<T>, Collection<T>, Deque<T>, List<T>, Queue<T> {
    protected ListNode<T> _nil;
    protected int _size;

    public ListNode<T> getNil(){
        return _nil;
    }

    public MyLinkedList(){
        super();
        _nil = new ListNode(null, null, null);
        _nil.setNext(_nil);
        _nil.setPrev(_nil);
    }

    public MyLinkedList(Collection<T> collection){
        this();
        for (T t: collection){
            addLast(t);
        }
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        ListIterator<T> it = new ListIterator<T>() {
            ListNode<T> current = _nil.getNext();
            int index = 0;
            @Override
            public boolean hasNext() {
                return current != _nil;
            }

            @Override
            public T next() {
                T val = current.get_value();
                current = current.getNext();
                index++;
                return val;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public T previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return index+1;
            }

            @Override
            public int previousIndex() {
                return index;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(T t) {

            }

            @Override
            public void add(T t) {

            }
        };
        return it;
    }

    @Override
    public void addFirst(T t) {
        ListNode<T> node = new ListNode(t, _nil.getNext(), _nil);
        _nil.getNext().setPrev(node);
        _nil.setNext(node);
        _size++;
    }

    @Override
    public void addLast(T t) {
        ListNode<T> node = new ListNode(t, _nil, _nil.getPrev());
        _nil.getPrev().setNext(node);
        _nil.setPrev(node);
        _size++;
    }

    @Override
    public boolean offerFirst(T t) {
        return false;
    }

    @Override
    public boolean offerLast(T t) {
        return false;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        if (_nil.getPrev() == _nil)
            throw new EmptyStackException();
        ListNode<T> resNode = _nil.getPrev();
        resNode.getPrev().setNext(resNode.getNext());
        resNode.getNext().setPrev(resNode.getPrev());
        _size--;
        return resNode.get_value();
    }

    @Override
    public T pollFirst() {
        return null;
    }

    @Override
    public T pollLast() {
        return null;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public T peekFirst() {
        return null;
    }

    @Override
    public T peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public void push(T t) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @NotNull
    @Override
    public Iterator<T> descendingIterator() {
        Iterator<T> it = new Iterator<T>() {
            ListNode<T> current = _nil.getNext();
            @Override
            public boolean hasNext() {
                return current != _nil;
            }

            @Override
            public T next() {
                T val = current.get_value();
                current = current.getNext();
                return val;
            }
        };
        return it;
    }
}
