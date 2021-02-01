package ChapterStacksAndQueue;

import java.util.LinkedList;
import java.util.Queue;

class AnimalNode {
    AnimalNode next = null;
    String data;

    public AnimalNode(String d){
        data = d;
    }

    void appendToTail(String d){
        AnimalNode end = new AnimalNode(d);
        AnimalNode n = this;

        while (n.next != null){
            n = n.next;
        }
        n.next = end;
    }
}

public class AnimalShelterLinkedListNode {
    static Queue<String> animals = new LinkedList<>();
    static AnimalNode inputNode1 = new AnimalNode("dog1");

    public static void main(String[] args) {

        inputNode1.appendToTail("cat1");
        inputNode1.appendToTail("dog2");
        inputNode1.appendToTail("cat2");
       // inputNode1.appendToTail("dog3");

//        enqueueAnimal("dog4");
//        enqueueAnimal("dog5");
        enqueueAnimal("cat3");
        enqueueAnimal("cat4");

        String firstAnimal = dequeueAnimal();
        System.out.println("First Animal is "+ firstAnimal);

        String firstDog = dequeuePerference("dog");
        System.out.println("First Dog is "+ firstDog);
        String secondDog = dequeuePerference("dog");
        System.out.println("Second Dog is "+ secondDog);
        String firstCat = dequeuePerference("cat");
        System.out.println("First Cat is "+ firstCat);

    }

    private static void enqueueAnimal(String val) {
        AnimalNode iterator = inputNode1;
        while (iterator.next != null){
            iterator = iterator.next;
        }
        iterator.next = new AnimalNode(val);
    }

    private static String dequeueAnimal() {
        if(inputNode1 == null) return null;
        AnimalNode deque = inputNode1;
        inputNode1 = inputNode1.next;
        deque.next = null;
        return deque.data;
    }

    private static String dequeuePerference(String pet) {
        if(inputNode1 == null) return null;
        AnimalNode result = null;
        AnimalNode curr = inputNode1;
        AnimalNode prev = null;

        if(curr.data.contains(pet)){
            inputNode1 = inputNode1.next;
            return curr.data;
        }

        while(curr != null){
            if(curr.data.contains(pet)){
                result = curr;
                prev.next = curr.next;
                return result.data;
            }else {
                prev = curr;
                curr = curr.next;
            }
        }

        return result == null ? "No "+pet :result.data;
    }

}
