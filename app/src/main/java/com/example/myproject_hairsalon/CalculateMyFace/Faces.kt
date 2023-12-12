package com.example.myproject_hairsalon.CalculateMyFace

/*
Here, in this windows, we are going to make a function that calculate the type of face of the user
*/

data class Face(
    var pointA: Float,
    var pointB: Float,
    var pointC: Float,
    var pointD: Float,
    var pointE: Float
) {
    companion object {
        fun Faces(face: Face): String {

            val result: String = when {
                esAlargado(face) -> {
                    "Your face type is LONG"
                }
                esRectangular(face) -> {
                    "Your face type is RECTANGULAR"
                }
                esCuadrado(face) -> {
                    "Your face type is SQUARE"
                }
                esTriangular(face) -> {
                    "Your face type is TRIANGULAR"
                }
                esCorazon(face) -> {
                    "Your face type is HEART"
                }
                esTriangularInvert(face) -> {
                    "Your face type is 'INVERTED TRIANGLE'"
                }
                esDiamante(face) -> {
                    "Your face type is DIAMOND"
                }
                esRedondo(face) -> {
                    "Your face type is ROUND"
                }
                else -> {
                    "Your face type is OVAL"
                }
            }
            return result
        }
    }
}

fun esAlargado(
    face: Face
): Boolean {
    val range = 0.6
    val minimumRange = face.pointA - range
    val maximumRange = face.pointA + range
    val comparison = face.pointE * 3
    var result = false

    if (comparison > face.pointD) {
        result = true
    }
    return result
}

fun esRectangular( //"E" tiene que se mayor a 1/3 de "D" para que se cumpla esta condición
    face: Face
): Boolean {
    val range = 0.6
    val minimumRange = face.pointA - range
    val maximumRange = face.pointA + range
    var result = false

    if (face.pointB in minimumRange..maximumRange) {//Que este entre el rango de menos o mas
        if (face.pointC in minimumRange..maximumRange) {
            if (face.pointD > face.pointB) {
                    result = true
            }
        }
    }
    return result
}

fun esCuadrado( //Este deberia ser parecido a, b, c y d
    face: Face
): Boolean {
    val range = 0.6
    val minimumRange = face.pointA - range
    val maximumRange = face.pointA + range
    var result = false

    if (face.pointB in minimumRange..maximumRange) { //Que este entre el rango de menos o mas
        if (face.pointC in minimumRange..maximumRange) {
            if (face.pointD in minimumRange..maximumRange) {
                result = true
            }
        }
    }
    return result
}

fun esTriangular(
    face: Face
): Boolean {
    var result = false

    if (face.pointA < face.pointB && face.pointB < face.pointC) {
        result = true
    }
    return result
}

fun esCorazon(
    face: Face
): Boolean {
    val range = 0.6
    val minimumRange = face.pointA - range
    val maximumRange = face.pointA + range
    var result = false

    if (face.pointB in minimumRange..maximumRange && face.pointC < minimumRange) {
        result = true
    }
    return result
}

fun esTriangularInvert(
    face: Face
): Boolean {
    var result = false

    if (face.pointA > face.pointB && face.pointB > face.pointC) {
        result = true
    }
    return result
}

fun esDiamante(
    face: Face
): Boolean {
    val range = 0.6
    //val minimumRange = face.pointA - range
    //val maximumRange = face.pointA + range
    var result = false

    if (face.pointA < face.pointB && face.pointC < face.pointB) {
        result = true
    }
    return result
}


fun esRedondo(
    face: Face
): Boolean {
    val range = 0.6
    val maximumRangeB = face.pointB + range
    val minimumRangeB = face.pointB - range
    var result = false

    if (face.pointD in minimumRangeB..maximumRangeB){
        result = true
    }
    return result
}


/*fun esOvalado(face: Face): Boolean {
    val range = 0.6
    val minimumRangeA = face.pointA - range
    val maximumRangeA = face.pointA + range
    val maximumRangeB = face.pointB + range
    val minimumRangeB = face.pointB + range
    var result = false

    if (face.pointC in minimumRangeA..maximumRangeA &&
        face.pointB in minimumRangeB..maximumRangeB
    ) {
        result = true
    }
    return result
}*/
