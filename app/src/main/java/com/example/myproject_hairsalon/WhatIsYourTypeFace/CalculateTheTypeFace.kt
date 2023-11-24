package com.example.myproject_hairsalon.WhatIsYourTypeFace

import androidx.compose.runtime.Composable
import com.example.myproject_hairsalon.FaceTitleAndDescription.getTypesOfFaces
import com.example.myproject_hairsalon.FaceTitleAndDescription.itemFaceTitDescp
import com.example.myproject_hairsalon.R

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
        fun calculateYourFace(face: Face): String {
            var result = ""
            var picture = 0

            if (esAlargado(face)) {
                result = "Your face type is LONG"
                picture = R.drawable.alargado
            }

            if (esRectangular(face)) {
                result = "Your face type is RECTANGULAR"
                picture = R.drawable.rectangular
            }

            if (esCuadrado(face)) {
                result = "Your face type is SQUARE"
                picture = R.drawable.cuadrado
            }

            if (esTriangular(face)) {
                result = "Your face type is TRIANGULAR"
                picture = R.drawable.pera_triangular
            }

            if (esCorazon(face)) {
                result = "Your face type is HEART"
                picture = R.drawable.corazon
            }

            if (esTriangularInvert(face)) {
                result = "Your face type is 'V'"
                picture = R.drawable.triangulo_v
            }

            if (esDiamante(face)) {
                result = "Your face type is DIAMOND"
                picture = R.drawable.diamante
            }

            if (esRedondo(face)) {
                result = "Your face type is ROUND"
                picture = R.drawable.redondo
            }

            if (esOvalado(face)) {
                result = "Your face type is OVAL"
                picture = R.drawable.ovalado
            }

            return "$picture \n $result"
        }
    }
}

fun esAlargado(
    face: Face
): Boolean {
    val calculateRange = face.pointD / 3
    var result = false

    if (face.pointE > calculateRange) {
        result = true
    }
    return result
}

fun esRectangular(
    face: Face
): Boolean {
    val range = 0.6
    val minimumRange = face.pointA - range
    val maximumRange = face.pointA + range
    var result = false

    if (face.pointB in minimumRange..maximumRange) { //Que este entre el rango de menos o mas
        if (face.pointC in minimumRange..maximumRange) {
                result = true
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
            if (face.pointD < face.pointA) {
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

    if (face.pointA < face.pointB && face.pointB < face.pointC) {
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

    if (face.pointA > face.pointC && face.pointB > face.pointC) {
        result = true
    }
    return result
}

fun esRedondo(
    face: Face
): Boolean {
    val range = 0.6
    val minimumRangeA = face.pointA - range
    val maximumRangeA = face.pointA + range
    val maximumRangeB = face.pointB + range
    val minimumRangeB = face.pointB + range
    var result = false

    if (face.pointC in minimumRangeA..maximumRangeA &&
        face.pointD in minimumRangeB..maximumRangeB
    ) {
        result = true
    }
    return result
}

fun esOvalado(face: Face): Boolean {
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
}

