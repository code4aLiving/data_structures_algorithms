package datastructures;

import org.jetbrains.annotations.NotNull;

public abstract class Node<T extends Comparable<T>> implements Comparable<Node<T>>
{
    protected T _value;
    public Node(T value){
        set_value(value);
    }

    public void set_value(T value){
        _value = value;
    }

    public T get_value(){
        return _value;
    }

    @Override
    public boolean equals(@NotNull Object other){
        Node<T> node = (Node<T>)other;
        return _value.equals(node.get_value());
    }

    @Override
    public int hashCode(){
        return _value.hashCode();
    }

    @Override
    public int compareTo(@NotNull Node<T> other) {
        return _value.compareTo(other.get_value());
    }
}
