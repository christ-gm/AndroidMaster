package com.eltulita.androidmaster.exercises

/**
Por lo genera, el telefono te proporciona un resumen de las notificaciones.
En el codigo inicial que se proporciona en el siguiente fragmento de codigo,
escribe un programa que imprima el mensaje de resumen segun la cantidad de
notificaciones que recibiste. El mensaje debe incluir lo siguiente:

La cantidad exacta de notificaciones cuando haya menos de 100
99+ como la cantidad de notificaciones cuando haya 100 o mas
 */


fun main(){
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages:Int){
    //Fill the code
    when(numberOfMessages){
        in 1..99 -> println("You have $numberOfMessages notifications")

        else -> println("Your phone is blowing up! You have 99+ notifications.")
    }
}