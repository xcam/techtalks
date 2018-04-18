package ru.evotor.techtalks.t20180418;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _1_WildCard {
    @Test
    public void test() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());

        System.out.println(animals.size());
    }

    @Test
    public void testUnknown() {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());

        List<? extends Animal> animals = dogs;
        //animals.add(new Dog());

        System.out.println(animals.size());
    }

    @Test
    public void testICan() {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());

        List<? extends Animal> animals = dogs;
        ((List<Dog>) animals).add(new Dog());

        System.out.println(animals.size());
    }

    @Test
    public void testReverse() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog());

        List<? super Dog> dogs = animals;
        dogs.add(new Dog());

        System.out.println(animals.size());
        System.out.println(dogs.size());
    }
}
