package datastructures;

public class ListNode<T extends Comparable<T>> extends Node<T> {

    protected ListNode<T> _next;
    protected ListNode<T> _prev;

    public ListNode(T value, ListNode<T> next, ListNode<T> prev)
    {
        super(value);
        setNext(_next);
        setPrev(_prev);
    }

    public ListNode<T> getNext(){
        return _next;
    }

    public void setNext(ListNode<T> value){
        _next = value;
    }

    public ListNode<T> getPrev(){
        return _prev;
    }

    public void setPrev(ListNode<T> value){
        _prev = value;
    }
}
