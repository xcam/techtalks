package ru.evotor.techtalks.t20180208

import org.junit.Test
import java.util.*

class _3_2_FragmentExampleK {
    internal open inner class Fragment

    internal inner class ChildFragment1 : Fragment()

    internal inner class ChildFragment2 : Fragment()

    private fun findFragmentById(fragment_id: Int): Fragment {
        return when (fragment_id) {
            1 -> ChildFragment1()
            else -> ChildFragment2()
        }
    }

    @Test
    fun test() {
        val childFragment1 = findFragmentById(2) as ChildFragment1
    }

    protected fun <T : Fragment> getFragment(fragment_id: Int): T? {
        val frag = findFragmentById(fragment_id)
        var target: T? = null
        try {
            target = frag as T
        } catch (e: ClassCastException) {
            System.err.println("ALARM!!!")
        }

        return target
    }

    @Test
    fun test2() {
        val childFragment1 = getFragment<ChildFragment1>(2)
    }

    @Test
    fun test3() {
        val list = ArrayList<ChildFragment1>()
        list.add(getFragment(2)!!)
        println(ChildFragment1::class.java.isInstance(list[0]))
    }
}
