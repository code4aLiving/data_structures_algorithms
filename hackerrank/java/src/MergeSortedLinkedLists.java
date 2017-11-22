import datastructures.ListNode;
import datastructures.MyLinkedList;
import datastructures.Node;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortedLinkedLists{

    public static void main(String[] args) {
        Integer[] arr1 = {1,3,5,7,9};
        Integer[] arr2 = {0,2,4,6,8};

        MyLinkedList<Integer> l1 = new MyLinkedList(Arrays.asList(arr1));
        MyLinkedList<Integer> l2 = new MyLinkedList(Arrays.asList(arr2));

        MyLinkedList<Integer> merged = mergeSortedLinkedLists(l1,l2);
        for (Integer val : merged){
            System.out.println(val);
        }

        for (Integer val : merged){
            System.out.println(val);
        }

    }

    public static MyLinkedList<Integer> mergeSortedLinkedLists(MyLinkedList<Integer> list1, MyLinkedList<Integer> list2){
        ListNode<Integer> node1 = list1.getNil().getNext();
        ListNode<Integer> node2 = list2.getNil().getNext();

        MyLinkedList<Integer> res = new MyLinkedList();

        while(node1.get_value() != null || node2.get_value() != null) {
            Integer v1 = node1.get_value();
            Integer v2 = node2.get_value();
            if (v1 == null || (v2 != null && v2 < v1)) {
                res.addLast(v2);
                node2 = node2.getNext();
                continue;
            }
            res.addLast(v1);
            node1 = node1.getNext();
        }

        return res;
    }
}
