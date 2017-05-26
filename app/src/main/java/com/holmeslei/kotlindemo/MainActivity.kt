package com.holmeslei.kotlindemo

import android.app.Activity
import android.os.Bundle
import android.util.Log

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //常量变量定义
        defineValue()
        printsSum(1, 2)
        Log.e("test_kotlin", "42和5大的数是：" + maxOf(42, 5))

        //null检查
        printProduct("4", "5")
        printProduct("3", "b")
        printProduct("a", "2")

        //value检查，类型自动转换
        Log.e("test_kotlin", "值检查:" + getStringLength("xulei"))

        //for while循环
        useCircleFor()
        useCircleWhile()

        //when表达式
        whenExpress(1)
        whenExpress("hello")
        whenExpress(518L)
        whenExpress(10086)
        whenExpress("xulei")
        whenExpress1(0)
        whenExpress1(-1)
        whenExpress1(1)
        whenExpress1(2)
        whenExpress1(3)
        whenExpress1(6)
        whenExpress1(10)

        //range表达式
        rangeExpress()

        //集合
        useCollection()
    }

    /**
     * 定义常量变量
     */
    fun defineValue() {
        //数值类型：Double Float Long Int Short Byte

        //定义常量
        val a: Int = 1
        val b = 1 //推导出Int型
        val c: Int
        c = 1 //必须声明完之后赋值

        //数值常量可添加下划线分割
        val oneMillion = 1_000_000
        val idCard = 18860_1994_0318_4459

        //常量数组
        val arrs = Array(3) { Array(2) { IntArray(1) } } //java: int[][][] arrs = new int[3][2][1];

        //定义变量
        var x = 5
        x += 1
        var name: String? = "xulei" //变量名后加"?"代表为可空变量
        name = null //只有可空变量才可赋值为null
    }

    /**
     * 两Int类型参数，Int类型返回值
     */
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    //简写:函数体只有一个表达式，自推导型返回值
    fun sum1(a: Int, b: Int) = a + b

    /**
     * 无返回值Unit,可省略
     */
    fun printsSum(a: Int, b: Int): Unit {
        Log.e("test_kotlin", "求和:" + sum(a, b))
    }

    //简写
    fun printsSum1(a: Int, b: Int) = Log.e("test_kotlin", "求和:" + sum(a, b))

    /**
     * 比较，返回大值
     */
    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    //简写
    fun maxOf1(a: Int, b: Int) = if (a > b) a else b

    //返回可空值
    fun parseInt(str: String): Int? {
        return str.toIntOrNull()
    }

    /**
     * Kotlin对可空值必须进行判断
     */
    fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        // 直接使用 x*y 会报错因为它们中有可能会有空值
        if (x != null && y != null) {
            // x 和 y 将会在空值检测后自动转换为非空值
            Log.e("test_kotlin", "可空值判断:" + x * y)
        } else {
            Log.e("test_kotlin", "可空值判断: $arg1 or $arg2 is not a number")
        }
    }

    /**
     * is 值检查并自动转换
     * 相当于Java的 Instance of
     */
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // obj将会在这个if中自动转换为String类型
            return obj.length
        }
        return null
    }

    /**
     * for循环
     */
    fun useCircleFor() {
        val items = listOf("monkey", "dog", "cat")
        for (item in items) {
            Log.e("test_kotlin", "for循环:" + item)
        }
//        for (index in items.indices) {
//            Log.e("test_kotlin", "循环:" + items[index])
//        } 
    }

    /**
     * while循环
     */
    fun useCircleWhile() {
        val items = listOf("monkey", "dog", "cat")
        var index = 0
        while (index < items.size) {
            Log.e("test_kotlin", "while循环:" + items[index])
            index++
        }
    }

    /**
     * when表达式
     * 替换Java的Switch
     */
    fun whenExpress(obj: Any): String =
            when (obj) {
                1 -> "when表达式:one"
                "hello" -> "when表达式:is hello"
                is Long -> "when表达式:is Long"
                !is String -> "when表达式:is String"
                if (obj is Int) 5 else -6 -> "when表达式:is Int"
                else -> "when表达式:UnKnown"
            }

    fun whenExpress1(x: Int) {
        when (x) {
            2 -> println("等于2")
        //数值表达式
            if (x > 0) 1 else -1 -> Log.e("test_kotlin", "when表达式1:大于0并等于1，或小于0并等于-1")
        //Boolean类型表达式
            in 1..5 -> Log.e("test_kotlin", "when表达式1:范围匹配1-5")
            !in 6..9 -> Log.e("test_kotlin", "when表达式1:不是6-9")
            is Int -> Log.e("test_kotlin", "when表达式1:类型判断")
            else -> Log.e("test_kotlin", "when表达式1:else")
        }
        // 代替if...else if
        when {
            x > 6 && x <= 10 -> Log.e("test_kotlin", "when表达式1:大于6小于等于10")
            x < 6 -> Log.e("test_kotlin", "when表达式代替if:小于6")
            else -> Log.e("test_kotlin", "when表达式代替if:小于6")
        }
    }

    /**
     * range表达式
     */
    fun rangeExpress() {
        //检查数值是否在某个范围内
        val x = 12
        val y = 9
        if (x in 1..y + 2) {
            Log.e("test_kotlin", "range在范围内:" + x + "在范围1-" + (y + 2) + "内")
        } else {
            Log.e("test_kotlin", "range在范围内:" + x + "不在范围1-" + (y + 2) + "内")
        }

        //检查数值是否在范围外
        val list = listOf("a", "b", "c")
        if (-2 !in 0..list.lastIndex) {
            Log.e("test_kotlin", "range在范围外:-2在范围0-" + list.lastIndex + "外")
        } else {
            Log.e("test_kotlin", "range在范围外:-2不在范围0-" + list.lastIndex + "外")
        }
        if (list.size !in list.indices) {//list.indices:0..2
            Log.e("test_kotlin", "range在范围外:" + list.size + "在范围" + list.indices + "外")
        }

        //在范围内迭代
        for (x in 1..5) {
            Log.e("test_kotlin", "range在范围内迭代:" + x)
        }

        //步进
        for (x in 1..10 step 2) {
            Log.e("test_kotlin", "range步进up:" + x)
        }
        for (x in 9 downTo 0 step 3) {
            Log.e("test_kotlin", "range步进down:" + x)
        }
    }

    /**
     * 集合
     */
    fun useCollection() {
        //集合遍历
        val animals = listOf("dog", "cat", "monkey")
        for (item in animals) {
            Log.e("test_kotlin", "集合:" + item)
        }
        //检测包含对象
        val fruits = setOf("apple", "banana", "grape")
        when {
            "orange" in fruits -> Log.e("test_kotlin", "集合检测包含对象:有orange")
            "apple" in fruits -> Log.e("test_kotlin", "集合检测包含对象:有apple")
        }
        //使用lambda表达式过滤和映射集合：
        val tools = listOf("Wrench", "Wire", "Flashlight", "Interphone")
        tools.filter { it.startsWith("W") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { Log.e("test_kotlin", "集合Lambda表达式过滤" + it) }
    }
}
