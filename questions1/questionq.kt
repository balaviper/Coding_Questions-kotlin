package com.basics.kotlin_basics1.questions1

import java.util.Date
import java.util.Scanner

// 1.Define the Variable which can hold any value
var x = 0

// 2. Define Variable which can hold function
val funVar: (st: String) -> Int = { 0 }

//3.Declare a function which accepts function as parameter
fun funPar(str: String, fn: (st: String) -> Unit) {
    println(fn(str))
}
//4.Declare a function which returns another function which returns current date

val fn: () -> Date = fun(): Date { // inner anonymous function
    val dt = Date()
    return dt
}

//5.Represent a function in lambda, anonymus and normal function for accepting float array and squaring each element and returing the new array
val arr1 = floatArrayOf(1.0f, 2.0f, 3.0f, 4.0f, 5.0f)

//lambda
val squareLm = { arr: Array<Float> ->
    val arr2 = FloatArray(arr.size)
    var i=0
    for (num in arr) {
         arr2[i]= num * num
        i++
    }

}

//normal
fun square(arr: FloatArray) {
    for (num in arr) {
        val output = num * num
        println(output.toString())
    }
}
//annominus

//6.Write a function for repeting given string n times (if language supports infix, it must be infix)
infix fun Unit.printimes(n: Int) = "bala".repeat(n)

//7Write a function for converting string to an char array (if language supports infix, it must be infix).
infix fun Unit.convert(ch: String) = ch.toCharArray()

//8.Write a function for upper casing nth element in given char array
var charArr = charArrayOf('a', 'b', 'c')
fun upp(arr: CharArray) {
    arr[arr.size - 1] = arr[arr.size - 1].uppercaseChar()
    println(arr.contentToString())
}

//9.Write code for explaining traling lambdas can be taken out of parenthesis
var trailing = intArrayOf(1, 2, 3, 6, 4, 5)
fun trail(arr: IntArray, fn: (x: Int) -> Unit) {
    for (n in arr) {
        fn(n)
    }

}

val fn1 = fun(num: Int) {
    println("Trailing - ${num * num}")
}

//10.Create an array with default string value of each element i.e. hello. Write a funtion for changing nth element of same array to hi
var arr3 = Array<String>(5) { "hello" }
fun changeHi(arr: Array<String>) {
    arr[arr.size - 1] = "hi"
    println(arr.contentToString())
}

//11.change type of float to int
var n: Int = 20
var f = n.toFloat()

//12.convert string to int
val s = "101"
val strToInt = Integer.valueOf(s)

//13.write a funtion to check type of given argument ( must be inline if supports)
fun check(str: String): Boolean = (str is String)

//14.Write a function to calculate the sum, avg, min, max of given array
fun calculate(arr: IntArray) {
    var sum = 0
    var min = arr[0]
    var max = 0
    for (i in arr) {
        sum += i
        if (i < min) {
            min = i
        }
        if (i > max) {
            max = i
        }
    }
    var avg = sum / arr.size
    println("sum $sum avg $avg min $min max $max")
}

//15.Write a function to calculate second highest element in an array
fun secondHighest(arr: IntArray) {
    arr.sort()
    println(arr[arr.size - 2])

}

//16.Write a function to calculate nth highest element in an array
fun highest(arr: IntArray) {
    val highest: Int = arr.maxOrNull() ?: 0
    println(highest)
}
//17.Get marks from user and display result conditions, marks > 70 = distinction, marks > 60 = pass,
// marks <= 60 second class, marks >= 40 third class, marks < 40 = fail

fun markEvalute() {
    var sc = Scanner(System.`in`)
    println("Enter mark")
    val mark = sc.nextInt()
    when (mark) {
        in 70..100 -> println("Distinction")
        in 60..70 -> println("Pass Second class")
        in 40..60 -> println("Pass Third class")
        in 0..40 -> println("fail")
    }
}

//18.Get investment amount from user and suggest stock names to invest in. Amount > 1L = abc,
// amount between 1.5 to 2L = pqr, amount between 2.5L and above = xyz
fun stock() {
    var sc = Scanner(System.`in`)
    println("Enter Ammount")
    val amount = sc.nextDouble()
    if (amount >= 100000) {
        if (amount >= 150000 && amount <= 200000) {
            println("pqr")
        } else if (amount >= 250000) {
            println("xyz")
        } else {
            println("abc")
        }
    }
}

//19.Write a function to print string array in reversed order (use loop, no reverse/ready function)
fun reverser(arr: IntArray) {
    val n = arr.size - 1
    for (i in n downTo 0 step 1) {
        println(arr[i])
    }
}

//20.Write a program which uses all operators for 2 given numbers
fun operation(i: Int, j: Int) {
    println("Arithmetic operator ${i + j} ${i - j} ${i / j} ${i * j} ")
    println("Logical operator ${i == j} ${i != j} ${i is Int && (j == 60)} ${i is Int || j == 50}")
    println("conditional operator ${i < j} ${i > j} ")
    println("bitwise operator ${i and j} ${i or j} ${(i == j).not()} ${i xor j}")
}

fun main() {
    println(Unit.printimes(2))
    println(Unit.convert("bala"))
    square(arr1)
    upp(charArr)
    trail(trailing, fn1)
    trail(trailing) { num: Int ->
        println("trailing ${num * num}")
    }
    changeHi(arr3)
    println(strToInt)
    println(check("bala"))
    calculate(trailing)
    secondHighest(trailing)
    highest(trailing)
    markEvalute()
    stock()
    reverser(trailing)
    operation(20, 49)

}
