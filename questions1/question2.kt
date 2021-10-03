package com.example.kotlinbasics.test.testing.questions1

import android.icu.number.IntegerWidth
import java.time.LocalDate
import java.util.*

//1.Write a function merge to 2 integer arrays. input 2 arrays, output merged array
fun merge(arr1 : IntArray, arr2 : IntArray) : IntArray {return arr1 + arr2}
//2.Write a function to find common elemnts from 2 arrays. input 2 arrays, output array of comman elements
fun common (arr1 : IntArray, arr2 : IntArray): List<Int> { var cmn = arr1.filter { arr2.contains(it) }
    return cmn }
//3.Write a function to find unique elements from 2 arrays. input 2 arrays, output array of unique elements
fun uncommon (arr1 : IntArray, arr2 : IntArray): List<Int>{
    var cmn1 = arr1.filter { !arr2.contains(it)}
    var cmn2 = arr2.filter { !arr1.contains(it)}
    return cmn1 +cmn2
}
//4.Write a program to delete nth element of string array
fun delnth()  {
    val str = "Bala"
    println(str.slice(0..str.length-2))
}
//5.Create Bank class with ifsc(text), adrress(text) and id(number) fields. Bank will have only one behaviour i.e performTransaction. Create AbcBank class which is a sub class of Bank.
// AbcBank will have txnDtls(number) field and reverseTransaction(id) method.

open class Bank(open val ifsc : String, open val address : String, open val id : Number) {
    fun performTransaction() {
        println("perform ")
    }
}
class AbcBank(
        override  val ifsc : String,
        override val address : String,
        override val id : Number,
        val InttxnDtls : Int): Bank(ifsc,address,id){
        fun  reverseTransaction(id: Number){
            println("Reverse transaction $id")
        }
    }
//6.Create ImpData class which will have feilds i.e. size(number), cloud(text), lastUpdate(date).
// Now create DataManagement class, where there would be array of ImpData class with some random static data.
// DataManagement class will have following features find data with size greate that given size,
// find data for given cloud, find data between given dates

 class ImpData(
     private var size : Int,
     private var cloud: String,
    private var lastUpdate : Date
    ){
     var data1: Int
         set(value) {this.size = value}
         get() = this.size
     var data2: String
         set(value) {this.cloud = value}
         get() = this.cloud
     var data3: Date
         set(value) {this.lastUpdate = value}
         get() = this.lastUpdate

 }


class DataManagement{
    var classArray : ArrayList<ImpData> = ArrayList()
    init{
        val obj1 = ImpData(101,"AWS",Date(2000,1,3))
        classArray.add(obj1)
        classArray.add(ImpData(102,"Google",Date(2001,1,3)))
        classArray.add(ImpData(103,"HHH",Date(2002,1,3)))
        classArray.add(ImpData(104,"YYY",Date(2003,1,3)))
        //println(classArray[0].data1)
    }
    fun findColud(cloud : String): ImpData?{
        for(i in classArray){
            if(i.data3.equals(cloud)){
                println("Cloud found size = ${i.data1} cloud = ${i.data2} date = ${i.data3}")
                return i
            }
        }
        println("Cloud not found")
        return null
    }

    fun checkSize(size : Int){
        var c = 0
        for(i in classArray){
            if(i.data1 > size){
                println("Size found size = ${i.data1} cloud = ${i.data2} date = ${i.data3}")
                c++
            }
        }
        if(c==0){
            println("No data Match found")
        }
    }

    fun checkDate(date : Date){
        var c = 0
        for(i in classArray){
            if(i.data3.equals(date)){
                println("Date found size = ${i.data1} cloud = ${i.data2} date = ${i.data3}")
                c++
            }
        }
        if(c==0){
            println("No data Match found")
        }
    }

}
//7.Create UserInuputHelper class, which will be helper utility for getting inputs from user and which will have following methods
// i.e. readUserName() = convert input to text, readMobileNumber() = convert input to text,
// readAge() = convert input to number, readAddress() = convert input to text,
// readBirthDate() = convert input to date

