package com.holmeslei.kotlindemo

import android.app.Activity
import android.os.Bundle
import android.util.Log

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        defineValue()
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

        Log.e("defineValue", "求和:" + sum(a, b))
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
        print(a + b)
    }

    //简写
    fun printsSum1(a: Int, b: Int) = print(a + b)

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
}
