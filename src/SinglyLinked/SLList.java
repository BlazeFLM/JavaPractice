package SinglyLinked;

public class SLList<T>{

    private int size;
    private Node sentinel;

    public SLList(){
        sentinel = new Node(null, null);
        this.size = 0;
    }
    public SLList(T first) {
        this.sentinel = new Node(null, null);
        sentinel.next = new Node(first, null);
        this.size = 1;
    }


    /**
     * Adds i to front of this list.
     */
    public void addFirst(T i) {
        sentinel.next = new Node(i, sentinel.next);
        this.size++;
    }

    /** Adds x to the end of this list. */
    public void addLast(T x){
        Node cur = sentinel;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = new Node(x, null);
        this.size++;

    }

    private Node getNode(Node node, int i) {
        if(node == null){
            return null;
        }
        if (i == 0) {
            return node;
        }
        return getNode(node.next, i - 1);
    }
    /**
     * Returns the node at index i in this list
     */
    public Node getNode(int i) {
        return getNode(sentinel.next, i);
    }


    private T get(Node node, int i) {
        if (i == 0) {
            return node.item;
        }
        return get(node.next, i - 1);
    }
    /**
     * Returns the integer at the index in this list
     */

    public T get(int index) {
        return get(sentinel.next, index);
    }

    /** Returns number of items in the list. */
    public int size(){
        return this.size;
    }




    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
