package com.example.kotlinbasics.test.testing.assesment

import java.util.*

//Requirement Specification
//1. User will enter Question.
//2. User will enter multiple choices for particular question
//3. User will enter correct answer
//4. User should get list of all questions with answer
//5. User should see test particular question
//6. Users will see menu 1. Add Question, 2. Show Questions 3. Test Question 4. Exit.
//Menu will come till the user gives choice 4.

//Hints
//1. Create Question class, which will have id(number), question(text), choices(array),
//anwe(number)
//2. Store Questions in ArrayList<Question>
//3. Create MenuHelper class
//4. Create Repository class
//5. Use find, filter, map etc operations
//6. Follow the structure

class Question {
    private var Id: Int = 0
    private lateinit var question: String
    private lateinit var choice: Array<String>
    private lateinit var answer: String

    //
    var idd: Int
        set(value) {
            this.Id = value
        }
        get() = this.Id
    var qt: String
        set(value) {
            this.question = value
        }
        get() = this.question
    var ch: Array<String>
        set(value) {
            this.choice = value
        }
        get() = this.choice
    var ans: String
        set(value) {
            this.answer = value
        }
        get() = this.answer

}

class Repository {
    val sc = Scanner(System.`in`)
    val questions: ArrayList<Question> = ArrayList<Question>()

    fun userOperration() {

        while (true) {
            println("1.Add Question\n2.Show Question\n3.Test Question \n4.Exit\n")
            var c = sc.nextInt()
            if (c == 1) {
               addQuestions()
            } else if (c == 2) {
                display()
            } else if (c == 3) {
                display()
                testQuestions()
            } else if (c == 4) {
                break
            }
        }
    }

    fun testQuestions(){
        println("\nEnter Question Number to Test Question\n")
        val no = sc.nextInt()
        val qtt = questions.find { it.idd==no }
        println("\nChoose the best option for Question ${qtt?.idd}\n")
        sc.nextLine()
        val answer = sc.nextLine()
        if (answer.equals(qtt?.ans)) {
            println("\nCorrect Answer\n")
        } else {
            println("\nWrong Answer\n")
        }
    }

    fun addQuestions(){
        println("\nEnter number of Questions to add\n")
        val n = sc.nextInt()
        sc.nextLine()
        for (i in 1..n) {
            val q = Question()
            q.idd = i
            println("\nEnter Question $i\n")
            //sc.nextLine()
            q.qt = sc.nextLine()
            println("\nEnter No of choices \n")
            var nc = sc.nextInt()
            sc.nextLine()
            var strArr: Array<String> = Array(nc) { "" }
            for (i in 0..nc-1 step 1) {
                println("\nEnter choice ${i+1}\n")
                var choise = sc.nextLine()
                strArr[i] = choise
            }
            q.ch = strArr

            println("\nEnter correct answer for the Question $i\n")
            q.ans = sc.nextLine()

            questions.add(q)
        }
    }

    fun display(){
        for (i in questions) {
            println("Id : ${i.idd}\n Question : ${i.qt} \n Choice :")
            i.ch.forEach {
                println("       $it") }
        }
    }
}

class MenuHelper {
    fun showMenu() {
        println("**** Main Menu ****")
        val rep = Repository()
        rep.userOperration()

    }

}

fun main() {
    val menu = MenuHelper()
    menu.showMenu()
}