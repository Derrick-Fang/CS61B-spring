package deque;

public class ArrayDeque<T>{
    private int size;
    private int head;
    private int tail;
    private T[] array;

    ArrayDeque(){
        this.array = (T[]) new Object[100];
        this.size = 0;
    }

    private void resize(){

    }
    public void addFirst(T item){

    }
    public void addLast(T item){

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
            else System.out.println(array[i] + " ");
        }
    }
    public T removeFirst(){
        if (size == 0) return null;
        size--;
        return array[]
    }
    public T removeLast(){
        if (size == 0) return null;
        return array[--size];
    }
    public T get(int index){
        if (size == 0) return null;
        return array[index];
    }

}
