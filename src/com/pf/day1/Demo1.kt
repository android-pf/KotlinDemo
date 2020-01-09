package com.pf.day1

fun main(args: Array<String>) {
    //var 变量声明关键字
    var name = "张三"
    var age = 16
    var money: Int//不赋值的时候需要声明类型,否则直接提示错误
    money = 98521
    //val 常量生命关键字
    val max = Byte.MAX_VALUE
    println("================================================")
    println("Hello Koklin")
    println("变量展示,,name = $name,age = $age,money = $money")
    println(",常量展示 max = $max")
    println("Math.abs(2) = ${Math.abs(2)}")
    println("Math.pow(2.0,2.0) = ${Math.pow(2.0, 2.0)}")
    println("函数多参数+带返回值的格式 = ${usePow(2.0, 4.0)}")
    println("函数简化 = ${usePow2(2.0, 6.0)}")
    println(""" 三个双引号使用\n/n<p> """ + " <--  和 --> 普通双引号使用\n/n<p> ")
    var temp = 2
    if (temp % 2 == 0) {
        println("if else 的使用，进入if")
    } else {
        println("if else 的使用，进入else")
    }
    var name2 = "张三"
//    ==等于equals方法
    if (name == name2) {
        println("比较方法的使用1，进入if")
    } else {
        println("比较方法的使用1，进入else")
    }

    ///equals方法的第二个参数表示是否比较大小写
    if (name.equals(name2, false)) {
        println("比较方法的使用2，进入if")
    } else {
        println("比较方法的使用2，进入else")
    }
    ///接收空参数方法的使用
    testNull("111")
    testNull(null)


    println("====================")
    println("when的使用：  ")
    when (name) {
        "张三" -> println("When表达式的使用1，类似switch")
        "李四" -> println("When表达式的使用1,类似switch")
    }
    var temp3 = "王五"
    var result = when (temp3) {
        "张三" -> "返回张三"
        "李四" -> "返回李四"
        "李四", "赵六" -> "返回李四"
        else -> {
            "都不是返回传递过来的值$temp3"
        }
    }
    println("When表达式的使用2, 带返回值的表达式，穿透方式，result =$result")

    var result2 = when {
        money > 9999999 -> "这货是个百万富翁"
        money > 10 -> "这货至少有10块钱"
        temp3.contains("王") -> "这货姓王"
        else -> "进入else"
    }
    println("When表达式的使用3,以表达式(而不只是常量)作为分支条件 ,result2 =$result2")

    var nums = 1..100    //声明一个 包含 1--100之间数值的区间，默认是闭区间
    whenFunc4(2)
    whenFunc4(12)
    whenFunc4(22)
    whenFunc6(22)
//    whenFunc6("d")//如果不能传递其他值，意义不大
    whenFunc7(2)
    whenFunc7(6)
    println("====================")
    println("创建数组、集合、for循环：  ")
    var arrs1 = arrayOf(1, 2, 3, 4, 5, 6, 110)  //创建数组
    var list1 = listOf(1, 2, 3, 99)

    forFun1(arrs1)
    forFun1(arrs1)
    forFun2(arrs1)
    forFun3(arrs1)
    forFun4(arrs1)
    forFun5(arrs1)

    println("创建map、常见操作、遍历map：  ")
    val mapOf = mapOf<String, String>("key1" to "red", "key2" to "blue")//不可变map
    val hashMapOf = hashMapOf<String, String>("key1" to "red", "key2" to "blue")//
    println("判断是否有某个 key,,${"key1" in hashMapOf}")
    println("判断是否有某个 key,,${"key2" in hashMapOf}")
    //判断是否任一key-value对的key的长度是不是都大于4、value=blue
    println("检查hashMapOf有无，key长度>4，value=blue的 = ${hashMapOf.any { it.key.length > 4 && it.value == "blue" }}")

    //还有mutableMapOf、linkedMapOf、sortedMapOf（TreeMap）等创建方式，同事list也有不同的方式方式
    val hashMapOf2 = hashMapOf<String, String>("key2" to "blue", "key3" to "red")//
    //求并集
    println("集合相加 = ${hashMapOf + hashMapOf2}")
    //集合相减
    println("集合相减 = ${hashMapOf - hashMapOf2}")
    //移除元素
    println("初始化时的 hashMapOf 长度 = ${hashMapOf.size}：$hashMapOf")
    hashMapOf.remove("key1")
    hashMapOf["key4"] = "blue"
    hashMapOf["key5"] = "blue"
//    println("经历移除后的 hashMapOf 长度 = ${hashMapOf.size}：$hashMapOf")

    //遍历Map的key-value对，entris元素返回key-value对组成的Set
    for (en in hashMapOf.entries) {
        println("遍历Map的key-value对，entris元素返回key-value对组成的Set,->key = ${en.key},,value = ${en.value}")
    }
    //先遍历Map的key，再通过key获取value
    for (key in hashMapOf.keys) {
        println("先遍历Map的key，再通过key获取valu -> key= $key->value = ${hashMapOf[key]}")
    }
    //直接用for-in循环遍历Map
    for ((key, value) in hashMapOf) {
        println("取出key和value ->key = $key,,value = $value")
    }
    hashMapOf.clear()
    println("执行clear() 后的map = $hashMapOf")

    println("====================")

    var i = { x: Int, y: Int -> x + y } //声明函数i,接收两个Int类型参数 x、y，返回 x+y 的值
//    i(3, 5) //调用使用 var 声明的函数 i
    println("使用 var 声明函数——函数表达式1(重点！)${   i(3, 5) }")
    var j: (Int, Int) -> Int = { x, y -> x + y }   //声明函数j,它接收的参数是两个Int， 返回一个Int，对应的表达式是 {x,y->x+y}
//    j(4, 4)    //调用函数
    println("使用 var 声明函数——函数表达式2（重点！）${    j(4, 4) }")

    println("================================================")
}

