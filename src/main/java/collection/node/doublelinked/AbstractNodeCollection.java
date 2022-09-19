package collection.node.doublelinked;

import collection.MyCollection;

public abstract class AbstractNodeCollection<T> implements MyCollection<T> {

    protected DoubleLinkedNode<T> first;
    protected DoubleLinkedNode<T> last;
    protected int size = 0;


    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public T remove(int index) {
        DoubleLinkedNode<T> nodeToRemove = getNodeByIndex(index);

        DoubleLinkedNode<T> next = nodeToRemove.getNext();
        DoubleLinkedNode<T> prev = nodeToRemove.getPrev();

        if (prev == null) {
            first = next;
        } else {
            prev.setNext(next);
        }

        if (next == null) {
            last = prev;
        } else {
            next.setPrev(prev);
        }

        size--;
        return nodeToRemove.getValue();
    }

    @Override
    public boolean add(T value) {
        DoubleLinkedNode<T> l = last;
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(l, value, null);
        last = newNode;

        if (l == null)
            first = newNode;
        else
            l.setNext(newNode);
        size++;
        return true;
    }


    protected DoubleLinkedNode<T> getNodeByIndex(int index){
        DoubleLinkedNode<T> iterate = first;

        for(int i = 1; i <= index; i++){
            iterate = iterate.getNext();

            if(iterate == null){
                throw new IndexOutOfBoundsException();
            }
        }
        return iterate;
    }
}
