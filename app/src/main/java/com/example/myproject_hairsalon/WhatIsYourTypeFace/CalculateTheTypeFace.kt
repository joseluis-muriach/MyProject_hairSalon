package com.example.myproject_hairsalon.WhatIsYourTypeFace

import androidx.compose.runtime.Composable

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

    @Composable
    fun CalculateYourFace(
        face: Face
    ) {
        //Haré un when para que luego si es una cosa u otra que haga una cosa u otra
        esAlargado(face)
        esRectangular(face)
        esCuadrado(face)
        esTriangular(face)
        esCorazon(face)
        esTriangularInvert(face)
        esDiamante(face)
        esRedondo(face)
        esOvalado(face)
        return
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
                if (face.pointD > face.pointA) {
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
        val minimumRange = face.pointA - range
        val maximumRange = face.pointA + range
        var result = false

        if (face.pointC in minimumRange..maximumRange && face.pointD > face.pointB) {
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
            face.pointD in minimumRangeB..maximumRangeB) {
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
            face.pointB in minimumRangeB..maximumRangeB) {
            var result = true
        }
        return result
    }
}