//函数多参数+带返回值的格式
fun usePow(double1: Double, double2: Double): Double {
    return Math.pow(double1, double2)
}

//函数简化
fun usePow2(double1: Double, double2: Double): Double = Math.pow(double1, double2)

//接收空参数方法的使用
fun testNull(str: String?) {
    println("接收空参数方法的使用，传入的参数str = $str")
}

//检测某个值是否在区间或者集合中
fun whenFunc4(a: Int) {
    when (a) {
        in 1..5 -> println("检测某个值是否在区间或者集合中:$a 在 1..5 的区间之内")
        !in 10..15 -> println("检测某个值是否在区间或者集合中:$a 不在 10..15 的区间之内")
        else -> println("检测某个值是否在区间或者集合中:$a 在 10..15 的区间之内")
    }
}

//检测某个值是否是某种类型
// 如果不能传递其他值，意义不大
fun whenFunc6(a: Int?) {
    when (a) {
        is Int -> println("检测某个值是否是某种类型:$a 是Int类型")
        else -> println("检测某个值是否是某种类型:$a 不是Int类型")
    }
}

//when后面也可以不跟参数时
fun whenFunc7(a: Int) {
    when {  //此处未跟参数，所以分支条件必须是 简单的 boolean 表达式
        a < 6 -> println("when后面也可以不跟参数时 $a 小于6")
        a == 6 -> println("when后面也可以不跟参数时 传入的值是6")
        else -> println("when后面也可以不跟参数时 $a 大于6")
    }
}

//检查某个值是否在集合中
fun whenFunc5(a: Int) {
    when (a) {
        in 1..5 -> println("检测某个值是否在区间或者集合中:$a 在 1..5 的区间之内")
        !in 10..15 -> println("检测某个值是否在区间或者集合中:$a 不在 10..15 的区间之内")
        else -> println("检测某个值是否在区间或者集合中:$a 在 10..15 的区间之内")
    }
}

//遍历获取数组中的数据 方式1
fun forFun1(array: Array<Int>) {
    for (item in array) {
        println("for循环的使用1 =  $item")
    }
}

//遍历获取数组中的数据 方式2
fun forFun2(array: Array<Int>) {
    for (item: Int in array) {
        println("for循环的使用2 =  $item")
    }
}

//遍历数组中的索引
fun forFun3(array: Array<Int>) {
    for (index in array.indices) {
        println("for循环的使用3 遍历数组中的索引 =  $index")
    }
}

//同时遍历数据和索引
fun forFun4(array: Array<Int>) {
    for ((index, item) in array.withIndex()) {
        println("for循环的使用4 同时遍历数据和索引 =  索引 = $index ，，value = $item")
    }
}

//forEach,,遍历到的数据使用固定的 it 代表
fun forFun5(array: Array<Int>) {
    array.forEach {
        //forEach 遍历到的数据使用固定的 it 代表
        println("for循环的使用5 forEach 中的数据包含 $it")
    }
}