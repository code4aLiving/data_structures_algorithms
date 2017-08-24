public class MatrixToLinkedList {

    /**
     * Taken from career cup https://www.careercup.com/question?id=5699709669736448
     * Given a matrix.
     * Convert it into a linked list matrix such that each node is connected to its next right and down node.
     */
    public static void main(String[] args){

    }

    public static LinkedList matrixToLinkedList(int [][] matrix){
        int columns = matrix[0].length;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != columns)
                return null;
        }
        ListNode [][] nodes = new ListNode[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                nodes[row][col] = new ListNode(matrix[row][col]);
                if (col > 0)
                    nodes[row][col-1].setNext(nodes[row][col]);
                if (row > 0)
                    nodes[row-1][col].setDown(nodes[row][col]);
            }
        }

        LinkedList res = new LinkedList(nodes[0][0]);
        return res;
    }

    static class ListNode{
        private int _value;
        private ListNode _next;
        private ListNode _down;

        public ListNode(int value){
            _value = value;
        }

        public ListNode getNext(){
            return _next;
        }

        public void setNext(ListNode node){
            _next = node;
        }

        public ListNode getDown(){
            return _down;
        }

        public void setDown(ListNode value){
            _down = value;
        }

        public int getValue(){
            return _value;
        }

        public void setValue(int value){
            _value = value;
        }
    }

    static class LinkedList{
        private ListNode _nil = new ListNode(0);
        public LinkedList(){ }
        public LinkedList(ListNode head){
            _nil.setNext(head);
        }

        public ListNode getHead(){
            return _nil.getNext();
        }
    }

}
