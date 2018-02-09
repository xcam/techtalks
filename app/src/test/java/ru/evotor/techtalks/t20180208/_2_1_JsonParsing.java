package ru.evotor.techtalks.t20180208;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _2_1_JsonParsing {

    public <T> List<T> getListFromString(String values) {
        List<T> list = new ArrayList<>();
        for (String part : values.split(",")) {
            if (part.startsWith("\"")) {
                list.add((T) part.substring(1, part.length() - 1));
            } else {
                list.add((T) Integer.valueOf(part));
            }
        }

        return list;
    }

    @Test
    public void testGenerics() {
        List<String> list = getListFromString("\"test\",\"test2\"");
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("test", list.get(0));
        Assert.assertEquals("test2", list.get(1));
    }

    @Test
    public void testGenerics2() {
        List<String> list = getListFromString("1,2");
        Assert.assertEquals(2, list.size());
        System.out.println("" + (Object) list.get(0));
        System.out.println(list.get(0));
    }
}
