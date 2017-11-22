package datastructures;

import org.jetbrains.annotations.NotNull;
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

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public boolean removeAll(T o) {
        return false;
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }

    public boolean removeAll(@NotNull Collection<?> c) {
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
