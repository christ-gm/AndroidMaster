package com.eltulita.androidmaster.sintaxis



fun main(){
    var name:String? = null //para dejar string en null se debe poner el ? para asignar variable de tipo string nullable

    //println(name!!.get(3)) // name.get(3) es lo mismo que name[3]. con el !! estas seguro de que no va a ser null
    println(name?.get(3) ?: "Es nulo wey") //?si no es nulo accede a la pos 3. ?: si es nulo imprime "Es nulo wey"
}