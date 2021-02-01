package ChapterStacksAndQueue;

import java.util.LinkedList;
//We are creating a Wrapper class so that we can track the Animals Order
//We can do the similar thing with linked List. But it can get messy and complex
abstract class Animal{
    private int order;
    String name;
    public Animal(String n){
        name = n;
    }
    public String displayAnimal(){
        return name;
    }
    public void setOrder(int ord){
        order = ord;
    }
    public int getOrder(){
        return order;
    }

    public boolean isOlderThan(Animal animal){
        return order < animal.getOrder();
    }
}

class Dog extends Animal{
    public Dog(String n){
        super(n);
    }
}

class Cat extends Animal{
    public Cat(String n){
        super(n);
    }
}

public class AnimalShelter {

    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    int order = 0;

    public static void main(String[] args) {

        AnimalShelter queue = new AnimalShelter();
        queue.enqueue(new Dog("dog1"));
        queue.enqueue(new Cat("cat1"));
        queue.enqueue(new Cat("cat2"));
        queue.enqueue(new Dog("dog2"));
        queue.enqueue(new Cat("cat2"));
        queue.enqueue(new Dog("dog3"));

        // Should print 'cat1' as it was the first cat entered in Shelter.
        System.out.println(queue.dequeueCat().displayAnimal());

        // Should print dog1 as it was the first animal entered in Shelter.
        System.out.println(queue.dequeueAny().displayAnimal());

        // Should print cat1 as it is the only cat in the Shelter.
        System.out.println(queue.dequeueDog().displayAnimal());
    }

    public void enqueue(Animal val){
        val.setOrder(order);
        order++;

        if(val instanceof Dog){
            dogs.addLast((Dog)val);
        }else if(val instanceof Cat){
            cats.addLast((Cat) val);
        }
    }

    public Animal dequeueAny(){
        if(dogs.size() == 0 && cats.size() == 0){
            return null;
        }else if(dogs.size() == 0){
            return dequeueCat();
        }else if(cats.size() == 0){
            return dequeueDog();
        }else{
            Dog dog = dogs.peek();
            Cat cat = cats.peek();
            if(dog.isOlderThan(cat)){
                return dequeueDog();
            }else{
                return dequeueCat();
            }
        }
    }

    private Animal dequeueDog() {
        return dogs.poll();
    }

    private Animal dequeueCat() {
        return cats.poll();
    }

}
