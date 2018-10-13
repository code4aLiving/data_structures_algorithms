package datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {

    protected BinaryTreeNode<T> _root;

    public BinaryTree(){
        _root = new BinaryTreeNode(null);
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return _root._left == null;
    }

    public boolean contains(T o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public boolean removeAll(T o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public void clear() {
        _root.set_left(null);
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
