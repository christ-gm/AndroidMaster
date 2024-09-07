package com.eltulita.androidmaster.sintaxis

fun getMonth(month:Int){
    if (month == 1){
        println("enero")
    }
    else if (month == 2){
        println("febrero")
    }
    else if (month == 3){
        println("marzo")
    }
    else if (month == 4){
        println("abril")
    }
    else if (month == 5){
        println("mayo")
    }
    else if (month == 6){
        println("junio")
    }
    else{
        println("Otro mes")
    }
}
// Esto no es optimo, en este caso seria mejor utilizar when

fun getMonthWhen(month:Int){
    when(month){
        1-> println("Enero")
        2-> println("febrero")
        3-> {
            println("marzo")
            println("marzo")
            println("marzo")
            println("marzo")
        }
        4-> println("abril")
        5-> println("mayo")
        else-> println("Otro mes")
    }
}

fun getTrimester(month: Int){
    when(month){
        1,2,3-> println("primer trimestre")
        4,5,6-> println("segundo trimestre")
        7,8,9-> println("tercer trimestre")
        10,11,12-> println("cuarto trimestre")
        else-> println("trimestre no valido")
    }
}

// tambien se puede hacer de la siguiente forma
fun getSemestre(month: Int){
    when(month){
        in 1..6 -> println("Primer semestre") //[1,6]
        in 6..12 -> println("Segundo semestre") //[7,12]
        else -> println("Semestre no valido")
    }
}

fun result(value:Any){ //TENER CUIDADO CON  LA VARIABLE ANY
    when(value){
        is Int -> println(value + value)
        is String -> println("$value")
        is Boolean -> if(value){
            println(value)
        }
    }
}

fun getSemesterOneLine(month:Int) = when(month){
    in 1..6-> "primer semestre"
    in 7..12-> "segundo semestre"
    !in 1..12-> "semestre no valido"
    else -> "lol"
}

fun main(){
    //getMonthWhen(1)
    //getTrimester(12)
    //getSemestre(6)
    //result(2)
    println(getSemesterOneLine(13))
}