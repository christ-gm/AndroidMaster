package com.eltulita.androidmaster.sintaxis

fun main(){
    val weekDays= arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    println(weekDays) //Asi se imprime la direccion de memoria donde se almacena la lista
    println(weekDays[0])
    println(weekDays.size)

    //en los arrays se puede cambiar los elementos
    weekDays[0] = "lol"
    println(weekDays[0])


    //Bucles para arrays
    //recorrer indices
    for(position in weekDays.indices){
        println(position)
    }
    //recorrer elementos del array
    for(dia in weekDays){
        println(dia)
    }

    //

    for((position, value) in weekDays.withIndex()){
        println("La posicion $position, contiene $value")
    }


}