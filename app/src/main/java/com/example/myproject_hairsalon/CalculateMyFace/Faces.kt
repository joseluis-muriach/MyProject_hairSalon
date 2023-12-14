package com.example.myproject_hairsalon.CalculateMyFace

/*
Here, in this class, we are going to make the functions that calculate the type of face of the user
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
                isLong(face) -> {
                    "Your face type is LONG"
                }
                isRectangular(face) -> {
                    "Your face type is RECTANGULAR"
                }
                isSquare(face) -> {
                    "Your face type is SQUARE"
                }
                isTriangular(face) -> {
                    "Your face type is TRIANGULAR"
                }
                isTriangle(face) -> {
                    "Your face type is HEART"
                }
                isInvertTriangle(face) -> {
                    "Your face type is 'INVERTED TRIANGLE'"
                }
                isDiamond(face) -> {
                    "Your face type is DIAMOND"
                }
                isRound(face) -> {
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

fun isLong(
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

fun isRectangular( //"E" tiene que se mayor a 1/3 de "D" para que se cumpla esta condición
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

fun isSquare( //Este deberia ser parecido a, b, c y d
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

fun isTriangular(
    face: Face
): Boolean {
    var result = false

    if (face.pointA < face.pointB && face.pointB < face.pointC) {
        result = true
    }
    return result
}

fun isTriangle(
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

fun isInvertTriangle(
    face: Face
): Boolean {
    var result = false

    if (face.pointA > face.pointB && face.pointB > face.pointC) {
        result = true
    }
    return result
}

fun isDiamond(
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


fun isRound(
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

//Is probably that use this function in a future
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
