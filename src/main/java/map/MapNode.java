package map;

import collection.node.singlelinked.SingleLinkedNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MapNode<K, V>{

    private K key;
    private V value;
    private MapNode<K, V> next;
}
