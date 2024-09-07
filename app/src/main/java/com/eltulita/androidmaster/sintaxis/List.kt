package com.eltulita.androidmaster.sintaxis

fun mutableList(){
    val weekDays:MutableList<String> = mutableListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    weekDays.add("sabingo") //add es un append, agrega al final
    println(weekDays)
    //Ahora si quiero colocar un dia en un indice especifico lo hago asi
    weekDays.add(1, "lol")
    println(weekDays)

    //esto
    if(weekDays.isEmpty()){
        //No muestro nada pq no hay
    }
    else{
        weekDays.forEach { println(it) }
    }

    // o esto
    if(weekDays.isNotEmpty()){
        weekDays.forEach { println(it) }
    }
}


fun main(){
    val readOnly:List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

//    println(readOnly.size)
//    println(readOnly)// Ya no muestra la direccion de memoria, ahora muestra la lista. pq las listas hacen automaticamente la funcion .toString()
//    println(readOnly[0])
//    println(readOnly.last())
//    println(readOnly.first())

    //Las listas son buenas para filtrar
//    val example = readOnly.filter { it.contains("a") }
//    println(example)
//    readOnly.forEach { weekDay -> println(weekDay) }
    mutableList()
}