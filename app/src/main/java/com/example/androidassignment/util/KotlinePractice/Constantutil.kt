package com.example.androidassignment.util.KotlinePractice

object Constantutil {
    var App_NAME = "MyPracticeApp"
    var USER_NAME  = "Raju kumar"

    fun printFactorial(i:Int):Int{
        if(i==0 || i==1){
            return 1;
        }
        return i*printFactorial(i-1);
    }
}