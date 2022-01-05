package com.example.kotlinpractice

class ClassPractice {}

open class Human(val name: String = "default") {

    // Java와 Kotlin의 생성자 사용법은 조금 다르다.
    // Java에선 내부에 Human(name){}와 같은 생성자 블록을 따로 만들었지만,
    // Kotlin에선 클래스를 선언할 때 class Human constructor(name : String){}와 같이 작성하여 기본생성자를 사용한다.
    // constructor 키워드는 생략할 수 있다.
    // class Human (name : String = "default") 처럼 기본 생성자의 default 값을 설정할 수도 있다.

    // constructor를 사용한 생성자 오버로딩 -> 부 생성자
    // 단, 부 생성자를 생성할 때는 주 생성자를 this 키워드로 위임을 받아야 함 -> 주 생성자가 없다면 생략 가능
    constructor(name : String, age : Int) : this(name){
        println("my name is ${name}, ${age}years old")
    }

    // init은 클래스가 인스턴스화할 때 같이 실행되는 코드블럭으로 주 생성자의 일부 -> 항상 부 생성자보다 먼저 실행됨
   init {
        println("New human has born!")
    }

    fun eatingCake() {
        println("This is so yummy")
    }

    open fun singASong(){
        println("lalala")
    }
}

// 상속 -> 상속은 하나만 가능함
// Korean 클래스에서 Human 클래스를 상속할 땐 아래와 같이 쓴다.
// 단 Kotlin에선 각 클래스는 하나의 파일로 간주하기 때문에 Human 클래스를 상속하려면 Human 클래스의 앞에 open 키워드를 붙여주어야 한다.
class Korean : Human() {
    // 오버라이딩도 상속과 마찬가지로 open 키워드가 필요하다.
    // 부모 클래스의 오버라이딩 하려는 메서드를 찾아 open 키워드를 붙여주면 자식 클래스에서 오버라이딩이 가능하다.
    override fun singASong(){
        // 만약 오버라이딩 한 메서드와 함께 부모 클래스의 메서드도 사용하고 싶다면 super 메서드를 사용할 수 있다.
        super.singASong()
        println("라라라")
    }
}

fun main(){
    val human = Human() // Kotlin에선 클래스를 인스턴스화 할 때 new 등의 키워드가 필요 없음
    human.eatingCake()

    println("this human's name is ${human.name}")
}