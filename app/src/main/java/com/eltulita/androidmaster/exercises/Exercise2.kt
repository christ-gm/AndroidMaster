package com.eltulita.androidmaster.exercises

/*
Las entradas al cine sulen tener un precio diferente segun la edad de los espectadores.

En el codigo inicial que se proporciona en el siguiente fragmento de codigo, escribe un programa que calcule los precios
de estas entradas basados en la edad:

- un precio de entrada infantil de 15$ para personas de 12 anos o menos
- un precio de entrada estandar de 30$ para personas de entre 13 y 60 anos Los lunes, un precio estandar con
descuento de 25$ para el mismo grupo etario

- un precio para adultos mayores de 20$ para personas de 61 anos o mas (asumimos que la edad maxima de un espectador es de 100 anos)

- un valor de 01 para indicar que el precio no es valido cuando un usuario ingresa una edad fuera de las especificaciones
*/


fun main(){
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = false

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}")

}

fun ticketPrice(age:Int, isMonday:Boolean):Int{
    return when(age){
        in 1..12 -> 15
        in 13..60 -> if(isMonday){
            25
        }
        else{
            30
        }
        in 61..100 -> 20
        else -> -1
    }
}