package collection.node.doublelinked;

public class MyQueue<T> extends AbstractNodeCollection<T> {

    public MyQueue(){
        size = 0;
    }

    public T peek(){
        return first.getValue();
    }

    public T poll(){
        return remove(0);
    }
}
