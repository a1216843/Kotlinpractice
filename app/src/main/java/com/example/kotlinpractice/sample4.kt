package com.example.kotlinpractice

// Singleton Pattern
// CarFactory는 한 번만 생성된다.
object CarFactory {
    val cars : MutableList<Car> = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(
    val horsePower : Int
)

fun main() {
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString()) // size는 2로 car와 car2가 저장되어있다. 즉 CarFactory는 객체가 한 번만 생성되고 다시 생성되지 않는다.
}