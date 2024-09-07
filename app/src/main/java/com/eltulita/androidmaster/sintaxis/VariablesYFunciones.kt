package com.eltulita.androidmaster.sintaxis

// Comentarios

/*Comentario en
* bloque*/


// val es constante y var es variable

fun main(){
    // Variables numericas

    // Variables int
    val age:Int = 22
    var age2:Int = 30
    //println(age2)
    age2 = 31
    //println(age2)
    // Variable Long
    val longExample:Long = 30 // Esto ocupa mas memoria, perfectamente se podria usar int

    // Variable Float
    val flotanteExample:Float = 3.1415f // se pone la f al final de un float

    // Variable Double
    val doubleExample:Double = 12345.321455

    // Variables alfanumericas

    //Char

    val charExample:Char = 'e' // como es char solo soporta 1 caracter

    //String
    val stringExample:String = "Hola este es un string"

    // Variables Booleanos

    val booleanExample:Boolean = true
    val booleanExample2:Boolean = false

    //println("Hola tenia $age de edad, pero ahora tengo $age2")
    sumar(2,3)
    println(restar(1,1))
    showMyAge()
}

fun sumar(a:Int, b:Int){
    println(a+b)
}

// Se pueden retornar cosas con el return
fun restar(a: Int, b: Int):Int{
    return a - b
}

// Se pueden entregar valores por defecto en las funciones

fun showMyAge(age:Int = 20){
    println(age)
}

