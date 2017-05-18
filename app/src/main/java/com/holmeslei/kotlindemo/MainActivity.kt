package com.holmeslei.kotlindemo

import android.app.Activity
import android.os.Bundle
import android.util.Log

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        defineValue()
        printsSum(1, 2)
        Log.e("test_kotlin", "42和5大的数是：" + maxOf(42, 5))

        printProduct("4", "5")
        printProduct("3", "b")
        printProduct("a", "2")

        Log.e("test_kotlin", "值检查:" + getStringLength("xulei"))
    }

    /**
     * 定义常量变量
     */
    fun defineValue() {
        //常量
        val a: Int = 1
        val b = 1 //推导出Int型
        val c: Int
        c = 1

        //变量
        var x = 5
        x += 1

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
            Log.e("test_kotlin", "printProduct:" + x * y)
        } else {
            Log.e("test_kotlin", "printProduct: $arg1 or $arg2 is not a number")
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
    
}