class UserInputHelper{
    val sc = Scanner(System.`in`)
    private lateinit var name : String
    private lateinit var  mobile: String
    private lateinit var  age : Integer
    private lateinit var  address : String

    fun readUserName(){
        println("Enter user Name")
        this.name = sc.nextLine()
    }
    fun readMobileNumber(){
        println("Enter user mobile number")
        this.mobile = sc.next()
    }
    fun readAge(){
        println("Enter user age")
        this.age = Integer(sc.nextInt())
    }
    fun readAddrss(){
        println("Enter user address")
        sc.nextLine()
        this.address = sc.nextLine()
    }

    fun display(){
        println("Data  is name = $name mobile : $mobile age = $age address = $address")
    }

}
//8.Create a class for displaying menu to user. User can select menu and sub menu for selected menu will be displayed.
// e.g. Select Your Choice 1. Cart, 2. Biil, 3. User Info, 4. Exit; if user enter choice 1 Submenu for Cart will be displayed
// e.g. 1. Add to Cart 2. Remove From Cart 3. Main Menu (Note: question does not asks you implement complete functionality of cart,
// question wants you to perfom menu and submenu related demontration only, Cart is just example).
// This class will have choice as member variable and only on function i.e. menuExit()

//9.Create Mobile class which will have mobile number(text), country code(number) as fields.
// Write a code for performing equality on two mobile objects
class Mobile(val mobile : String, val countryCode : Number){
    override fun equals(other: Any?): Boolean {
        other as Mobile
        return mobile==other.mobile && countryCode == other.countryCode
    }
}
//10.Write a class Calculator with constructor accepts num1(number) and num2(number) in primary constructor
// and operator(text) in secondary constructor.
// In a class there will be a method i.e performCalculation, which will calculate the result.
// You might need to use if else
// (Note. This is more specific to kotlin but can be implemented in other languages using constructor overloading)
class Calculator(val num1: Int, val num2: Int){
    constructor( op : Char, n1 :Int, n2 : Int): this(n1,n2){
        if(op=='+')
            println(n1+n2)
        else if(op=='-')
            println(n1-n2)
        else if(op=='*')
            println(n1*n2)
        else if(op=='/')
            println(n1/n2)

    }
}
//11.Write a class Fruit with only (primary) constructor with taste(text) as field.
// Create a class Mango which is subclass of Fruit.
open class Fruit(open val taste : String){
    fun parent(){
        println("Parent class $taste")
    }
}
class Mango(override val taste: String): Fruit(taste){
    fun sub(){
        println("Subclass $taste")
    }
}
//12.Write a class Fruit with only (secondary) constructor with taste(text) as field.
// Create a class Mango which is subclass of Fruit.
open class Fruit1{
    constructor(taste: String){
        println("Sec constructor $taste")
    }
}
class Mango1( val taste : String): Fruit1(taste){
    fun sub(){
        println("Subclass $taste")
    }
}
//13.Write a private(if possible) class Wallet with
// amount (number) access limited class, id (number) access limited to package or module,
// owner(text) access limited to sub class, isOpen (boolean) access to all.
// Prove access levels are working properly.
private class Wallet(
    private val amount: Int,
    internal val id :Int,
    protected val owner : String,
    public  val isOpen : Boolean
){
  init {
      println("Object is created Successfully")
  }
}
//14.Create interface LightProvider which will have field intensity(number) and onFlash method.
// Class with one primary constructor and one secondary constructor should implement this interface.
// Demonstrate runtime polymorphism.
interface LightProvider{
    val int : Int
    fun onFlash()
}
class Light(var x: Boolean):LightProvider{
    override val int: Int =1
    constructor(x1: Int,status : Boolean) : this(status){
        println("Secondary Constructor called")
    }

    override fun onFlash() {
        x = true
        println("Flash on $x")
    }
}
//15.How do you create object of interface and abstract class. Demonstrate by means of examples.
 // object cannot be created

