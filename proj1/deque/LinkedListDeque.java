package deque;

public class LinkedListDeque<T> {
    private int size;
    private LinkListNode head;
    private LinkListNode tail;

    LinkedListDeque(){
        this.size = 0;
        this.head = new LinkListNode();
        this.tail = head;

    }

    private class LinkListNode{
        public T val;
        public LinkListNode next;
        public LinkListNode prev;

        LinkListNode(){
        }

        LinkListNode(T val){
            this.val = val;
        }
    }

    public void addFirst(T item){
        LinkListNode newNode = new LinkListNode(item);
        if (head.next == null){
            head.next = newNode;
            newNode.prev = head;
            tail = newNode;
        }else{
            newNode.next = head.next;
            head.next.prev = newNode;
            newNode.prev = head;
            head.next = newNode;
        }
        size ++;
    }

    public void addLast(T item){
        LinkListNode newNode = new LinkListNode(item);
        if (head.next == null) {
            head.next = newNode;
            newNode.prev = head;
            tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size ++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        LinkListNode tempNode = head;
        while(tempNode.next != tail){
            System.out.print(tempNode.next.val + " ");
            tempNode = tempNode.next;
        }
        // deal with thw last one
        System.out.println(tail.val);
    }

    public T removeFirst(){
        if (size <= 0) return null;
        LinkListNode tempNode = head.next;
        if (size == 1) {
            head.next = null;
            tail = head;
        }else {
            head.next.next.prev = head;
            head.next = head.next.next;
        }
        size --;
        return tempNode.val;
    }

    public T removeLast(){
        if (size <= 0) return null;
        LinkListNode tempNode = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return tempNode.val;
    }

    public T get(int index){
        if (index > size || index < 0) return null;

        int j = 0;
        LinkListNode tempNode = head;
        while (j != index){
            j++;
            tempNode = tempNode.next;
        }

        return tempNode.val;
    }
}
