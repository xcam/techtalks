package ru.evotor.techtalks.t20180208;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _1_1_SimpleGenericTest {

    @Test
    public void testSimpleGenerics() {
        List<String> list = new ArrayList<>();
        list.add("test");
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void testGenericsAddWrongType1() {
        List<String> list = new ArrayList<>();
        list.add((String) new Object()); // строка изменилась
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void testGenericsAddWrongType2() {
        List<String> list = new ArrayList<>();
        List nonGenericList = list; // новая строка
        nonGenericList.add("test"); // строка изменилась
        nonGenericList.add(2034); // строка изменилась
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("test", list.get(0));
        Assert.assertEquals(2034, list.get(1));
    }

}
