package datastructures;

import org.jetbrains.annotations.NotNull;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    protected T _value;
    protected Node<T> _next;
    protected Node<T> _prev;

    public Node(T value, Node<T> next, Node<T> prev)
    {
        _value = value;
        _next = next;
        _prev = prev;
    }

    public T getValue(){
        return _value;
    }

    public void setValue(T value){
        _value = value;
    }

    public Node<T> getNext(){
        return _next;
    }

    public void setNext(Node<T> value){
        _next = value;
    }

    public Node<T> getPrev(){
        return _prev;
    }

    public void setPrev(Node<T> value){
        _prev = value;
    }

    @Override
    public int compareTo(@NotNull Node<T> other) {
        return _value.compareTo(other.getValue());
    }

    @Override
    public boolean equals(@NotNull Object other) {
        Node<T> node = (Node<T>)other;
        return _value.equals(node.getValue());
    }
}
