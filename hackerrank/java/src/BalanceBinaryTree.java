import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BalanceBinaryTree {

   /**
    * Create a numeric binary tree structure/classes that have left and right
    * children and an integer numeric value. Write a function 'isBalanced' for
    * a node that returns true if the sum of all the children on the left is equal
    * to the sum of all the children on the right.
    *
    * Part 1 - setUp and isBalanced
    * Part 2 - Implement allBalancedNodes. It will return a list of all the balanced children.
    */
    public static void main(String[] args){
        BinaryTreeNode l1 = new BinaryTreeNode(1);
        BinaryTreeNode l2 = new BinaryTreeNode(1);
        BinaryTreeNode r1 = new BinaryTreeNode(3, l1, l2);
        System.out.println(r1.isBalanced());
        System.out.printf("%d %d %d\n", r1.sum(),r1._left.sum(), r1._right.sum());

        BinaryTreeNode n3 = new BinaryTreeNode(5, l1, l2);
        BinaryTreeNode n4 = new BinaryTreeNode(3);
        BinaryTreeNode r2 = new BinaryTreeNode(1, n3, n4);
        System.out.println(r2.isBalanced());
        System.out.printf("%d %d %d\n", r2.sum(),r2._left.sum(), r2._right.sum());



    }

    static class BinaryTreeNode{
        BinaryTreeNode _left, _right;
        int _value;
        boolean _hasCalculatedSum = false;
        int _sum;

        public BinaryTreeNode(int value){
            _value = value;
        }

        public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right){
            this(value);
            _left = left;
            _right = right;
        }

        public boolean isBalanced(){
            if(isLeaf())
                return true;
            if (_left == null || _right == null)
                return false;
            return _left.sum() == _right.sum();
        }

        public boolean isLeaf(){
            return _left == null && _right == null;
        }

        public int sum(){
            if (_hasCalculatedSum)
                return _sum;

            _sum = 0;
            if (_left != null)
                _sum += _left.sum();
            if (_right != null)
                _sum += _right.sum();
            _sum += _value;
            _hasCalculatedSum = true;
            return _sum;
        }

        public List<BinaryTreeNode> getAllBalanced(){
            List<BinaryTreeNode> res = new ArrayList();
            if (isLeaf()) {
                res.add(this);
                return res;
            }

            if (_left != null)
                res.addAll(_left.getAllBalanced());
            if (_right != null)
                res.addAll(_right.getAllBalanced());
            if (isBalanced())
                res.add(this);
            return res;
        }

        public Iterator<BinaryTreeNode> preOrder(){
            /**
             * Return then visit the children
             * Use a stack
             */
            throw new RuntimeException();
        }

        public Iterator<BinaryTreeNode> postOrder(){
            /**
             * Visit the children first then return
             * Use a stack
             */
            throw new RuntimeException();
        }

        public Iterator<BinaryTreeNode> inOrder(){
            /**
             * Visit the left, return, then visit right
             * Use a stack
             */
            throw new RuntimeException();
        }

        public Iterator<BinaryTreeNode> byLevels(){
            /**
             * A BFS
             * Use a queue
             */
            throw new RuntimeException();
        }
    }
}
