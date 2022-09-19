package main;

import collection.MyArrayList;
import collection.MyList;
import collection.node.doublelinked.MyLinkedList;
import collection.node.doublelinked.MyQueue;
import collection.node.singlelinked.MyStack;
import map.MyHashMap;



public class Main {
    public static void main(String[] args) {

        //array list
        MyArrayList<String> myArrayList = new MyArrayList<>();

        //linked list
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        //queue
        MyQueue<Double> myQueue = new MyQueue<>();

        //stack
        MyStack<Character> myStack = new MyStack<>();

        //hashmap
        MyHashMap<String, Integer> myHashMap = new MyHashMap();

    }

    private static <T> void printCollection(MyList<T> collection){
        for(int i = 0; i < collection.size(); i++){
            System.out.println(collection.get(i));
        }
    }
}
