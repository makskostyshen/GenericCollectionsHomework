package collection.node.doublelinked;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DoubleLinkedNode<T> {

    private DoubleLinkedNode<T> prev;
    private T value;
    private DoubleLinkedNode<T> next;

}
