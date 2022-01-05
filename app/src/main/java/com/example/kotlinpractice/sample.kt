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
// Array는 크기가 변할 수 없음 -> 할당될 때 연속적인 메모리 영역이 정해지기 때문에
// List는 값이 변할 수 없는 일반 List와 변할 수 있는 MutableList로 나뉨
fun array(){
    val array = arrayOf(1, 2, 3) // Array는 값의 변경이 가능함
    val list = listOf(1, 2, 3) // List는 읽기 전용으로 List 내부의 값을 바꿀 수는 없음

    // MutableList의 경우
    var arrayList = arrayListOf<Int>() // 이 경우 arrayList를 val로 선언해도 무방하다. arrayList 내부의 데이터는 변하지만 실제 리스트의 주소는 변하지 않기 때문이다.
    arrayList.add(10)
}

// 6. For and while
fun forAndWhile(){
    // For문 예시
    val students = arrayListOf("A", "B", "C")
    for ( name : String in students){
        println("$name")
    }

    // For문에서 인덱스와 값을 함께 사용하고 싶을 때
    for((index, name) in students.withIndex()){
        println("${index+1}번째 학생 : ${name}")
   }

    var sum = 0
    for(i in 1..10){
        sum += i
    }
    println(sum)
    for(i in 1..10 step 2){} // 1부터 10까지 2씩 증가하면서
    for(i in 10 downTo 1){} // 10부터 1씩 감소하여 1까지
    for(i in 1 until 100){} // 1부터 99까지만, 100은 제외

    // while문 예시
    var index = 0
    while(index < 10){
        println(index)
        index++

    }
}

// 7. Nullable and NotNull
fun nullcheck(){
    //NPE : Null Pointer Exception
    // 자바에선 컴파일 시점이 아닌 실행 시점에서만 NPE를 찾을 수 있었음 -> 코틀린은 컴파일 시점에서 찾을 수 있음

    var name : String = "a1216843" // null이 허용되지 않는 변수
    var nullName : String? = null // null이 허용되는 변수, 단 Nullable은 타입 생략이 불가능함
    var nameInUpperCase = name.toUpperCase() //
    var nullNameInUpperCase = nullName?.toUpperCase() // "nullName?.toUpperCase()"에서 ?의 역할은 nullName이 null이라면 nullName.toUpperCase()가 null을 반환하고, null이 아니라면 함수 실행 결과를 반환한다.

    // ?: 연산자
    val lastName : String? = null
    val fullName = name + (lastName?: "No lastName") // lastName?: "No lastName" 은 lastName이 null이라면 뒤에 오는 값이 lastName을 대체하고, null이 아니라면 그냥 lastName을 사용

    // !! : Nullable 타입의 데이터이지만, 개발자가 null이 아님을 보장할 때 사용함 다만 오남용하지 않도록 조심

    // let 함수
    var email : String? = "a1216843@nate.com"
    // let 메서드는 자신의 리시버 객체(이 경우 email)를 람다식 내부로 옮겨서 실행하는 구문
    email?.let{
        println("my email is ${email}") // 리시버 객체임 email을 내부로 가져와서 println으로 출력
    }
}