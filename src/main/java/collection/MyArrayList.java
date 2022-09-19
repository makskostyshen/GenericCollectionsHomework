package collection;

import java.util.Arrays;


public class MyArrayList<T> implements MyList<T> {

    private int size;
    private T[] elementData;
    private static final int CAPACITY_TO_ADD = 10;


    public MyArrayList(){
        size = 0;
        elementData = (T[]) new Object[CAPACITY_TO_ADD];
    }


    @Override
    public boolean add(T value) {
        if(elementData.length == size){
            grow();
        }
        elementData[size] = value;
        size++;
        return true;
    }

    private void grow() {
        elementData = Arrays.copyOf(elementData, size + CAPACITY_TO_ADD);
    }


    @Override
    public T remove(int index) {
        checkIndex(index);
        T removed = elementData[index];

        if ((size-1) != index)
            System.arraycopy(elementData, index + 1, elementData, index, size - 1 - index);
        size--;
        elementData[size] = null;

        return removed;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void clear() {
        size = 0;
        elementData = (T[]) new Object[CAPACITY_TO_ADD];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return elementData[index];
    }
}
