package collection.node.doublelinked;

import collection.MyList;

public class MyLinkedList<T> extends AbstractNodeCollection<T> implements MyList<T> {


    @Override
    public T get(int index) {
        return getNodeByIndex(index).getValue();
    }
}
