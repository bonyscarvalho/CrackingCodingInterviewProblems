package Algorithms;

import java.util.HashMap;

public class LRUCache {
    private final int capacity;
    private int size = 0;
    private HashMap<Integer, Node> memory;
    private DoublyLinkedList internalQueue;

    public LRUCache(final int capacity){
        this.capacity = capacity;
        this.memory = new HashMap<>();
        this.size = 0;
        this.internalQueue = new DoublyLinkedList();
    }

    public Integer get(final Integer key){
        Node node = memory.get(key);
        if(node == null){
            return null;
        }
        return memory.get(key).value;
    }

    public void put(final Integer key, final Integer value){
        Node currNode = memory.get(key);

        if(currNode != null){
            currNode.value = value;
            internalQueue.moveNodeToFront(currNode);
        }

        System.out.println("Memory: " + memory);
        // Added Extra COndition so that when similar keys update are there there should be not delete happening
        // We have to check size >= capacity as it will notify us for increase
        if(size >= capacity  && !memory.containsKey(key)){   //&& !memory.containsKey(key) for checking new keys only to perform delete from rear
            Integer rearKey = internalQueue.getRearKey();
            internalQueue.removeNodeFromRear();
            memory.remove(rearKey);
            size--;
            System.out.println("After Delete Memory: " + memory);
        }

        Node node = new Node(key, value);
        internalQueue.addNodeToFront(node);
        memory.put(key, node);
        System.out.println("Memory After PUT: " + memory);
        size++;
        System.out.println("SIZE After PUT: " + size);

    }

    public boolean delete(final Integer key){
        Node node = memory.get(key);

        System.out.println("Deleteing Node: " + node.value);

        if(node == null){
            return false;
        }

        memory.remove(key);
        size--;

        return internalQueue.deleteNode(node);
    }


    private class Node{
        Node prev, next;
        Integer key;
        Integer value;

        public Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    private class DoublyLinkedList{
        Node front, rear;
        public DoublyLinkedList(){
            this.front = null;
            this.rear =  null;
        }

        private void addNodeToFront(final Node node){
            // as front and rear are the same for the start of the node.
            // So we assign the 1st Value as both front and rear. which will move it forward.
            if(rear == null){
                front = rear = node;
                return;
            }
            node.next = front;
            front.prev = node;
            front = node;
        }

        //Used when updating a key which will have to move the curr node to the recently used node(1st one)
        public void moveNodeToFront(final Node node){
            if(front == node){
                return;
            }
            //last node
            if(node == rear){
                rear = rear.prev;
                rear.next = null;
            }else {
                //node's previous will be node's next previous as Node is removed
                //Imagine removing the middle node and assgining the prev and next
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            //Assigning it to the Front of the Node;
            node.prev = null;
            node.next = front;
            front.prev = node;
            front = node;
        }

        //When over capacity you have to remove the node from Rear so that you can add the new Key Value
        public void removeNodeFromRear(){
            if(rear == null)return;     //Empty

            System.out.println("Deleting key: " + rear.key);
            if(front == rear){  //1 Node
                front = rear = null;
            }else {
                rear = rear.prev;
                rear.next = null;
            }
        }

        public boolean deleteNode(Node node){

            if(rear == node){
                rear = rear.prev;
                rear.next = null;
            }else if(front == node){
                front.next.prev = null;
                front = front.next;
            }else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            return true;
        }

        private Integer getRearKey(){
            return rear.key;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 11);
        lruCache.put(2, 12);
        lruCache.put(3, 13);
        lruCache.put(4, 14);

        lruCache.delete(3);
        System.out.println(lruCache.get(3));
        lruCache.put(5, 15);
        lruCache.put(2, 12);
        lruCache.put(6, 16);
        lruCache.put(7, 17);

    }

}

