package collection.node.singlelinked;

import collection.MyCollection;

public class MyStack<T> implements MyCollection<T> {

    private int size;
    private SingleLinkedNode<T> bottom;


    public MyStack(){
        size = 0;
    }

    public T push(T value){
        if(bottom == null){
            bottom = new SingleLinkedNode<>(value, null);
        }
        else{
            SingleLinkedNode<T> node = bottom;
            bottom = new SingleLinkedNode<>(value, node);
        }
        size++;
        return value;
    }

    @Override
    public T remove(int index){
        SingleLinkedNode<T> iterate = bottom;
        SingleLinkedNode<T> beforeIterate = null;

        if(index == 0){
            pop();
        }
        for(int i = 1; i <= index; i++){
            beforeIterate = iterate;
            iterate = iterate.getNext();

            if(iterate == null){
                throw new IndexOutOfBoundsException();
            }
        }
        size--;
        beforeIterate.setNext(iterate.getNext());
        return iterate.getValue();
    }

    @Override
    public boolean add(T value) {
        T oldValue = push(value);
        return oldValue == value;
    }

    @Override
    public void clear(){
        bottom = null;
        size = 0;
    }

    @Override
    public int size(){
        return size;
    }


    public T peek(){
        if(bottom == null){
            return null;
        }
        return bottom.getValue();
    }


    public T pop(){
        SingleLinkedNode<T> oldBottom = bottom;
        if(oldBottom == null){
            return null;
        }
        size--;
        bottom = oldBottom.getNext();
        return oldBottom.getValue();
    }
}
