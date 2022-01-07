package com.example.kotlinpractice

class sample3 {
}

// Companion Object는 자바의 static 대신 정적 메서드나 정적인 변수를 선언할 때 사용함
//

// private constructor는 다른 곳에서 객체를 생성할 수 없도록 함
class Book private constructor(val id : Int, val name : String){
    // 클래스의 private 변수나 메서드를 읽어올 수 있도록 함
//    companion object {
//        fun create(id: Int, name: String) = Book(id, name)
//    }
    // Companion Object는 따로 이름을 정해줄 수 있고, 상속이 가능하다.
    companion object BookFactory : IdProvider{
        val myBook = "new Book"
        override fun getId() : Int {
            return 444
        }
        fun create2(id : Int, name: String) = Book(getId(), myBook)
    }
}

interface  IdProvider {
    fun getId() : Int
}

fun main(){
    val book = Book.BookFactory.create2(0, "name")
    println(book.id)
}