//16.Create Gps class with fields latitude(number), longitude(number), radius(number)
// and a method checkPoint(lat, lng) which will check given lat and lng are inside radius or not.
// Hint Also class should provide methods for equality of two objects, and text representation of object.
// Constructor should accept latitude, longitude and radius. Also provide getter and setter methods.\
class Gps(
    var latitute : Int,
    var longitude : Int,
    var radius : Int
){
    var lt: Int
        set(value) {this.latitute = value}
        get() = this.latitute
    var lo: Int
        set(value) {this.longitude = value}
        get() = this.latitute
    var rd: Int
        set(value) {this.radius = value}
        get() = this.radius

    override fun equals(other: Any?): Boolean {
        other as Gps
        return latitute==other.latitute && longitude == other.latitute && radius == other.radius
    }

    fun checkPoint(lat: Int, lng : Int){
        if(lat<=radius && lng <=radius){
            println("Inside radius")
        }
        else{
            println("Outside radius")
        }
    }
}
//17.mplement an objected oriented solution for creating the following shapes
// Ellipse, Circle, Square, Rectangle, Triangle, Parallelogram.
// Each shape created must have the following parameters : unique id, color.
// And following functions: color change, move, area, circumference, is inside, copy.
open abstract class Shape(open var uniqueId : Int, open var color : String){
    abstract fun colorChange(color : String )
    abstract  fun move()
    abstract fun area()
    abstract fun circumference()
    abstract fun isInside()
    abstract fun copy()
}
class Ellipse(override var uniqueId : Int, override var color : String, var a : Int, var b : Int): Shape(uniqueId,color){

    override fun colorChange(color: String) {
        this.color = color
    }

    override fun move() {
        println("Ellipse moved")
    }

    override fun area() {
        var pi = Math.PI
        println("Area : ${pi*a*b}")
    }

    override fun circumference() {
        val perimeter = 2 * 3.14 * Math.sqrt((a * a + b * b) / (2 * 1.0));
    }

    override fun isInside() {
        println("Is inside Ellipse ")
    }

    override fun copy() {
        println("Coppied")
    }
}

class Circle(override var uniqueId : Int, override var color : String, var rad : Double): Shape(uniqueId,color){
    override fun colorChange(color: String) {
        this.color = color
    }

    override fun move() {
        println("Circle Moved")
    }

    override fun area() {
        println("Circle Area = ${Math.PI*rad*rad}")
    }

    override fun circumference() {
        println("Circle circumfrence = ${Math.PI*2*rad}")
    }

    override fun isInside() {
        println("Is inside circle ")
    }

    override fun copy() {
        println("Coppied")
    }
}

class Square(override var uniqueId : Int, override var color : String, var side: Int): Shape(uniqueId,color){
    override fun colorChange(color: String) {
        this.color = color
    }

    override fun move() {
        println("Square Moved")
    }

    override fun area() {
        println("Square area = ${side*side}")
    }

    override fun circumference() {
        println("Perimeter square = ${4*side}")
    }

    override fun isInside() {
        println("Is inside Square ")
    }

    override fun copy() {
        println("Copied")
    }
}

class Rectangle(override var uniqueId : Int, override var color : String,var l: Int, var b: Int): Shape(uniqueId,color){
    override fun colorChange(color: String) {
        this.color = color
    }

    override fun move() {
        println("Rectangle Moved")
    }

    override fun area() {
        println("Area Rectangle = ${l*b}")
    }

    override fun circumference() {
        println("Perimeter Rectangle = ${2*(l+b)}")
    }

    override fun isInside() {
        println("Is inside Rectangle ")
    }

    override fun copy() {
        println("Copied")
    }
}

class Triangle(override var uniqueId : Int, override var color : String, var h :Int, var b : Int): Shape(uniqueId,color){
    override fun colorChange(color: String) {
        this.color = color
    }

    override fun move() {
        println("Triangle Moved")
    }

    override fun area() {
        println("Area Triangle = ${0.5*h*b}")
    }

    override fun circumference() {
        println("Perimeter Triangle")
    }

    override fun isInside() {
        println("Is inside Triangle ")
    }

    override fun copy() {
        println("Copied")
    }
}

