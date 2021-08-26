package com.example.androidassignment.util.KotlinePractice

import android.view.Display

class MyPojo constructor(fname : String,sname : String){
    private var FirstName = fname;
    private var SecondName = sname;


    /** getter method */
    val name :String get() = "${FirstName} ${SecondName}"


    fun displey(){
        println("Person First Name is ${FirstName} and Second Name is ${SecondName}");
    }

    override fun toString(): String {
        return "MyPojo(FirstName='$FirstName', SecondName='$SecondName')"
    }

    /** companion object (static in java) */
    companion object{
        var App_Name = "CoWin App";
        var Var1 ="Var1";
        var temp = 45;
    }
}
open class A{
   open fun Display(){
       println("This is Class A")
   }
}

class B : A(){
  override fun Display(){
      println("this is class B")
  }
}


data class DataClassExample constructor(val name : String, val id:Int){

}

class Bike{
    lateinit var BikeName : String
    var BikeNumber : Int = -1

    constructor(name : String,number:Int){
        this.BikeName = name
        this.BikeNumber = number
    }

}