package ru.evotor.techtalks.t20180208;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _3_1_FragmentExample {
    class Fragment {

    }

    class ChildFragment1 extends Fragment {

    }

    class ChildFragment2 extends Fragment {

    }

    public Fragment findFragmentById(int fragment_id) {
        switch (fragment_id) {
            case 1:
                return new ChildFragment1();
            default:
                return new ChildFragment2();
        }
    }

    @Test
    public void test() {
        ChildFragment1 childFragment1 = (ChildFragment1) findFragmentById(2);
    }

    protected <T extends Fragment> T getFragment(int fragment_id) {
        Fragment frag = findFragmentById(fragment_id);
        T target = null;
        try {
            target = (T) frag;
        } catch (ClassCastException e) {
            System.err.println("ALARM!!!");
        }
        return target;
    }

    @Test
    public void test2() {
        ChildFragment1 childFragment1 = getFragment(2);
    }

    @Test
    public void test3() {
        List<ChildFragment1> list = new ArrayList<>();
        list.add(this.<ChildFragment1>getFragment(2));
        System.out.println(ChildFragment1.class.isInstance(list.get(0)));
    }
}