class Parallelogram(override var uniqueId : Int, override var color : String, val b: Int, val h: Int): Shape(uniqueId,color){
    override fun colorChange(color: String) {
        this.color = color
    }

    override fun move() {
        println("Parallelogram Moved")
    }

    override fun area() {
        println("Area parallelogram = ${b*h}")
    }

    override fun circumference() {
        println("perimeter = ${2*b*h}")
    }

    override fun isInside() {
        println("Is inside Parallelogram ")
    }

    override fun copy() {
        println("Copied")
    }
}

//18.Create abstract class Book, which will have setTitle() abstract method.
// You have to create another class that extends the abstract class.
// Then you can create an instance of the new class.Notice that setTitle method is abstract too and has no body.
// That means you must implement the body of that method in the child class.

open abstract class Book{
    abstract fun setTitle()
}
class BookImp: Book(){
    private lateinit var title: String
    var sc = Scanner(System.`in`)
    override fun setTitle(){
        println("Enter the title for the book")
        this.title = sc.nextLine()
        println("Title set successfully")
    }
}
//19.Create abstract class A with abstract method a(), Class B extends A, Class C extends A.
// Class B is having method b(), Class C is having method c().
// Now create Class Abc which will have only one method abc() and which should accept parameter,
// that can hold objects of both classes i.e B and C\

open abstract  class A{
    abstract fun a()
}
open class B: A(){
    override fun a(){
        println("Fun A")
    }
    fun b(){
        println("Fun B")
    }
}
open class C: A(){
    override fun a(){
        println("Fun A")
    }
    fun c(){
        println("Fun C")
    }
}
class Abc{
    fun method(other: Any?) {
        if(other is B)
            println("Object of class b")
        else if(other is C)
            println("Object of class c")
    }
}


fun main() {
//    //1...
//    var arr1 = intArrayOf(1,2,3,4,5,6)
//    var arr2 = intArrayOf(6,7,8,9)
//    println(merge(arr1 ,arr2).contentToString())
//    //2...
//    println(common(arr1 ,arr2))
//    //3...
//    println(uncommon(arr1 ,arr2))
//    //4.....
//    delnth()
//    //5....
//    val bk = Bank("101000","ghhhgafksv",101)
//    bk.performTransaction()
//    val obj = AbcBank("10000","afafafaf",101, 10001)
//    obj.reverseTransaction(bk.id)
//    obj.performTransaction()
//    //6.
//    val data = DataManagement()
//    data.findColud("Aws")
//    data.checkSize(102)
//    data.checkDate(Date(2006,1,3))
//    //7. question
//    val userObj = UserInputHelper()
//    userObj.readUserName()
//    userObj.readMobileNumber()
//    userObj.readAge()
//    userObj.readAddrss()
//    userObj.display()
//    //8...
    //9...
//    val mob1 = Mobile("123456",91 )
//    val mob2 = Mobile("123",91)
//    println(mob1.equals(mob2)
    //10...
//    val add = Calculator('+',12,10)
//    val mul = Calculator('*',12,10)
    //11....
//    val frt = Fruit("Teastless")
//    val s = Mango("sweet")
//    s.sub()
//    s.parent()
//    frt.parent()
    //12....
//    val frt1 = Fruit("Teastless")
//    val s1 = Mango("sweet")
//    s1.sub()
//    s1.parent()
//    frt1.parent()
    //13.....
//    val w =Wallet(1000,101,"Bala",true)
    //14...
//    val lig = Light(1,true)
//    lig.onFlash()
//    //16......
//    val gp = Gps(12,15,90)
//    gp.checkPoint(80,97)
//    gp.rd=100
//    gp.checkPoint(34,97)
    //17....
//    val cir = Circle(101, "Yellow",23.5)
//    cir.area()
    //18.....
//    val bk = BookImp()
//    bk.setTitle()
    //19......
    val b = B()
    b.b()
    b.a()
    val c = C()
    c.c()
    val com = Abc()
    com.method(c)
    com.method(b)
    //20 .....refer problem No 17 for Overriding

}
