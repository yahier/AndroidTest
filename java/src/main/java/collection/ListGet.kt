package collection

import java.util.*
import java.util.function.Consumer

class ListGet {
    var a = intArrayOf(2, 4, 56, 7, 8, 9, 4)
    var list: MutableList<Int> = ArrayList()
    fun put() {
        for (i in a.indices) {
            list.add(a[i])
        }
        list.add(0, 234)
    }

    fun get() {
        for (i in list.indices) {
            println(list[i])
        }
    }

    fun t() {
        val list: MutableList<Int> = ArrayList()
        list.add(2)
        list.add(5)
        list.remove(4)

        //list.remove(1);
        println("size:" + list.size)
        for (i in list.indices) {
            println(i.toString() + ":" + list[i])
        }
    }

    fun testAddAll() {
        val data: MutableList<String> = ArrayList()
        for (i in 1..5) {
            data.add(i.toString())
        }
        data.addAll(newData)
        println(data.size)

        //以下方式的数据不能执行addAll方法
        //String[] strs = {"1", "2", "3", "4", "5"};
        //List<String> data2 = Arrays.asList(strs);
    }

    val newData: List<String>
        get() {
            val data: MutableList<String> = ArrayList()
            for (i in 6..10) {
                data.add(i.toString())
            }
            return data
        }

    fun testFilerSameData() {
        var list: MutableList<Key> = ArrayList()
        list.add(Key("1", "1"))
        list.add(Key("2", "2"))
        val list2: MutableList<Key> = ArrayList()
        list2.add(Key("1", "1"))

//        list2.forEach { newTemp ->
//             list.filter {
//                println(it.hashCode().toString() + ":" + newTemp.hashCode())
//                it.hashCode() == newTemp.hashCode()
//            }
//        }
        list.addAll(list2)

        val list3 = list.distinctBy {
            it.hashCode()
        }


        list.forEach(Consumer { item: Key -> println(item.params1) })
        println("___________")
        list3.forEach(Consumer { item: Key -> println(item.params1) })
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lg = ListGet()
            lg.list.add(1,0)
            //lg.put();
            //lg.get();
            //lg.t();
            //lg.testAddAll();
            lg.testFilerSameData()
        }
    }
}