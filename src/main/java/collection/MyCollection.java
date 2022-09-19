package collection;

public interface MyCollection<T> {
    void clear();
    int size();
    T remove(int index);
    boolean add(T value);
}
