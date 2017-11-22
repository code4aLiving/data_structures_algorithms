package datastructures;

public class BinaryTreeNode<T extends Comparable<T>> extends Node<T>{

    protected BinaryTreeNode<T> _left, _right;

    public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right){
        super(value);
        _left = left;
        _right = right;
    }

    public BinaryTreeNode(T value){
        this(value, null, null);
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> left){
        this(value, left, null);
    }

    public BinaryTreeNode<T> get_left() {
        return _left;
    }

    public void set_left(BinaryTreeNode<T> node){
        _left = node;
    }

    public BinaryTreeNode<T> get_right() {
        return _right;
    }

    public void set_right(BinaryTreeNode<T> node){
        _right = node;
    }

    public boolean is_leaf(){
        return _left == null && _right == null;
    }

    public int count(){
        if (is_leaf())
            return 1;
        int res = 1;
        if (_left != null)
            res += _left.count();
        if (_right != null)
            res += _right.count();
        return res;
    }
}
