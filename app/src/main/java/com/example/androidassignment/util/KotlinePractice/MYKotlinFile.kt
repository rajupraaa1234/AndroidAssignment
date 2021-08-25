package com.example.androidassignment.util

import com.example.androidassignment.util.KotlinePractice.*

fun main(){
   // print("Hello");
    var obj : MyPojo = MyPojo("Raju","Kumar");
    // getter called
    println(obj.name)
    obj.displey();
    println(obj.toString())

    var obj1 : B = B()
    obj1.Display()


    /** Example for Data Class */
    var user1 : DataClassExample = DataClassExample("raju",10)
    var user2 : DataClassExample = DataClassExample("raju",10)
    if(user1==user2){
        println("Same User")
    }else{
        println("Not Same User")
    }

    /** Practice on Object */
    var ans = Constantutil.printFactorial(5)
    println("Factorial : ${ans}")


    /** Lambda function */
    var program : Program = Program()
    program.add(2,7,object : MyInterface{
        override fun execute(sum: Int) {
            println("sum of two number is : ${sum}")
        }
    })

    var myLambda : (Int,Int) -> (Int) = {a,b-> a+b}    /** lambda function */
    println(myLambda(23,12))

    var myLambdaprinter : (Int) -> Unit = {sum->println(sum)}
    program.add(2,7,myLambdaprinter)

    /** Example of closure with lambda */
    var result = 0
    program.addWithClosuer(2,7,{x,y -> result = x+y})   /** Updated result value
                                                                But in java this is not possible to update result value inside lambda function */
    println("Updated result : ${result}")


    /** with keyword with lambda */
    var person = Person()
    with(person){
        name = "Raju"
        age =23
    }

    person.apply {
        name = "Raju"
        age = 23
    }.StartRun()     /** In apply we can execute method which is available in Person class after init object */
                     /** But in with we cann't */

}

class Program{
    fun add(a:Int,b:Int,myInterface: MyInterface){
        var sum = a + b
        myInterface.execute(sum)
    }

    fun add(a:Int,b:Int,action:(Int) -> Unit){    /** High level function becouse it accept lambda function as a parameter */
        var sum = a+b
        action(sum)
    }

    fun addWithClosuer(a:Int,b:Int,action : (Int,Int)->Unit){
       action(a,b)
    }
}

interface MyInterface{
    fun execute(sum:Int)
}

class Person{
    var name : String = ""
    var age : Int = 0

    fun StartRun(){
        println("Start to run")
    }
}