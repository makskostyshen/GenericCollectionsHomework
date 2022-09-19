package collection;

import collection.MyCollection;

public interface MyList<T> extends MyCollection<T> {
    T get(int index);
}
