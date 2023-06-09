package deque;

public class ArrayDeque<T> implements Deque<T>{
    private int size;
    private int front;
    private int rear;
    private T[] array;

    ArrayDeque(){
        // default size -- 100
        this.array = (T[]) new Object[100];
        this.size = 0;
        front = 0;
        rear = -1;
    }

//    ArrayDeque(int capacity){
//        this.array = (T[]) new Object[capacity];
//        this.size = 0;
//        front = 0;
//        rear = -1;
//    }

    private T[] resize(){
        T[] newArray = (T[]) new Object[2*array.length];
        if (front < rear){
            System.arraycopy(array, front , newArray, 0, size);
        }else{
            // two cases
            // case 1: front < rear (no circular loop)
            // case 2: rear < front (circular loop)
            // we need to break the array into two parts(front -- end/0 -- front)
            System.arraycopy(array, front, newArray, 0, array.length - front);
            System.arraycopy(array, 0, newArray, array.length - front, rear + 1 );
        }

        array = newArray;
        front = 0;
        rear = size - 1;
        return array;
    }

    public void addFirst(T item){
        if (array.length  == size){
            array = resize();
        }
        front = (front-1+array.length)%array.length;
        array[front] = item;
        // special case front == rear == array.length - 1
        if (size == 0) rear = front;
        size ++;
    }

    public void addLast(T item){
        if (array.length  == size){
            array = resize();
            array[size] = item;
        }
        // circular loop
        rear = (rear+1)%array.length;
        array[rear] = item;
        size ++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i =0;i<size;i++){
            if (i == size - 1) System.out.println(array[i]);
            else System.out.print(array[i] + " ");
        }
    }

    public T removeFirst(){
        if (size == 0) return null;
        T item = array[front];
        front = (front + 1) % array.length;
        size--;
        return item;
    }

    public T removeLast(){
        if (size == 0) return null;
        T item = array[rear];
        // special case: addfirst and removelast
        if (front == rear && front == array.length-1){
            rear = -1;
        }else {
            rear = (rear - 1 + array.length) % array.length;
        }
        size--;
        return item;
    }

    public T get(int index){
        if (size == 0) return null;
        return array[index];
    }
}
