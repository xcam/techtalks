package ru.evotor.techtalks.t20180208

import org.junit.Assert
import org.junit.Test
import java.util.*

class _1_2_SimpleGenericTestK {

    @Test
    fun testSimpleGenerics() {
        val list = ArrayList<String>()
        list.add("test")
        Assert.assertEquals(1, list.size.toLong())
    }

    @Test
    fun testGenericsAddWrongType1() {
        val list = ArrayList<String>()
        list.add(Any() as String) // строка изменилась
        Assert.assertEquals(1, list.size.toLong())
    }

    @Test
    fun testGenericsAddWrongType2() {
        val list = ArrayList<String>()
        //val listWithoutGeneric: MutableList = list
        //listWithoutGeneric.add(2034) // строка изменилась
        Assert.assertEquals(1, list.size.toLong())
        Assert.assertEquals(2034, list[0])
    }
}
