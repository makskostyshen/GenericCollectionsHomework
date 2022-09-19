package collection.node.singlelinked;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SingleLinkedNode<T> {

    protected T value;
    protected SingleLinkedNode<T> next;
}
