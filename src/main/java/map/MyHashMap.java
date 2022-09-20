package map;

import static java.util.Objects.hash;

public class MyHashMap<K, V> {

    private static final double LOAD_FACTOR = 0.75;
    private static final int INITIAL_BUCKETS_NUMBER = 16;

    private int threshold;
    private int currentBucketsNumber;

    private Object[] buckets;
    private int size;


    public MyHashMap(){
        clear();
    }


    public V put(K key, V value){
        if(size >= threshold){
            rearrange();
        }

        int index = hash(key) % (currentBucketsNumber - 1);
        MapNode<K, V> curr = getNode(index);
        MapNode<K, V> prev = null;

        while(true){
            if (curr == null){
                createNewNode(key, value, prev, index);
                return null;
            }
            else if (key.equals(curr.getKey())){
                return changeNodeValue(value, curr);
            }
            prev = curr;
            curr = curr.getNext();
        }
    }


    private V changeNodeValue(V value, MapNode<K,V> curr) {
        MapNode<K, V> changing = curr;

        V oldValue = changing.getValue();
        changing.setValue(value);

        return oldValue;
    }


    private void createNewNode(K key, V value, MapNode<K,V> prev, int index) {
        MapNode<K, V> newNode = new MapNode<>(key, value, null);
        if(prev == null){
            buckets[index] = newNode;
        }
        else{
            prev.setNext(newNode);
        }
        size++;
    }


    public V get(K key){
        int index = getBucketsIndex(key);
        MapNode<K, V> iterate  = getNode(index);

        while(true){
            if(iterate == null){
                return null;
            }
            if(iterate.getKey().equals(key)){
                break;
            }
            iterate = iterate.getNext();
        }
        return iterate.getValue();
    }


    public V remove(K key){
        int index = getBucketsIndex(key);

        MapNode<K, V> curr = getNode(index);
        MapNode<K, V> prev = null;

        while(true){
            if(curr == null){
                return null;
            }
            if(curr.getKey().equals(key)){
                return removeExistingNode(prev, curr, index);
            }
            prev = curr;
            curr = curr.getNext();
        }
    }


    private V removeExistingNode(MapNode<K, V> prev, MapNode<K, V> curr, int index){

        MapNode<K, V> next = curr.getNext();
        V oldValue = curr.getValue();

        if(prev == null){
            buckets[index] = next;
        }
        else{
            prev.setNext(next);
        }
        size--;
        return oldValue;
    }



    public void clear(){
        buckets = new Object[INITIAL_BUCKETS_NUMBER];
        currentBucketsNumber = INITIAL_BUCKETS_NUMBER;
        threshold = calculateThreshold();
        size = 0;
    }

    public int size(){
        return size;
    }




    private void rearrange() {
        currentBucketsNumber = calculateNewBucketsNumber();
        threshold = calculateThreshold();

        Object[] oldBuckets = buckets;
        buckets = new Object[currentBucketsNumber];

        for(int i = 0; i < oldBuckets.length; i++){
            MapNode<K, V> node = getNode(i);
            while(node != null){
                put(node.getKey(), node.getValue());
                node = node.getNext();
            }
        }
    }


    private int calculateThreshold(){
        return (int) Math.round(currentBucketsNumber * LOAD_FACTOR);
    }

    private int getBucketsIndex(K key){
        return hash(key) % (currentBucketsNumber - 1);
    }

    private MapNode<K, V> getNode(int index){
        return (MapNode<K, V>) buckets[index];
    }

    private int calculateNewBucketsNumber(){
        return currentBucketsNumber * 2;
    }
}
