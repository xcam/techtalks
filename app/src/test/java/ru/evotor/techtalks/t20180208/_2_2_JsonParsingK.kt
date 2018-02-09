package ru.evotor.techtalks.t20180208

import org.junit.Assert
import org.junit.Test

import java.util.ArrayList

class _2_2_JsonParsingK {

    fun <T> getListFromString(values: String): List<T> {
        val list = ArrayList<T>()
        for (part in values.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            if (part.startsWith("\"")) {
                list.add(part.substring(1, part.length - 1) as T)
            } else {
                list.add(Integer.valueOf(part) as T)
            }
        }

        return list
    }

    @Test
    fun testGenerics() {
        val list = getListFromString<String>("\"test\",\"test2\"")
        Assert.assertEquals(2, list.size.toLong())
        Assert.assertEquals("test", list[0])
        Assert.assertEquals("test2", list[1])
    }

    @Test
    fun testGenerics2() {
        val list = getListFromString<CharArray>("1,2")
        Assert.assertEquals(2, list.size.toLong())
        println("" + list[0] as Any)
        println(list[0])
    }
}
