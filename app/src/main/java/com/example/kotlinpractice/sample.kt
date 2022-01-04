package com.example.kotlinpractice

fun main(){
    // 3. String template
    val name = "a1216843"
    println("my name is $name") //문자열 내에서 변수를 호출하고 싶다면 ${변수명}를 사용

    // tip. 여러 줄 주석처리할 때 코드를 드래그 한 다음 ctrl + / 로 주석처리 가능
}

// 1. 함수
// fun 함수명(파라미터1 이름 : 파리미터1 타입, 파라미터2 이름 : 파라미터2 타입, ...) : 리턴타입 {} 형태로 선언함
// 리턴이 없을 경우 kotlin에선 Unit을 리턴타입으로 줌
fun helloworld() : Unit {
    println("hello")
}

// 2. val vs var
// val == value, 바뀌지 않는 값으로 재할당 불가
// var == variable, 변수
fun hi() {
    val a : Int = 10
    var b : Int = 9
    val c = 100 // 선언과 동시에 할당하는 값이 Int이므로 변수 선언시 타입을 생략하여도 Int라고 알 수 있음
    var d = 100
}

// 4. 조건식
fun maxBy(a : Int, b : Int) : Int {
    if(a > b){
        return a
    }else{
        return b
    }
}

fun maxBy2(a : Int, b : Int) = if(a>b) a else b
// 자바의 삼항 연산자
// return (a>b) ? a : b
// a가 b보다 큰 가? 크다면 a, 아니라면 b

fun checkNum(score : Int) {
    // when은 switch와 같은 역할을 함 score의 값에 따라 다른 코드를 실행하게 함
    when(score){
        0 -> println("this is 0")
        1 -> println("this is 0")
        2, 3 -> println("this is 2 or 3")
        else -> println("I don't know")
    }
    // when은 아래와 같이 리턴값으로도 활용할 수 있는데 이 경우엔 반드시 else 구문이 포함되어야 함
    var b = when(score){
        1 -> 1
        2 -> 2
        else -> 3
    }

    when(score) {
        in 90..100 -> println("Your are genius") // in 90..100 = 90~100의 값들
        in 10..80 -> println("not bad")
        else -> println("okay")
    }
}

// Expression vs Statement
// Expression은 어떤 과정을 거쳐 값을 만든다
// Statement는 값을 만들지 않는 단순한 처리과정을 의미함
// 코틀린의 모든 함수는 Expression이다. 리턴값이 없는 함수도 Unit을 반환하는 Expression이다.
// 자바의 경우 void는 Statement로 사용된다.
// 자바에선 if문이 Statement로만 사용되었지만, 코틀린에선 Expression, Statement로 모두 사용할 수 있다.

// 5. Array and List
//