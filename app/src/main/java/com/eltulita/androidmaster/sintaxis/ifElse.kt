package com.eltulita.androidmaster.sintaxis

fun main(){
ifBasico()
}

fun ifBasico(){

    //.lowercase() se usa para pasar todo a minusculas
    // .uppercase() para todo a mayusculas
    val animal = "lol"

    if(animal == "perro"){
        println("es un perro")
    }
    else if(animal == "gato"){
        println("es un gato")
    }
    else if(animal == "pajaro"){
        println("es un pajaro")
    }
    else{
        println("No se que es")
    }
}