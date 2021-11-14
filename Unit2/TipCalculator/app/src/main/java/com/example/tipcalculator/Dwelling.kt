package com.example.tipcalculator

import kotlin.math.PI

// Tutorial for inheritance

fun main() {

    val squareCabin = SquareCabin(5, 10.0)

    with(squareCabin) {
        println("${buildingMaterial}, ${capacity}, ${hasRoom()}")
    }

    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)

    roundHut.printDwelling()
    roundTower.printDwelling()
}


abstract class Dwelling(private var residents: Int) {

    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    fun printDwelling() {
        println(" ${buildingMaterial}, ${capacity}, ${hasRoom()}, ${floorArea()}")
    }

    abstract fun floorArea(): Double

}

class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {

    override val buildingMaterial = "Wood"
    override val capacity = 6
    override fun floorArea(): Double {
        return length * length
    }
}

open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
    override fun floorArea(): Double {
        return PI * radius * radius
    }
}

class RoundTower(residents: Int, radius: Double, val floors: Int = 2) :
    RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
    override fun floorArea(): Double {
        return floors * super.floorArea()
    }

}



