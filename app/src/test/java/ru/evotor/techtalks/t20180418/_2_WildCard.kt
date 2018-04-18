package ru.evotor.techtalks.t20180418

import org.junit.Test

class _2_WildCard {
    @Test
    fun test() {
        val animals = ArrayList<Animal>()
        animals.add(Dog())
        animals.add(Cat())

        println(animals.size)
    }

    @Test
    fun testUnknown() {
        val dogs = ArrayList<Dog>()
        dogs.add(Dog())

        val animals: List<Animal> = dogs //out
        //animals.add(Dog());

        println(dogs.size)
    }

    @Test
    fun testICan() {
        val dogs = ArrayList<Dog>()
        dogs.add(Dog())

        val animals: List<Animal> = dogs
        (dogs as ArrayList<Dog>).add(Dog())

        println(dogs.size)
    }

    @Test
    fun testReverse() {
        val animals = ArrayList<Animal>()
        animals.add(Dog())

        val dogs: ArrayList<in Dog> = animals
        dogs.add(Dog())

        println(dogs.size)
        println(animals.size)
    }
}
