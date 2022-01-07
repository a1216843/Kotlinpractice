package com.example.kotlinpractice

// 데이터 클래스
// pojo class -> 메소드를 가지고 어떤 행동을 하는 클래스가 아니라 모델이 되는 클래스
data class Ticket(
    val companyName : String,
    val name : String,
    var date : String,
    var seatNumber : Int)

// 데이터 클래스 작성시
// toString(), hashCode(), equals(), copy() 메서드가 자동으로 생성됨
// 또한 데이터 클래스로 생성한 객체를 println으로 출력해보면 객체의 주소가 아닌 객체의 내용이 자동으로 출력됨

fun main(){
    val ticketA = Ticket("MyAir", "a1216843", "2022-01-07", 10)

}