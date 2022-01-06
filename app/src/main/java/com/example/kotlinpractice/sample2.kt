package com.example.kotlinpractice

class sample2 {}

// 1. Lambda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명 함수이다.
// 1) 메소드의 파라미터로 넘겨줄 수 있다. fun maxBy(a : Int)
// 2) return 값으로 사용할 수가 있다.

// 람다의 기본 정의
// val lambdaName : Type = {argumentList -> codeBody}

val square : (Int) -> (Int) = {number -> number*number}
// (Int) -> (Int) 는 Type의 Input -> Output

val nameAge = {name : String, age : Int ->
    "my name is ${name}, I'm ${age}."
}

fun main(){
    println(square(3))
    println(nameAge("a1216843", 27))
    val str = "I said "
    println(str.pizzaIsGreat())
    println(extendString("a1216843", 27))
    println(calculateGrade(90))

    val lambda = {
        number : Double ->
        number == 4.3212
    }
    println(invokeLambda(lambda))
    println(invokeLambda {it > 3.22}) // 함수의 마지막 파라미터가 람다식일 때는 "함수명(){}" 으로 표현할 수 있다. 만약 파라미터가 람다식 밖에 없다면 "함수명 {}"로 쓸 수도 있다.
}

// 확장함수
val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name : String, age : Int) : String {
    val introduceMyself : String.(Int) -> String = {
        "I am ${this} and ${it} years old"
    }
    return name.introduceMyself(age)
}

// 람다의 Return
// Type에서 argument는 타입이 여러개일 수 있으니 항상 괄호를 포함해야하고, return은 타입이 항상 하나이므로 괄호 생략 가능
val calculateGrade : (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 람다를 표현하는 여러가지 방법
fun invokeLambda(lambda : (Double) -> Boolean) : Boolean {
    return lambda(5.2343)
}